package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_productos")
public class Producto {
	@Id
	@Column(name="id_prod")
	private String codigo; 
	@Column(name="des_prod")
	private String nombre;
	@Column(name="stk_prod")
	private int stock;
	@Column(name="pre_prod")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name ="idcategoria", insertable = false, updatable = false)
	private Categorias categoria;
	
	@Column(name ="idcategoria")
	private int cod_categoria;
	
	@Column(name="est_prod")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name ="idprovedor", insertable = false, updatable = false)
	private Provedor proveedor;
	
	@Column(name ="idprovedor")
	private int idproveedor;
	
	/*
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", cod_categoria=" + cod_categoria + ", estado=" + estado + ", idproveedor=" + idproveedor + "]";
	}

	public Producto(String codigo, String nombre, int stock, double precio, int cod_categoria, int estado,
			int idproveedor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.cod_categoria = cod_categoria;
		this.estado = estado;
		this.idproveedor = idproveedor;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Provedor getProveedor() {
		return proveedor;
	}
	
	public Categorias getCategoria() {
		return categoria;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}
	*/
}
