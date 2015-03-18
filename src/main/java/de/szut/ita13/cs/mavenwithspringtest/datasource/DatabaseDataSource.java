package de.szut.ita13.cs.mavenwithspringtest.datasource;

import de.szut.ita13.cs.mavenwithspringtest.database.Table;
import java.util.ArrayList;

/**
 * DatabaseDataSource implementiert das Interface DataSource und ist dazu da die,
 * Daten für die Konsolenausgabe zurückzugeben. Sie lädt die Einstellungen zum
 * Verbinden auf die Datenbank aus der Klasse DatabaseSettings. In einer
 * ArrayList die vom "Table" werden das Objekt der Tabelle gespeichert.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class DatabaseDataSource implements DataSource {
    
    
    /**
     * Mit getData werden die Daten zurückgegeben für die Konsolenausgabe.
     * Zusätzlich verbindet sich die Applikation mit der Datenbank und führt einen Query aus.
     * @param list Enthält die Objekt Information der Datenbanktabelle.
     * @return Ein String der "Hallo Welt!" enthält wird zurückgegeben. 
     */
    @Override
    public String getData(ArrayList<Table> list) {
        StringBuilder sb = new StringBuilder();

            // Itteriert durch die gesamte ArrayList und ruft die Methode output vom jeweilgen Objekt auf. Die Methode fügt
            // die Attribute der Tabelle in einem StringBuilder zusammen.
            for (Table t : list) {  //for-each: gehe für jedes Table t aus tableArray
                t.output(sb);
            }

        return sb.toString();
    }
}
