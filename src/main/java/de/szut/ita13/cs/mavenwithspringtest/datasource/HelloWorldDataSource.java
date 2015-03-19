package de.szut.ita13.cs.mavenwithspringtest.datasource;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;

/**
 * HelloWorldDataSource implementiert das Interface DataSource und ist dazu da, 
 * die Daten für die Konsolenausgabe zurückzugeben.
 * Für HelloWordlDataSource wird ein "Hallo Welt!" zurückgegeben.
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class HelloWorldDataSource implements DataSource{
    
    /**
     * Mit getData werden die Daten zurückgegeben für die Konsolenausgabe.
     * @param list Enthält die Tabellenwerte als Liste
     * @return Ein String der "Hallo Welt!" enthält wird zurückgegeben.  
     */
    @Override
    public String getData(List<TableObject> list) {
        return "Hallo Welt!";
    }
}
