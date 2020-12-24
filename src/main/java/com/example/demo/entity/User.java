package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

//@EnableAutoConfiguration
@Data
@Entity
@Table(name = "user", schema = "gameWebsite")
public class User {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @NonNull
    private String name;

    @Basic
    @NonNull
    private String username;

    @Basic
    @NonNull
    private String password;

    @Basic
    private String description;

    @Basic
    @NonNull
    @Size(min = 1,max = 5)
    private int reputation;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Task> taskSet;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Participation> participationSet;
}
