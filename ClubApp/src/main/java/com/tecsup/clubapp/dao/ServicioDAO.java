/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.dao;

import com.tecsup.clubapp.model.Servicio;

/**
 *
 * @author LAB704-00
 */
public class ServicioDAO extends app.dao.BaseDAO{
    
     public Collection<Servicio> listar() throws DAOExcepcion {
		Collection<Categoria> c = new ArrayList<Categoria>();
		//Lista de Categorias
                Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionDB.obtenerConexion();
			// Conexion al la BD
                        String query = "select id,nombre,descripcion from categoria order by nombre";
			stmt = con.prepareStatement(query);
			// Linea de consulta
                        rs = stmt.executeQuery();
                        // Resultados
			while (rs.next()) {
				Categoria item = new Categoria();
				item.setId(rs.getInt("id"));
				item.setNombre(rs.getString("nombre"));
				item.setDescripcion(rs.getString("descripcion"));
				c.add(item);
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
		return c;
	}
    
    
    
}
