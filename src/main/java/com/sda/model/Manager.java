package com.sda.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "managers")
public class Manager implements Serializable {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "age")
    private int age;

    public Manager(String name, String position, int age) {
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public Manager(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
