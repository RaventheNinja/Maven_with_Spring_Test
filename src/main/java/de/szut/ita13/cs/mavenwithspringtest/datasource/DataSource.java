package de.szut.ita13.cs.mavenwithspringtest.datasource;

import de.szut.ita13.cs.mavenwithspringtest.database.Table;
import java.util.ArrayList;

/**
 * Ein Interface welches die Daten zurückgibt die ausgegeben werden sollen.
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public interface DataSource {
    
    /**
     * Mit getData werden die Daten zurückgegeben für die Konsolenausgabe.
     * @param list Enthält die Tabellenwerte als Liste.
     * @return Einen String für die Konsolenausgabe.  
     */

    String getData(ArrayList<Table> list);

}
