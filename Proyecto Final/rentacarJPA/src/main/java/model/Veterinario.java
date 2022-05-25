package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the veterinario database table.
 * 
 */
@Entity
@NamedQuery(name="Veterinario.findAll", query="SELECT v FROM Veterinario v")
public class Veterinario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codvet;

	private String apellido;

	private String domicilio;

	private String nif;

	private String nombre;

	private String telefono;

	//uni-directional one-to-one association to Clinica
	@OneToOne
	@JoinColumn(name="codcli")
	private Clinica clinica;

	public Veterinario() {
	}

	public int getCodvet() {
		return this.codvet;
	}

	public void setCodvet(int codvet) {
		this.codvet = codvet;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Veterinario [codvet=" + codvet + ", apellido=" + apellido + ", domicilio=" + domicilio + ", nif=" + nif
				+ ", nombre=" + nombre + ", telefono=" + telefono + ", clinica=" + clinica + "]";
	}

}