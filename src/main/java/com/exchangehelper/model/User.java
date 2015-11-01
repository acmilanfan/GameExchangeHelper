package com.exchangehelper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_table")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserGame> games;

    @Column(name = "phone")
    private String phone;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<UserGame> getGames() {
        return games;
    }

    public void setGames(Set<UserGame> games) {
        this.games = games;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}