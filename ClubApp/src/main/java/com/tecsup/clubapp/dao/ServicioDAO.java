/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.dao;

import com.tecsup.clubapp.model.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import zelper.ConexionDB;

/**
 *
 * @author LAB704-00
 */
public class ServicioDAO extends BaseDAO{
    
     public Collection<Servicio> listar() throws DAOExcepcion {
		Collection<Servicio> servicio = new ArrayList<Servicio>();
		//Lista de Categorias
                Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionDB.obtenerConexion();
			// Conexion al la BD
                        String query = "select * from servicio";
			stmt = con.prepareStatement(query);
			// Linea de consulta
                        rs = stmt.executeQuery();
                        // Resultados
			while (rs.next()) {
				Servicio item = new Servicio();
				item.setId(rs.getInt("id"));
				item.setDescripcion(rs.getString("descripcion"));
				item.setCostoHora(rs.getDouble("costo_hora"));
				servicio.add(item);
                                // lista que  se carga con la informacion
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return servicio;
	}
    
    
    
}
