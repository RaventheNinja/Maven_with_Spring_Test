package de.szut.ita13.cs.mavenwithspringtest.database;

/**
 * KeyValueExampleTable implementiert das Interface Table und enthält die selben Attribute die als Datum in der Datenbanktabelle zur Verfügung stehen.
 * Um die Attribute aufzurufen werden getter Methoden verwendet. Mit den Setter Methoden werden den Attributen Werte gesetzt.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class KeyValueExampleTable implements Table{
    
    /** Das Attribute id bekommt die id Werte aus der Tabelle "example". */
    private Integer id;
    /** Das Attribute pet bekommt die pet Werte aus der Tabelle "example". */
    private String pet;

    /** Wurde aus dem Interface Table implementiert. */
    @Override
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getPet()).append("\n");
    }
    
    /** Gibt das Attribut id zurück. 
      * @return id Enthält den id Wert aus der Tabelle example. */
    public Integer getId() {
        return id;
    }

    /**
     * Eine Methode um das Attribut id zu setzen.
     * @param id Übergibt einen Integer mit der ID die gesetzt werden soll.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Gibt das Attribut pet zurück. 
      * @return pet Enthält den id Wert aus der Tabelle example. */
    public String getPet() {
        return pet;
    }
    
    /**
     * Eine Methode um das Attribut pet zu setzen.
     * @param pet Übergibt einen String mit der Bezeichnung des Tieres der gesetzt werden soll.
     */
    public void setPet(String pet) {
        this.pet = pet;
    }
}
