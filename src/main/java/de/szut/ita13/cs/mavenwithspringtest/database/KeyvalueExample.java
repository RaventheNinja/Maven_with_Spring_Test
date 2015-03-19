package de.szut.ita13.cs.mavenwithspringtest.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Diese Klasse ist ein Objekt von der Tabelle keyvaulue_example. Sie implementiert das
 * Interface TableObject und Serializable. Die Werte der Tabelle werden im Objekt gespeichert.
 * Durch die Annotation @Entity weiß Hibernate, dass dieses Objekt zu einer Tabelle gehört.
 * Mit @Table wird angegeben zu genau welcher Tabelle dieses Objekt gehört.
 * 
 * @author Christian Stiefel
 * @version 1.0 Java 1.8
 */
@Entity
@Table(name = "keyvalue_example")
public class KeyvalueExample implements TableObject, Serializable{
    
    /**
     * Das Attribut repräsentiert die Spalte ID in der Tabelle.
     * Mit der Annotation @Id wird gesagt, dass dieser Wert ein Primary Key ist
     * von der Tabelle. @Column wird eigetnlich nur dann gemacht wenn der Name des
     * Attributs mit dem Namen der Spalte sich abweichen.
     */
    @Id
    @GeneratedValue
    @Column (name = "ID")
     private Integer id;
    
    
    /** Das Attribut repräsentiert dei Spalte PET in der Tabelle. */
    @Column (name = "pet")
     private String pet;
    
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
     * Die get-Methode für das Attribut pet.
     * @return Gibt pet zurück.
     */
    public String getPet() {
        return this.pet;
    }
    
    /**
     * Die set-Methode für das Attribut pet.
     * @param pet Übergibt den Parameter pet um ihn zu setzen.
     */
    public void setPet(String pet) {
        this.pet = pet;
    }
    
    /**
     * Lässt einen StringBuilder die Datensätze im Objekt zusammenfügen.
     * @param sb Ist ein StringBuilder der die jeweilgen Datensätze im Objekt als "String" zusammenfügt.
     */
    @Override
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getPet()).append("\n");
    }
}