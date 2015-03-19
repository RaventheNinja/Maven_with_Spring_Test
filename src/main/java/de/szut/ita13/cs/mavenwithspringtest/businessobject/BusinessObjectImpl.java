package de.szut.ita13.cs.mavenwithspringtest.businessobject;

import de.szut.ita13.cs.mavenwithspringtest.dataaccessobject.DataAccessObject;
import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author christian
 */
@Service
public class BusinessObjectImpl implements BusinessObject{
    
    @Autowired
    DataAccessObject dao;
    
    public void setDataAccessObject (DataAccessObject dao){
        this.dao = dao;
    }

    @Override
    public void save(TableObject tableObject) {
        dao.save(tableObject);
    }

    @Override
    public void update(TableObject tableObject) {
        dao.update(tableObject);
    }

    @Override
    public void delete(TableObject tableObject) {
        dao.delete(tableObject);
    }

    @Override
    public List<TableObject> list(String query, Object value) {
        return dao.list(query, value);
    }
    
}
