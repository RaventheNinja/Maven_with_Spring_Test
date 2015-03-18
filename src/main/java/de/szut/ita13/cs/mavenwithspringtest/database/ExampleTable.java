package de.szut.ita13.cs.mavenwithspringtest.database;

import java.sql.Date;

/**
 * ExampleTable implementiert das Interface Table und enthält die selben Attribute die als Datum in der Datenbanktabelle zur Verfügung stehen.
 * Um die Attribute aufzurufen werden getter Methoden verwendet. Mit den Setter Methoden werden den Attributen Werte gesetzt.
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
public class ExampleTable implements Table{
    
    /** Das Attribute id bekommt die id Werte aus der Tabelle "example". */
    private Integer id;
    /** Das Attribute name bekommt die name Werte aus der Tabelle "example". */
    private String name;
    /** Das Attribute birth bekommt die birth Werte aus der Tabelle "example". */
    private Date birth;
    /** Das Attribute death bekommt die death Werte aus der Tabelle "example". */
    private Date death;
  
    /** Wurde aus dem Interface Table implementiert. */
    @Override
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getName()).append(" ").append(getBirth()).append(" ").append(getDeath()).append("\n");
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

    /** Gibt das Attribut name zurück. 
      * @return name Enthält den name Wert aus der Tabelle example. */
    public String getName() {
        return name;
    }
    
    /**
     * Eine Methode um das Attribut name zu setzen.
     * @param name Übergibt einen String mit den Namen der gesetzt werden soll.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Gibt das Attribut birth zurück.
      * @return birth Enthält den birth Wert aus der Tabelle example. */    
    public Date getBirth() {
        return birth;
    }

    /**
     * Eine Methode um das Attribut birth zu setzen.
     * @param birth Übergibt ein Date mit dem Datum der Geburt das gesetzt werden soll.
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /** Gibt das Attribut death zurück.
     * @return death Enthält den death Wert aus der Tabelle example. */    
    public Date getDeath() {
        return death;
    }
    
    /**
     * Eine Methode um das Attribut death zu setzen.
     * @param death Übergibt ein Date mit den Sterbedatum das gesetzt werden soll.
     */
    public void setDeath(Date death) {
        this.death = death;
    }
}