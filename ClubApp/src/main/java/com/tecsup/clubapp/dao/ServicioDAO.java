/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.dao;

import com.tecsup.clubapp.helper.ConnectionDB;
import com.tecsup.clubapp.model.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


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
			con = ConnectionDB.obtenerConexion();
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

    public Servicio insertar(Servicio vo) throws DAOExcepcion {
		String query = "insert into servicio(descripcion,costo_hora) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDescripcion());
			stmt.setDouble(2, vo.getCostoHora());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "select last_insert_id()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setId(id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
    
    
    
}
