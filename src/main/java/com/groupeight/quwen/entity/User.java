package com.groupeight.quwen.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "password is mandatory")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Collect> collect;

    public User() {}

    public User(@NotBlank(message = "name is mandatory") String name,
                @NotBlank(message = "password is mandatory") String password,
                List<Collect> collect) {
        this.name = name;
        this.password = password;
        this.collect = collect;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Collect> getCollect() {
        return collect;
    }

    public void setCollect(List<Collect> collect) {
        this.collect = collect;
    }
}
