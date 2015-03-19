package de.szut.ita13.cs.mavenwithspringtest.businessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;

/**
 *
 * @author christian
 */
public interface BusinessObject {
    
    void save(TableObject tableObject);
    void update(TableObject tableObject);
    void delete (TableObject tableObject);
    List<TableObject> list(String query, Object value);
}
