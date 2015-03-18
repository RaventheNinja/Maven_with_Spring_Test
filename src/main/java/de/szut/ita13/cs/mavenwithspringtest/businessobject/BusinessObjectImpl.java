package de.szut.ita13.cs.mavenwithspringtest.businessobject;

import de.szut.ita13.cs.mavenwithspringtest.dataaccessobject.DataAccessObject;
import de.szut.ita13.cs.mavenwithspringtest.database.Example;
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
    public void save(Example example) {
        dao.save(example);
    }

    @Override
    public void update(Example example) {
        dao.update(example);
    }

    @Override
    public void delete(Example example) {
        dao.delete(example);
    }

    @Override
    public Example findByExampleCode(String exampleCode) {
        return dao.findByExampleCode(exampleCode);
    }

    @Override
    public List<Example> list() {
        return dao.list();
    }
    
}
