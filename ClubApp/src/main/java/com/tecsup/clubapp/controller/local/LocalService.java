/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.clubapp.controller.local;

import com.tecsup.clubapp.dao.DAOExcepcion;
import com.tecsup.clubapp.dao.LocalDAO;
import com.tecsup.clubapp.model.Local;
import java.util.List;

/**
 *
 * @author LAB704-00
 */
public class LocalService {
        
    private LocalDAO localDAO = null;
    
    public LocalService(){
        localDAO = new LocalDAO();
    }
    
    public List<Local> list() throws DAOExcepcion {
        return localDAO.list();
    }

    public Local get(Local local) throws DAOExcepcion {
        return localDAO.get(local);
    }

    public Local save(Local local) throws DAOExcepcion {
        return localDAO.save(local);
    }
    
    public Local update(Local local) throws DAOExcepcion {
        return localDAO.update(local);
    }
    
    public void delete(Local local) throws DAOExcepcion {
        localDAO.delete(local);
    }
}
