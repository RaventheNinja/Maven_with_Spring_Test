package de.szut.ita13.cs.mavenwithspringtest.queryobjects;

/**
 * Diese Klasse ist dazu da, die Werte für eine Bedingung als Objekt zu speichern. Diese 
 * werden später für das PreparedStatement benötigt.
 *
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class ConditionObject {
    
    /** Der String enhält die Bedingung. */
    private String colConditon;
    /** Ein Objekt welches überprüft werden soll. */
    private Object colValue;
    
    /**
     * Eine get-Methode um colValue zurückzugeben.
     * @return Gibt colValue zurück.
     */
    public Object getColValue() {
        return colValue;
    }
    
    /**
     * Eine set-Methode um colValue zu setzen.
     * @param colValue Übergibt ein Objekt von colValue.
     */
    public void setColValue(Object colValue) {
        this.colValue = colValue;
    }
    
    /**
     * Eine get-Methode um colCondition zurückzugeben.
     * @return Gibt colCondition zurück.
     */
    public String getColConditon() {
        return colConditon;
    }
    
    /**
     * Eine set-Methode um colCondition zu setzen.
     * @param colConditon Übergibt einen String.
     */
    public void setColConditon(String colConditon) {
        this.colConditon = colConditon;
    }
}
