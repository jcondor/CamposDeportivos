/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.service;

import com.tecsup.clubapp.dao.DAOExcepcion;
import com.tecsup.clubapp.dao.LocalDAO;
import com.tecsup.clubapp.dao.ServicioDAO;
import com.tecsup.clubapp.model.Local;
import com.tecsup.clubapp.model.Servicio;
import java.util.Collection;

/**
 *
 * @author LAB704-00
 */
public class GestionLocal {
    public static void main(String[] args) throws DAOExcepcion {
        GestionLocal.listar();
    }
    
    public static void  listar() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
		Collection<Local> locales = dao.listar();
                        for(Local local: locales){
                            System.out.println(
                                    local.getId()+" "+ 
                                    local.getDireccion()+" "+
                                    local.getDescripcion()+" "+
                                    local.getEstado()+" "+
                                    local.getMaps()+" "+
                                    local.getTelefono());
                        }
              
	}
}
