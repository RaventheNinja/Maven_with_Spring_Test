/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.Example;
import java.util.List;

/**
 *
 * @author christian
 */
public interface DataAccessObject {

    void save(Example example);

    void update(Example example);

    void delete(Example example);
    
    List<Example> list();

    Example findByExampleCode(String exampleCode);

}
