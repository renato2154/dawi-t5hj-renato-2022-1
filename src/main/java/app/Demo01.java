package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	public static void main(String[] args) {
		// registrar un nuevo usuario
		
		// fabrica de acceso de datos
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// manejador de entidad
		
		EntityManager em = fabrica.createEntityManager();
		
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
		
		// acciones
		Usuario u = new Usuario(40, "Juan","Perez","mperez@gmail.com","1234","2012/01/01", 1, 1);
		em.persist(u);
		
		// confirmacion de procesos
		em.getTransaction().commit();
		
		// cerrar manejador
		em.close();
	}
}
