package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Mascota;



public class ControladorMascota {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicasvet");
	private EntityManager em;
	private Query consulta;

	public void borrarMascota(Mascota m) {
		this.em = entityManagerFactory.createEntityManager();
		Mascota aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(m)) {
			aux = this.em.merge(m);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarMascota(Mascota m) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(m);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearMascota(Mascota c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Mascota findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Mascota aux = null;
		this.consulta = em.createNativeQuery("Select * from mascota where codmas = ?", Mascota.class);
		this.consulta.setParameter(1, pk);
		
		try {
			aux = (Mascota) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}

		this.em.close();
		return aux;

	}

	public List<Mascota> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Mascota.findAll");
		List<Mascota> lista = (List<Mascota>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
