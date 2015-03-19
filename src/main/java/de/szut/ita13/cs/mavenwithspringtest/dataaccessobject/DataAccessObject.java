/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;

/**
 *
 * @author christian
 */
public interface DataAccessObject {

    void save(TableObject tableObject);

    void update(TableObject tableObject);

    void delete(TableObject tableObject);
    
    List<TableObject> list(String query, Object value);

}
