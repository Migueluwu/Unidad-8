package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clinica database table.
 * 
 */
@Entity
@NamedQuery(name="Clinica.findAll", query="SELECT c FROM Clinica c")
public class Clinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codcli;

	private String direccion;

	private String especialidad;

	private String nombre;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="clinica")
	private List<Mascota> mascotas;

	public Clinica() {
	}

	public int getCodcli() {
		return this.codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setClinica(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setClinica(null);

		return mascota;
	}

	@Override
	public String toString() {
		return "Clinica [codcli=" + codcli + ", direccion=" + direccion + ", especialidad=" + especialidad + ", nombre="
				+ nombre + "]";
	}

}