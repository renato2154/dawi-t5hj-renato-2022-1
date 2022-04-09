package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	public static void main(String[] args) {
		// listado de los usuarios
		// fabrica de acceso de datos
				
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
		// manejador de entidad
				
		EntityManager em = fabrica.createEntityManager();
				
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
				
		// acciones
		TypedQuery<Usuario> consulta = em.createQuery("select u from tb_usuarios u where u.tipo = :xtipo", Usuario.class);
		consulta.setParameter("xtipo", 2);
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		//List<Usuario> lstUsuarios = em.createQuery("select x from tb_usuarios x", Usuario.class).getResultList();
		
		for (Usuario usuario : lstUsuarios) {
			System.out.println(usuario);
		}
				
		// confirmacion de procesos
		em.getTransaction().commit();
						
		// cerrar manejador
		em.close();
	}
}
