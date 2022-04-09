package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import app.FrmManteProd;

public class Login {
	public static void main(String[] args) {
		String usuario, clave;
		usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		clave = JOptionPane.showInputDialog("Ingrese clave: ");
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// manejador de entidad
				
		EntityManager em = fabrica.createEntityManager();
				
		// empezar los procesos -- registro, actualización, eliminación
		em.getTransaction().begin();
				
		// acciones
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.nombre = :xusr and u.clave = :xpswd", Usuario.class);
		consulta.setParameter("xusr", usuario);
		consulta.setParameter("xpswd", clave);
		Usuario u = consulta.getSingleResult();
		
		//List<Usuario> lstUsuarios = em.createQuery("select x from tb_usuarios x", Usuario.class).getResultList();
		
		try {
			System.out.println(u);
			FrmManteProd frm = new FrmManteProd();
			frm.setVisible(true);
		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			System.out.println(e2.getMessage());
		}
	}
}
