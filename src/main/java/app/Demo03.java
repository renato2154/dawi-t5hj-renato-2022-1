package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		// eliminar un usuario
		
		// fabrica de acceso de datos
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
		// manejador de entidad
				
		EntityManager em = fabrica.createEntityManager();
		
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
		
		// acciones
		// forma 1 delete where codigo = borrado físico
		// forma 2 update estado where codigo = borrado lógico (cambiar estado)
		Usuario u = new Usuario();
		u.setCodigo(50);
		
		em.remove(u);
				
		// confirmacion de procesos
		em.getTransaction().commit();
				
		// cerrar manejador
		em.close();
	}
}
