package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;

/**
 * Ein Interface um die bestimmten Funktionen für den Datenbankeinsatz auszuführen.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public interface DataAccessObject {
    
    /**
     * Diese Methode ist dazu eine List vom jeweiligen Typen der angefragten Tabelle zurückzugeben.
     * Sie führt eine select Query aus.
     * Beispiel: from Klassennamen where Spaltennamen=:code, Wert der Spalte
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @param value Der Wert der genutzt wurde für eine Bedingung.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    List<TableObject> list(String query, Object value);
    
    /**
     * Die einfache Methode um eine List zurückzubekommen. Hat nur einen Parameter und das ist ein
     * einfacher Query.
     * Beispiel: from Klassennamen
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    List<TableObject> list(String query);

}
