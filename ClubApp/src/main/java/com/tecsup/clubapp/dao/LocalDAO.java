/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.dao;

import com.tecsup.clubapp.helper.ConnectionDB;
import com.tecsup.clubapp.model.Local;
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
public class LocalDAO extends BaseDAO {
    
    public Collection<Local> listar() throws DAOExcepcion {
		Collection<Local> c = new ArrayList<Local>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.obtenerConexion();
			String query = "select id, direccion, descripcion, estado, maps, telefono from local order by direccion";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Local vo = new Local();
				vo.setId(rs.getInt("id"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setDescripcion(rs.getString("descripcion"));
                                vo.setEstado(rs.getInt("estado"));
                                vo.setMaps(rs.getString("maps"));
                                vo.setTelefono(rs.getString("telefono"));
				c.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
    
    public Local insertar(Local vo) throws DAOExcepcion {
		String query = "insert into local(direccion,descripcion) values (?,?);";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getDireccion());
			stmt.setString(2, vo.getDescripcion());
			int i = stmt.executeUpdate();
		
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

