package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_categorias")
public class Categorias {
	@Id
	@Column(name="idcategoria")
	private int codigo;
	@Column(name="descripcion")
	private String nombre;
	/*
	@Override
	public String toString() {
		return "Categorias [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	public Categorias(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Categorias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	*/
}
