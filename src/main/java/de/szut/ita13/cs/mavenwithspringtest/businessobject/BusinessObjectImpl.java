package de.szut.ita13.cs.mavenwithspringtest.businessobject;

import de.szut.ita13.cs.mavenwithspringtest.dataaccessobject.DataAccessObject;
import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Eine Klasse die das Interface BusinessObject implementiert. Sie hinterlegt die
 * Methoden für den Datenbankeinsatz. Durch die Annotation @Service weis Spring
 * das diese Klasse vom Stereotyp Service ist und nur für sowas zuständig ist.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
@Service
public class BusinessObjectImpl implements BusinessObject{
    
    /** Durch die Annotation wird die Klasse durch Spring geladen. */
    @Autowired
    DataAccessObject dao;
    
    /**
     * Die set-Methode muss da sein damit Autowired das Objekt auch injiktieren kann.
     * @param dao Die Klasse DataAccessObject.
     */
    public void setDataAccessObject (DataAccessObject dao){
        this.dao = dao;
    }

    /**
     * Diese Methode ist dazu eine List vom jeweiligen Typen der angefragten Tabelle zurückzugeben.
     * Sie führt eine select Query aus.
     * Beispiel: from Klassennamen where Spaltennamen=:code, Wert der Spalte
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @param value Der Wert der genutzt wurde für eine Bedingung.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    @Override
    public List<TableObject> list(String query, Object value) {
        return dao.list(query, value);
    }
    
    /**
     * Die einfache Methode um eine List zurückzubekommen. Hat nur einen Parameter und das ist ein
     * einfacher Query.
     * Beispiel: from Klassennamen
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    @Override
    public List<TableObject> list(String query) {
        return dao.list(query);
    }
    
}
