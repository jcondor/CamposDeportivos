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
    
    public static Collection<Local> listar() throws DAOExcepcion {
		LocalDAO dao = new LocalDAO();
                return dao.list();
    }

}
