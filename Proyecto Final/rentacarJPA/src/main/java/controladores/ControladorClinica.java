package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Clinica;



public class ControladorClinica {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicasvet");
	private EntityManager em;
	private Query consulta;

	public void borrarClinica(Clinica c) {
		this.em = entityManagerFactory.createEntityManager();
		Clinica aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarClinica(Clinica c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearClinica(Clinica c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Clinica findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Clinica aux = null;
		this.consulta = em.createNativeQuery("Select * from clinica where codcli = ?", Clinica.class);
		this.consulta.setParameter(1, pk);
		try {
			aux = (Clinica) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}
	
	public Clinica findByNombre(String nombre) {
		this.em = entityManagerFactory.createEntityManager();
		Clinica aux = null;
		this.consulta = em.createNativeQuery("Select * from clinica where nombre = ?", Clinica.class);
		this.consulta.setParameter(1, nombre);
		try {
			aux = (Clinica) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}

	public List<Clinica> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Clinica.findAll");
		List<Clinica> lista = (List<Clinica>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
