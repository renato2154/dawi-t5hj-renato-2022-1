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
@Table(name = "tb_proveedor")
public class Provedor {
	@Id
	@Column (name="idprovedor")
	private int codigo;
	@Column (name="nombre_rs")
	private String nombre;
}
