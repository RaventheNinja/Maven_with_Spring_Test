package de.szut.ita13.cs.mavenwithspringtest.businessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.Example;
import java.util.List;

/**
 *
 * @author christian
 */
public interface BusinessObject {
    
    void save(Example example);
    void update(Example example);
    void delete (Example example);
    Example findByExampleCode(String exampleCode);
    List<Example> list();
}
