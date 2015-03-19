package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import de.szut.ita13.cs.mavenwithspringtest.util.CustomHibernateDaoSupport;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author christian
 */
@Repository
public class DataAccessObjectImpl extends CustomHibernateDaoSupport implements DataAccessObject{

    @Autowired
    private SessionFactory sf;
    
    @Override
    public void save(TableObject tableObject) {
        getHibernateTemplate().save(tableObject);
    }

    @Override
    public void update(TableObject tableObject) {
        getHibernateTemplate().update(tableObject);
    }

    @Override
    public void delete(TableObject tableObject) {
        getHibernateTemplate().delete(tableObject);
    }
    
    @Transactional
    @Override
    public List<TableObject> list(String query, Object value) {
        return (List<TableObject>)sf.getCurrentSession().createQuery(query).setParameter("code", value).list();
    }
    
}
