package edu.lev.collections.generics.domain;

import java.util.Objects;

public class UserDomain implements GenericDomain<Integer> {
    private String name;
    private int age;
    private Integer id;

    public UserDomain(){
    }

    public UserDomain(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDomain that)) return false;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}
