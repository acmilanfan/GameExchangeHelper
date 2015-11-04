package com.exchangehelper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.net.URL;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game implements Serializable {
    //todo configure fetch and customize all fields
    //todo add hashCode and equals
    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private URL gameImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "wantedGames", fetch = FetchType.LAZY)
    private Set<UserGame> wantedList;

    public Game() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getGameImage() {
        return gameImage;
    }

    public void setGameImage(URL gameImage) {
        this.gameImage = gameImage;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Set<UserGame> getWantedList() {
        return wantedList;
    }

    public void setWantedList(Set<UserGame> wantedList) {
        this.wantedList = wantedList;
    }
}

