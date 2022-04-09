package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Producto;
import model.Provedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	JComboBox cboProvedor;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		cboProvedor = new JComboBox();
		cboProvedor.setBounds(210, 103, 86, 22);
		contentPane.add(cboProvedor);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EntityManagerFactory fab = Persistence.createEntityManagerFactory("mysql");
					EntityManager em = fab.createEntityManager();
					em.getTransaction().begin();
					Producto prod = new Producto();
					prod.setCodigo(txtCódigo.getText());
					prod.setNombre(txtDescripcion.getText());
					prod.setCod_categoria(cboCategorias.getSelectedIndex());
					prod.setStock(Integer.parseInt(txtStock.getText()));
					prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
					prod.setEstado(1);
					prod.setCod_categoria(cboCategorias.getSelectedIndex());
					prod.setIdproveedor(cboProvedor.getSelectedIndex());
					em.merge(prod);
					em.getTransaction().commit();
					em.close();
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizar.setBounds(324, 63, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EntityManagerFactory fab = Persistence.createEntityManagerFactory("mysql");
					EntityManager em = fab.createEntityManager();
					em.getTransaction().begin();
					Producto prod = new Producto();
					prod.setCodigo(txtCódigo.getText());
					em.remove(prod);
					em.getTransaction().commit();
					em.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(324, 97, 89, 23);
		contentPane.add(btnEliminar);
		
		llenaCombo();
	}

	void llenaCombo() {
		try {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			TypedQuery<Categorias> consulta = em.createQuery("select u from Categorias u", Categorias.class);
			List<Categorias> lstCategorias = consulta.getResultList();
			cboCategorias.addItem("Selecciona categoria..");
			for (Categorias c: lstCategorias) {
				cboCategorias.addItem(c.getNombre());
			}
			
			TypedQuery<Provedor> consulta2 = em.createQuery("select u from Provedor u", Provedor.class);
			List<Provedor> lstProveedor = consulta2.getResultList();
			cboProvedor.addItem("Selecciona categoria..");
			for (Provedor p: lstProveedor) {
				cboProvedor.addItem(p.getNombre());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void listado() {
		/*
		try {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			TypedQuery<Producto> consulta = em.createQuery("select x from tb_productos x", Producto.class);
			List<Producto> lista = consulta.getResultList();
			for (Producto prod: lista) {
				txtSalida.setText(prod.toString());
			}
			em.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		*/
		try {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
			// -- combo categorias
			TypedQuery<Producto> consulta = 
					em.createQuery("select u from Producto u", Producto.class);
			List<Producto> lstProductos = consulta.getResultList();
			txtSalida.setText("");
			for (Producto p : lstProductos) {
				txtSalida.append("Código....: " + p.getCodigo()+"\n");
				txtSalida.append("Nombre....: " + p.getNombre()+"\n");
				txtSalida.append("Precio....: " + p.getPrecio()+"\n");
				txtSalida.append("Categoría.: " + p.getCategoria().getNombre()+"\n");
				txtSalida.append("Proveedor.: " + p.getProveedor().getNombre()+"\n");
				txtSalida.append("****************************************\n");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void registrar() {
		try {
			EntityManagerFactory fab = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fab.createEntityManager();
			em.getTransaction().begin();
			Producto prod = new Producto();
			prod.setCodigo(txtCódigo.getText());
			prod.setNombre(txtDescripcion.getText());
			prod.setCod_categoria(cboCategorias.getSelectedIndex());
			prod.setStock(Integer.parseInt(txtStock.getText()));
			prod.setPrecio(Double.parseDouble(txtPrecio.getText()));
			prod.setEstado(1);
			prod.setCod_categoria(cboCategorias.getSelectedIndex());
			prod.setIdproveedor(cboProvedor.getSelectedIndex());
			em.persist(prod);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}