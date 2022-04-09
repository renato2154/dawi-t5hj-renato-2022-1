package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		// eliminar v2
		// fabrica de acceso de datos
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
		// manejador de entidad
				
		EntityManager em = fabrica.createEntityManager();
		
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
				
		// acciones
		Usuario u = em.find(Usuario.class, 50);
		if (u != null) {
			em.remove(u);
		}
		else {
			System.out.println("Código no encontrado");
		}
				
		// confirmacion de procesos
		em.getTransaction().commit();
				
		// cerrar manejador
		em.close();
	}
}
