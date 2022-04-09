package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		// fabrica de acceso de datos
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
		// manejador de entidad
				
		EntityManager em = fabrica.createEntityManager();
				
		// empezar los procesos -- registro, actualizaci�n, eliminaci�n
		em.getTransaction().begin();
				
		// acciones
		Usuario u = em.find(Usuario.class, 55); // si existe el id, devuelve el objeto
												// sino existe = null
		if(u != null) {
			System.out.println(u);
		}
		else {
			System.out.println("El c�digo no existe");
		}
		em.close();
		u.setCodigo(50);
		
		em.remove(u);
				
		// confirmacion de procesos
		em.getTransaction().commit();
				
		// cerrar manejador
		em.close();
	}
}
