/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.LibreriaDAO;
import modelo.LibreriaVO;
/**
 *
 * @author miguel
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LibreriaDAO libreriaDAO=new LibreriaDAO();
        ArrayList<LibreriaVO> listaLibreria=new ArrayList<>();
        listaLibreria.add(new LibreriaVO(1, "Libreria Central", "C/ Central nº55"));
        listaLibreria.add(new LibreriaVO(2, "Libreria del Sur", "C/ Sur nº33"));
        listaLibreria.add(new LibreriaVO(3, "Libreria del Norte", "C/ Norte nº66"));
        listaLibreria.add(new LibreriaVO(4, "Libreria del Este", "C/ Este nº22"));
        listaLibreria.add(new LibreriaVO(4, "Libreria del Oeste", "C/ Oeste nº44"));
        try {
            /// Insertar valores en la tabla
            System.out.println("Nº personas insertadas " + libreriaDAO.insertLibreria(listaLibreria));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<LibreriaVO> nuevaLista = libreriaDAO.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            ////buscar por pk
            System.out.println("Persona con primary key 1: ");
            System.out.println(libreriaDAO.findByPk(1));
            System.out.println("Borramos la persona con pk 3");
            System.out.println("Nº personas borradas " + 
                    libreriaDAO.deleteLibreria(3));
            System.out.println("Modificación de la libreria con pk 2");
            System.out.println("Nº Personas modificadas " + 
                    libreriaDAO.updateLibreria(2,
                            new LibreriaVO(6,"Libreria Noreste", "C/ Noreste nº 88")));
            System.out.println("Borramos todo");
            libreriaDAO.deleteLibreria();
            nuevaLista = libreriaDAO.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
    }
    
}
