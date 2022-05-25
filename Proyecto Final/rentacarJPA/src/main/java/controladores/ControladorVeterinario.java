package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Veterinario;

public class ControladorVeterinario {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicasvet");
	private EntityManager em;
	private Query consulta;

	public void borrarVeterinario(Veterinario v) {
		this.em = entityManagerFactory.createEntityManager();
		Veterinario aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(v)) {
			aux = this.em.merge(v);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public void modificarVeterinario(Veterinario v) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(v);
		this.em.getTransaction().commit();
		this.em.close();

	}

	public void crearVeterinario(Veterinario v) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(v);
		this.em.getTransaction().commit();
		this.em.close();
	}

	public Veterinario findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Veterinario aux = null;
		this.consulta = em.createNativeQuery("Select * from veterinario where codvet = ?", Veterinario.class);
		this.consulta.setParameter(1, pk);
		
		try {
			aux = (Veterinario) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		
		this.em.close();
		return aux;

	}
	


	public List<Veterinario> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Veterinario.findAll");
		List<Veterinario> lista = (List<Veterinario>) consulta.getResultList();
		this.em.close();
		return lista;
	}

}
