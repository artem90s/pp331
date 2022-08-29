package com.example.pp331.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty(message = "не должно быть пустым")
    @Size(min = 2, max = 30, message = "имя должно быть не менее 2 и не более 30 символов")
    private String name;

    @Column
    @NotEmpty(message = "not empty")
    @Size(min = 2, max = 30, message = "min 2 and max 30 symbols")
    private String surname;

    public User(){}

    public User(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
