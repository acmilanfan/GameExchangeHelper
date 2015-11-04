package com.exchangehelper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_game")
public class UserGame implements Serializable {
    //todo configure fetch and customize all fields
    //todo add hashCode and equals
    @Id
    @GeneratedValue
    @Column(name = "user_game_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "wanted_game", joinColumns = @JoinColumn(name = "user_game_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> wantedGames;

    public UserGame() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Game> getWantedGames() {
        return wantedGames;
    }

    public void setWantedGames(Set<Game> wantedGames) {
        this.wantedGames = wantedGames;
    }
}
