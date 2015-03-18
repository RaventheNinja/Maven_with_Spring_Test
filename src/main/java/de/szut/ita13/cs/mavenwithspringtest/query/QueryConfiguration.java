package de.szut.ita13.cs.mavenwithspringtest.query;

import de.szut.ita13.cs.mavenwithspringtest.queryobjects.ConditionObject;
import java.util.ArrayList;

/**
 * Die Klasse QueryConfiguration ist dazu da, die Konfigurationen für die
 * Queries zu erstellen und um sie an Query weiterzugeben.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class QueryConfiguration {
    /** Diese Liste enthält die Namen der Spaltennamen die der Nutzer auswählt. */
    private final ArrayList<String> colNames = new ArrayList<>();
    /** Dieser String enthält die Tabelle, die der Nutzer ausgewählt hat. */
    private String tableName;
    /** Diese Liste enthält das Objekt ConditionObject und wird für das PreparedStatement benötigt.*/
    private final ArrayList<ConditionObject> conditions = new ArrayList<>();
    /** Falls der Nutzer die selektierung irgendwie sortieren will. */
    private final ArrayList<String> directions = new ArrayList<>();
    
    /**
     * Mit dieser Methode werden der Liste, die Namen der Spalten mitangegeben.
     * Falls der Nutzer nur eine bestimmte Spalte angezeigt haben will kann er das hier
     * tun. Falls addColumn nicht mit angegeben wird, wird automatisch die gesamte Tabelle
     * angezeigt. 
     * Beispiel: addColumn("colName")
     * @param colName Enthält den Spaltennamen.
     * @return Gibt das jetzige Objekt zurück, damit man eine mehrfach Auswahl machen kann.
     */
    public QueryConfiguration addColumn(String colName) {
        colNames.add(colName);
        return this;
    }
    
    /**
     * Mit dieser Methode werden dem String, der Name der selektierten Tabelle mitangegeben.
     * Beispiel: addTableName("tableName")
     * @param tableName Enthält den Tabellennamen.
     * @return Gibt das jetzige Objekt zurück, damit man eine mehrfach Auswahl machen kann.
     */
    public QueryConfiguration addTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
    
    /**
     * Mit dieser Methode werden der Liste, die Bedingung sowie das Objekt welches überprüft werden soll hinzugefügt.
     * Beispiel: addCondition("colName=?", object)
     * @param condition Ist die Bedingung.
     * Beispiel: colName=?
     * @param colValue Ist das Objekt welches überprüft werden soll.
     * Beispiel: objekt
     * @return Gibt das jetzige Objekt zurück, damit man eine mehrfach Auswahl machen kann.
     */
    public QueryConfiguration addCondition(String condition, Object colValue) {
        ConditionObject co = new ConditionObject();
        co.setColConditon(condition);
        co.setColValue(colValue);
        conditions.add(co);
        return this;
    }
    
    /**
     * Mit dieser Methode werden der Liste, die Sortierrichtung mit angegeben.
     * Beispiel addDirection(colName asc) für aufsteigend
     * addDirection(colName desc) für absteigend
     * @param direction Ist die Sortierrichtung.
     * @return Gibt das jetzige Objekt zurück, damit man eine mehrfach Auswahl machen kann.
     */
    public QueryConfiguration addDirection(String direction) {
        directions.add(direction);
        return this;
    }
    
    /**
     * Diese Methode konfiguriert das Query so wie der Nutzer es haben wollte.
     * Mit If-Abfragen wird überprüft ob es überhaupt nötig ist die Listen zu joinen.
     * Mit dem join werden die Werte in den Listen mit bestimmten Trennzeichen getrennt.
     * @return Das fertige Query.
     */
    public String configureQuery() {
        String colName = null;
        String direction = null;
        // Falls der Nutzer keine Spalten mitangeben hat, wird die Tabelle mit * selektiert.
        if (colNames.isEmpty()) {
            colName = "*";
        } else {
            colName = String.join(",", colNames);
        }
        
        if (!directions.isEmpty()) {
            direction = String.join(",", directions);
        }
        
        StringBuilder sb = new StringBuilder();
        // Der Standard Query wird erstellt. "SELECT colName FROM tableName"
        sb.append("SELECT ").append(colName).append(" FROM ").append(tableName);

        if (!conditions.isEmpty()) {
            // Falls Bedingungen vorhanden sind, wird die aller erste schonmal erstellt.
            sb.append(" WHERE ").append(conditions.get(0).getColConditon());
            // Falls es wirklich mehr als eine gibt wird i auf 1 gesetzt damit man nicht wieder
            // die erste Bedingung vom Objekt mitnimmt.
            if (conditions.size() > 1) {
                for (int i = 1; i < conditions.size(); i++) {
                    sb.append(" AND ").append(conditions.get(i).getColConditon());
                }
            }

            if (direction != null) {
                sb.append(" ORDER BY ").append(direction);
            }
        }
        return sb.toString();

    }
    /**
     * Mit dieser Methode wird Liste zurückgegeben die ein Objekt enthält.
     * @return Die Liste mit dem Obejkt ConditionObject.
     */
    public ArrayList<ConditionObject> getConditions() {
        return conditions;
    }

}
