package ru.web.SpringBoot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 45, message = "От 2 до 45")
    private String name;
    @Column(name = "lastNme")
    @Size(min = 2, max = 45, message = "От 2 до 45")
    private String lastName;
    @Column(name = "age")
    @PositiveOrZero(message = "Не отрицательное")
    private long age;
    @Column(name = "email")
    @Email(message = "Некорректный ввод")
    @NotEmpty(message = "Поле не может быть пустым")
    private String email;

    public User() {
    }

    public User(String name, String lastName, long age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
