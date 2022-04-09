package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		// actualizar un usuario
		
		// fabrica de acceso de datos
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
		// manejador de entidad
		
		EntityManager em = fabrica.createEntityManager();
		
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
				
		// acciones
		Usuario u = new Usuario(40, "Juan","Perez","japerez@gmail.com","5555","2012/11/01", 2, 1);
		em.merge(u); //si existe el codigo, lo actualiza, sino lo crea
				
		// confirmacion de procesos
		em.getTransaction().commit();
		
		// cerrar manejador
		em.close();
	}
}
