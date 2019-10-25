package com.sda.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @GenericGenerator(name = "gen",strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public Department(String name) {
        this.name = name;
    }
    public Department(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
