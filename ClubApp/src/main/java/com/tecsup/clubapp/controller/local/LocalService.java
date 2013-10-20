
package com.tecsup.clubapp.controller.local;

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
    
    public List<Local> list() {
        return localDAO.list();
    }

    public Local get(Local local) {
        return localDAO.get(local);
    }

    public Local save(Local local) {
        return localDAO.save(local);
    }
    
    public Local update(Local local) {
        return localDAO.update(local);
    }
    
    public void delete(Local local) {
        localDAO.delete(local);
    }
}
