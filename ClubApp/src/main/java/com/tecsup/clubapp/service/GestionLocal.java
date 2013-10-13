/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.service;

import com.tecsup.clubapp.dao.DAOExcepcion;
import com.tecsup.clubapp.dao.LocalDAO;
import com.tecsup.clubapp.model.Local;
import java.util.Collection;

/**
 *
 * @author LAB704-00
 */
public class GestionLocal {
    public static void main(String[] args) throws DAOExcepcion {
        listar();
    }
    
    public static void  listar() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
                
                Local local = new Local();
                local.setDireccion("Arequipa");
                local.setDescripcion("Primer ejemplo");
        
                dao.insertar(local);
		
                Collection<Local> locales = dao.listar();
                        for(Local localx: locales){
                            System.out.println(
                                    localx.getId()+" "+ 
                                    localx.getDireccion()+" "+
                                    localx.getDescripcion()+" "+
                                    localx.getEstado()+" "+
                                    localx.getMaps()+" "+
                                    localx.getTelefono());
                        }
              
	}

}
