/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author miguel
 */
public interface ILibreria {
    List<LibreriaVO> getAll() throws SQLException;
    
    // Méodo para obtener un registro a partir de la PK
    LibreriaVO findByPk(int pk) throws SQLException;
    
    // Método para insertar un registro
    int insertLibreria (LibreriaVO libreria) throws SQLException;
    
    // Método para insertar varios registros
    int insertLibreria (List<LibreriaVO> lista) throws SQLException;
    
    // Método para borrar una persona
    int deleteLibreria (LibreriaVO l) throws SQLException;
    
    // Método para borrar toda la tabla
    int deleteLibreria() throws SQLException;
    
    // Método para modificar una persona. Se modifica a la persona que tenga esa 'pk'
    // con los nuevos datos que traiga la persona 'nuevosDatos'
    int updateLibreria (int pk, LibreriaVO nuevosDatos) throws SQLException;
}
