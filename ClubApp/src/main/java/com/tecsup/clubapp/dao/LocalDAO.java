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
                                vo.setMaps(rs.getString("map"));
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
    
 /*   public Collection<Local> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select id_categoria, nombre, descripcion from categoria where nombre like ?";
		Collection<Categoria> lista = new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria vo = new Categoria();
				vo.setId(rs.getInt("id_categoria"));
				vo.setNombre(rs.getString("nombre"));
				//vo.setDescripcion(rs.getString("descripcion"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public Categoria insertar(Categoria vo) throws DAOExcepcion {
		String query = "insert into categoria(nombre,descripcion) values (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
//			stmt.setString(2, vo.getDescripcion());
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

	public Categoria obtener(int idCategoria) throws DAOExcepcion {
		Categoria vo = new Categoria();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select id_categoria, nombre, descripcion from categoria where id_categoria=?";
			con = ConectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				//vo.setDescripcion(rs.getString(3));
			}
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

	public void eliminar(int idCategoria) throws DAOExcepcion {
		String query = "delete from categoria WHERE id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Categoria actualizar(Categoria vo) throws DAOExcepcion {
		String query = "update categoria set nombre=?,descripcion=? where id_categoria=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConectionDB.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
		//	stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getId());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

    private void cerrarResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cerrarStatement(PreparedStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cerrarConexion(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 */
	
    
}
