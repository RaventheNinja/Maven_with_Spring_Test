package de.szut.ita13.cs.mavenwithspringtest.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Diese Klasse ist ein Objekt von der Tabelle example. Sie implementiert das
 * Interface TableObject und Serializable. Die Werte der Tabelle werden im Objekt gespeichert.
 * Durch die Annotation @Entity weiß Hibernate, dass dieses Objekt zu einer Tabelle gehört.
 * Mit @Table wird angegeben zu genau welcher Tabelle dieses Objekt gehört.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
@Entity
@Table(name = "example")
public class Example implements TableObject, Serializable {
    
    /**
     * Das Attribut repräsentiert die Spalte ID in der Tabelle.
     * Mit der Annotation @Id wird gesagt, dass dieser Wert ein Primary Key ist
     * von der Tabelle. @Column wird eigetnlich nur dann gemacht wenn der Name des
     * Attributs mit dem Namen der Spalte sich abweichen.
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    /** Das Attribut repräsentiert dei Spalte NAME in der Tabelle. */
    @Column(name = "NAME")
    private String name;

    /** Das Attribut repräsentiert dei Spalte BIRTH in der Tabelle. */
    @Column(name = "BIRTH")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth;
    
    /** Das Attribut repräsentiert dei Spalte DEATH in der Tabelle. */
    @Column(name = "DEATH")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date death;

    
    /**
     * Die get-Methode für das Attribut id.
     * @return Gibt id zurück.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Die set-Methode für das Attribut id.
     * @param id Übergibt den Parameter id um ihn zu setzen.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Die get-Methode für das Attribut name.
     * @return Gibt name zurück.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Die set-Methode für das Attribut name.
     * @param name Übergibt den Parameter name um ihn zu setzen.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Die get-Methode für das Attribut birth.
     * @return Gibt birth zurück.
     */
    public Date getBirth() {
        return this.birth;
    }

    /**
     * Die set-Methode für das Attribut birth
     * @param birth Übergibt den Parameter birth um ihn zu setzen.
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Die get-Methode für das Attribut death.
     * @return Gibt death zurück.
     */
    public Date getDeath() {
        return this.death;
    }

    /**
     * Die set-Methode für das Attribut death.
     * @param death Übergibt den Parameter death um ihn zu setzen.
     */
    public void setDeath(Date death) {
        this.death = death;
    }

    /**
     * Lässt einen StringBuilder die Datensätze im Objekt zusammenfügen.
     * @param sb Ist ein StringBuilder der die jeweilgen Datensätze im Objekt als "String" zusammenfügt.
     */
    @Override
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getName()).append(" ").append(getBirth()).append(" ").append(getDeath()).append("\n");
    }
}