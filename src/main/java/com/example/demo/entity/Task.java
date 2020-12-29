package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "task", schema = "gameWebsite")
public class Task {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @NonNull
    private String title;

    @Basic
    @NonNull
    private String description;

    @Basic
    @NonNull
    private int attendNumber;

    @Basic
    @NonNull
    private String tag;

    @ManyToOne(optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "creator_id")
    private User user;

    @ManyToOne(optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Participation> participationSet;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attendNumber=" + attendNumber +
                ", tag='" + tag + '\'' +
                ", user=" + user +
                ", game=" + game +
                ", participationSet=" + participationSet +
                '}';
    }
}
