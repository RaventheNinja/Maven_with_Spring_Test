package de.szut.ita13.cs.mavenwithspringtest.util;

import de.szut.ita13.cs.mavenwithspringtest.properties.DatabaseSettings;
import de.szut.ita13.cs.mavenwithspringtest.query.QueryConfiguration;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;

/**
 * Die Klasse Helper ist eine private Klasse und enthält statische Methoden.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class Helper {

    private Helper() {
    }

    /**
     * Die statische Methode methodify wird dazu genutzt einen String in einen
     * setString umzuwandeln. Dies wird benötigt um z.B. reflection zu nutzen.
     *
     * @param s Ist der Wert von einem Spaltenkopf.
     * @return Gibt einen String zurück der wie folgt aussehen kann: setName
     */
    public static String methodify(String s) {
        if (s == null) {
            return s;
        } else if (s.equals("")) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        final String tmp[] = s.toLowerCase().split("");
        sb.append("set").append(tmp[0].toUpperCase());
        for (int i = 1; i < tmp.length; i++) {
            sb.append(tmp[i]);
        }
        return sb.toString();
    }

    /**
     * Die statische Methode settify wird dafür genutzt, dynamisch eine set
     * Methode aufzurufen für ein Table Objekt.
     *
     * @param <T> Enthält das Objekt was benutzt werden soll.
     * @param rs Enthält das ResultSet. Also die jeweilige Zeile.
     * @param aThis Enthält die Klasse vom Objekt was benutzt werden soll.
     * @return T Gibt das jeweilige Objekt von der Tabelle zurück.
     * @throws Exception Wirft alle möglichen Exceptions.
     */
    public static <T> T settify(ResultSet rs, Class<T> aThis) throws Exception {
        // Die Variable obj bekommt die Referenz vom Instanzaufruf der Klasse.
        T obj = aThis.newInstance();
        // Die for-Schleife geht durch die Gesamte Anazhl der Spalten. 
        // Sie fängt bei 1 an, weil eine Tabelle bei 1 anfängt.
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            // columnName bekommt die Referenz des aktuellen Spaltennamen.
            String columnName = rs.getMetaData().getColumnName(i);
            // colClassname bekommt die Referenz der Klasse für die aktuelle Spalte.
            String colClassName = rs.getMetaData().getColumnClassName(i);
            // value bekommt die Referenz des Objekts an der Stelle des Spaltennamens und seiner Klasse.
            Object value = rs.getObject(columnName, Class.forName(colClassName));
            /*LOG.debug("Value = " + value +
             ",Name = " + columnName +
             ",Class = " + colClassName);*/
            // Haben : name 
            // soll  : setName
            // methodValue bekommt die Referenz der Methode die aufgerufen werden soll.
            Method methodValue = aThis.getMethod(Helper.methodify(columnName), Class.forName(colClassName));
            // methodValue ruft die jeweilge Methode auf im spezifischen Objekt mit dem speziellen Parameter.
            methodValue.invoke(obj, value);
        }
        return obj;
    }

    /**
     * Eine statische Methode um die verkürzte URL sowie den Namen der Datenbank
     * zusammenfügt für Connection.
     *
     * @param url Enthält die verkürzte URL,
     * @param database Enthält den Namen der Datenbank.
     * @return Gibt einen String zurück, der die vollständige URL für Connection
     * genutzt wird.
     */
    public static String mysqlUrl(String url, String database) {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://").append(url).append("/").append(database);
        return sb.toString();
    }
    /**
     * Eine statische Methode womit die Verbindung zur Datenbank hergestellt wird und das PreparedStatement
     * wird vorbereitet.
     * @param qc Beinhaltet die Klasse QueryConfiguration.
     * @param context
     * @return Gibt das PreparedStatement zurück um es z.B. für ResultSet weiterzuverwenden.
     * @throws SQLException Wirft eine Exception die durch eine fehlerhafte SQL Verbindung auftreten kann.
     */
    public static PreparedStatement mySqlPreparation(QueryConfiguration qc, ApplicationContext context) throws SQLException {
        DatabaseSettings dbs = (DatabaseSettings) context.getBean("databaseSettings");
        // Eine Verbindung wird aufgebaut mit der URL, dem Benutzer und das Passwort der Datenbank.
        Connection con = DriverManager.getConnection(dbs.getCompleteUrl(), dbs.getUser(), dbs.getPasswd());
        // Die Query wird für PreparedStatement vorbereitet. Ein PreparedStatement schützt
        // vor SQL Injections.
        PreparedStatement ps = con.prepareStatement(qc.configureQuery());
        for (int i = 0; i < qc.getConditions().size(); i++) {
            ps.setObject(i+1, qc.getConditions().get(i).getColValue());
        }
        return ps;
    }
}
