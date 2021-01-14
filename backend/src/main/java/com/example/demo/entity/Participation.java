package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "participation", schema = "gameWebsite")
public class Participation {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="task_id")
    private Task task;

    @ManyToOne(optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="user_id")
    private User user;

    public Participation() {
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", task=" + task +
                ", user=" + user +
                '}';
    }
}
