package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	@Override
	public String toString() {
		return "Mascota [codmas=" + codmas + ", descrip=" + descrip + ", nombre=" + nombre + ", raza=" + raza
				+ ", telefono=" + telefono + ", clinica=" + clinica.getCodcli() + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codmas;

	private String descrip;

	private String nombre;

	private String raza;

	private String telefono;

	//bi-directional many-to-one association to Clinica
	@ManyToOne
	@JoinColumn(name="codcli")
	private Clinica clinica;

	public Mascota() {
	}

	public int getCodmas() {
		return this.codmas;
	}

	public void setCodmas(int codmas) {
		this.codmas = codmas;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Clinica getClinica() {
		return this.clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

}