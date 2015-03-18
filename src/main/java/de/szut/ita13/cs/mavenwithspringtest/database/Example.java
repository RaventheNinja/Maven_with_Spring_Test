package de.szut.ita13.cs.mavenwithspringtest.database;
// Generated 18.03.2015 10:50:57 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "example")
public class Example {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Integer id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="BIRTH")
    private Date birth;

    @Override
    public String toString() {
        return "Example{" + "id=" + id + ", name=" + name + ", birth=" + birth + ", death=" + death + '}';
    }
    
    @Column(name="DEATH")
    private Date death;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return this.death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }
}
