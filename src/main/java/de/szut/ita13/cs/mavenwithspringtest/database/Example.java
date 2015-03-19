package de.szut.ita13.cs.mavenwithspringtest.database;
// Generated 18.03.2015 10:50:57 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "example")
public class Example implements TableObject, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth;

    @Column(name = "DEATH")
    @Temporal(javax.persistence.TemporalType.DATE)
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

    @Override
    public String toString() {
        return "Example{" + "id=" + id + ", name=" + name + ", birth=" + birth + ", death=" + death + '}';
    }

    @Override
    public void output(StringBuilder sb) {
        sb.append(getId()).append(" ").append(getName()).append(" ").append(getBirth()).append(" ").append(getDeath()).append("\n");
    }
}
