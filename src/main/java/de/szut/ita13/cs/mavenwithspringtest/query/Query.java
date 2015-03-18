package de.szut.ita13.cs.mavenwithspringtest.query;

import de.szut.ita13.cs.mavenwithspringtest.database.Table;
import de.szut.ita13.cs.mavenwithspringtest.util.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

/**
 * Die Klasse Query ist dazu da, Queries auszuführen, damit der Nutzer keine eigenen SQL Befehle mehr eingeben muss.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class Query {
    
    /** Logger ist ein spezieller Logger der von Maven als Plugin implementiert wurde. */ 
    private final static transient Logger LOG = Logger.getLogger(Query.class);
    /**  Klasse die aufgerufen werden soll um die Tabellendaten in ein Objekt zu speichern. */
    private final Class<? extends Table> dataTableClass;
    /** Wird zum Speichern der Werte des Objekts benötigt. */ 
    private final ArrayList<Table> tableList = new ArrayList();
    /** Connection wird dazu verwendet um eine Verbindung mit der Datenbank herzustellen. */
    private final Connection con = null;
    /** PreparedStatements werden dazu verwendet um Queries auszuführen. PreparedStatements können auch Variablen annehmen. */
    private final PreparedStatement ps = null;
    /** ResultSet erhält das Ergebnis vom SQL Befehl. */
    private final ResultSet rs = null;

    /**
     * Konstruktor der die Klasse als Parameter aufnimmt um die Tabellendaten in das vorhergesehene Objekt zu speichern.
     * @param targetClass Dazu da die Werte der Tabelle in das vorhergesehene Objekt zu speichern.
     */
    public Query (final Class<? extends Table> targetClass) {
        this.dataTableClass = targetClass;
    }
    
    /**
     * Diese Methode speichert die Werte des Tabellenobjekts in eine Liste.
     * @param qc Beinhaltet die Klasse QueryConfiguration.
     * @param context
     */
    public void select (QueryConfiguration qc, ApplicationContext context) {
        try {
            ResultSet rs = Helper.mySqlPreparation(qc, context).executeQuery();
            while (rs.next()) {
                // Es wird das Objekt zurückgeliefert was in der settify Methode von der Helper Klasse befüllt wird.
                Table ta =  Helper.settify(rs, dataTableClass);
                // Fügt der ArrayList das Objekt hinzu was erstellt wurde.
                tableList.add(ta);
            }
        } catch (Exception ex) {
            LOG.debug(ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOG.debug("SQL Fehler: ", ex);
            }
        }
    }
    
    /**
     * Gibt die Tabelle als Liste wieder zurück. Wichtig für die Ausgabe.
     * @param qc Beinhaltet die Klasse QueryConfiguration.
     * @param context
     * @return Eine Arrayliste die, die Werte der Tabelle enthält.
     */
    public ArrayList<Table> list(QueryConfiguration qc, ApplicationContext context) {
        select(qc, context);
        return tableList;
    }
}
