package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.Example;
import de.szut.ita13.cs.mavenwithspringtest.util.CustomHibernateDaoSupport;
import java.util.List;
import javax.transaction.Transactional;
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
    public void save(Example example) {
        getHibernateTemplate().save(example);
    }

    @Override
    public void update(Example example) {
        getHibernateTemplate().update(example);
    }

    @Override
    public void delete(Example example) {
        getHibernateTemplate().delete(example);
    }

    @Override
    public Example findByExampleCode(String exampleCode) {
        List list = getHibernateTemplate().find("from example where id=?", exampleCode);
        return (Example) list.get(0);
    }
    
    @Transactional
    @Override
    public List<Example> list() {
        return (List<Example>)sf.getCurrentSession().createQuery("from Example").list();
    }
    
}
