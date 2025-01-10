package ru.alishev.springcourse.models;

import jakarta.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "The name should not be empty")
    @Size(min = 2, max = 30, message = "The name should be between 2 and 30 characters")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    //Страна, Город, Индекс (6 цифр) ----этот ввод с первыми большими буквами считается правильным форматом
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, Postal Code (6 numbers)")
    private String address;

    public Person(int id, String name, int age, String email, String address) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
