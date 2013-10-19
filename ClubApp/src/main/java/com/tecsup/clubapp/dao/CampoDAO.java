/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.dao;

import com.tecsup.clubapp.helper.ConnectionDB;
import com.tecsup.clubapp.model.Campo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB704-00
 */
public class CampoDAO extends BaseDAO {
    
    public List<Campo> list() throws DAOExcepcion {
        List<Campo> lista = new ArrayList<Campo>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionDB.obtenerConexion();
            String query = "select * from campo order by descripcion;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Campo item = new Campo();
                item.setId(rs.getInt("id"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setEstado(rs.getInt("estado"));
                item.setTipo(rs.getInt("tipo"));
                item.setCostoHora(rs.getDouble("costo_hora"));
                item.setIdLocal(rs.getInt("id_local"));
                lista.add(item);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return lista;
    }
    
}
