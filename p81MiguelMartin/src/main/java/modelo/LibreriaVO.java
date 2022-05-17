/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author miguel
 */
public class LibreriaVO {
    private int pk;
    private String nombre;
    private String direccion;

    public LibreriaVO() {
    }

    public LibreriaVO(int pk, String nombre, String direccion) {
        this.pk = pk;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "LibreriaVO{" + "pk=" + pk + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    
}
