/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.service;

import com.tecsup.clubapp.dao.DAOExcepcion;
import com.tecsup.clubapp.dao.ServicioDAO;
import com.tecsup.clubapp.model.Servicio;
import java.util.Collection;

/**
 *
 * @author LAB704-00
 */
public class GestionServicios {
    
    public static void main(String[] args) throws DAOExcepcion{
        GestionServicios.listar();
    }
    
    
    public static void  listar() throws DAOExcepcion {
		ServicioDAO dao = new ServicioDAO();
		Collection<Servicio> servicios = dao.listar();
                        for(Servicio servicio: servicios){
                            System.out.println(servicio.getId()+" "+ servicio.getDescripcion()+" "+ servicio.getCostoHora());
                        }
              
	}

}
