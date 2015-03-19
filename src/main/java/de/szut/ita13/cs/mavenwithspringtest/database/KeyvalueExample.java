package de.szut.ita13.cs.mavenwithspringtest.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "keyvalue_example")
public class KeyvalueExample implements TableObject{

    @Id
    @GeneratedValue
    @Column (name="ID")
     private Integer id;
    
    @Column (name="pet")
     private String pet;

    public KeyvalueExample() {
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPet() {
        return this.pet;
    }
    
    public void setPet(String pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "KeyvalueExample{" + "id=" + id + ", pet=" + pet + '}';
    }
    
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getPet()).append("\n");
    }
}


