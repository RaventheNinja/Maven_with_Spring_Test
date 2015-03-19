package de.szut.ita13.cs.mavenwithspringtest.dataaccessobject;

import de.szut.ita13.cs.mavenwithspringtest.database.TableObject;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Eine Klasse die das Interface DataAccessObject implementiert. Sie ruft die
 * Methoden für den Datenbankeinsatz auf. Durch die Annotation @Repository weis Spring
 * das diese Klasse vom Stereotyp Repository ist und nun als Behälter zuständig ist.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
@Repository
public class DataAccessObjectImpl implements DataAccessObject{
    
    /** 
     * Durch die Annotation wird die Klasse durch Spring geladen. 
     * SessionFactory generiert gecachte SQL Aussagen die Hibernate während
     * der Laufzeit nutzt.
     */
    @Autowired
    private SessionFactory sf;
    
    /**
     * Diese Methode ist dazu eine List vom jeweiligen Typen der angefragten Tabelle zurückzugeben.
     * Sie führt eine select Query aus. Dadurch das die Annotation @Transactional über der Methode
     * steht, wird die SQL Verbindung als Transaktion ausgeführt, d.h. wenn eine Sache
     * fehlschlägt, wird die komplette Transaktion abgebrochen und auf den Werkzustand
     * zurückgesetzt.
     * Beispiel: from Klassennamen where Spaltennamen=:code, Wert der Spalte
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @param value Der Wert der genutzt wurde für eine Bedingung.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    @Transactional
    @Override
    public List<TableObject> list(String query, Object value) {
        return sf.getCurrentSession().createQuery(query).setParameter("code", value).list();
    }
    
     /**
     * Die einfache Methode um eine List zurückzubekommen. Hat nur einen Parameter und das ist ein
     * einfacher Query.
     * Dadurch das die Annotation @Transactional über der Methode
     * steht, wird die SQL Verbindung als Transaktion ausgeführt, d.h. wenn eine Sache
     * fehlschlägt, wird die komplette Transaktion abgebrochen und auf den Werkzustand
     * zurückgesetzt.
     * Beispiel: from Klassennamen
     * 
     * @param query Das Query welches in HQL geschrieben wurde.
     * @return Gibt eine List vom Typen der jeweiligen Klasse der Tabelle zurück.
     */
    @Transactional
    @Override
    public List<TableObject> list(String query) {
        return sf.getCurrentSession().createQuery(query).list();
    }
}
