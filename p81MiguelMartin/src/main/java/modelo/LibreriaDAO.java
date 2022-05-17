/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel
 */
public class LibreriaDAO implements ILibreria{
    
    private Connection con = null;

    public LibreriaDAO() {
        con = Conexion.getInstance();
    }
    
    
    @Override
    public List<LibreriaVO> getAll() throws SQLException {
        List<LibreriaVO> lista = new ArrayList<>();

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from persona");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                LibreriaVO l = new LibreriaVO();
                // Recogemos los datos de la persona, guardamos en un objeto
                l.setPk(res.getInt("numLibreria"));
                l.setNombre(res.getString("nomLibreria"));
                l.setDireccion(res.getString("dir"));

                //Añadimos el objeto a la lista
                lista.add(l);
            }
        }

        return lista;
    }

    @Override
    public LibreriaVO findByPk(int pk) throws SQLException {
        ResultSet res = null;
        LibreriaVO libreria = new LibreriaVO();

        String sql = "select * from persona where pk=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            // Preparamos la sentencia parametrizada
            prest.setInt(1, pk);

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();

            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa pk
            if (res.next()) {
                // Recogemos los datos de la persona, guardamos en un objeto
                libreria.setPk(res.getInt("numLibreria"));
                libreria.setNombre(res.getString("nomLibreria"));
                libreria.setDireccion(res.getString("dir"));
                return libreria;
            }

            return null;
        }
    }

    @Override
    public int insertLibreria(LibreriaVO libreria) throws SQLException {
        int numFilas = 0;
        String sql = "insert into persona values (?,?,?)";

        if (findByPk(libreria.getPk()) != null) {
            // Existe un registro con esa pk
            // No se hace la inserción
            return numFilas;
        } else {
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            try (PreparedStatement prest = con.prepareStatement(sql)) {

                // Establecemos los parámetros de la sentencia
                prest.setInt(1, libreria.getPk());
                prest.setString(2, libreria.getNombre());
                prest.setString(3, libreria.getDireccion());

                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    @Override
    public int insertLibreria(List<LibreriaVO> lista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteLibreria(LibreriaVO l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteLibreria() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateLibreria(int pk, LibreriaVO nuevosDatos) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
