package com.exchangehelper.controller;

import com.exchangehelper.model.UserGame;
import com.exchangehelper.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usergame")
public class UserGameController {

    @Autowired
    private UserGameService userGameService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addUserGame(@RequestBody UserGame userGame) {
        userGameService.addUserGame(userGame);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateUserGame(@RequestBody UserGame userGame) {
        userGameService.updateUserGame(userGame);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteUserGame(@RequestBody UserGame userGame) {
        userGameService.deleteUserGame(userGame);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllUserGames() {
        return userGameService.getAllUserGames();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserGame getUserGameById(@PathVariable long id) {
        return userGameService.getUserGameById(id);
    }

    @RequestMapping(value = "/recommendations/", method = RequestMethod.GET)
    public List getRecommendations(@RequestBody UserGame userGame) {
        return userGameService.getRecommendations(userGame);
    }

    @RequestMapping(value = "/wanted/", method = RequestMethod.GET)
    public List getWantedGames(@RequestBody UserGame userGame) {
        return userGameService.getWantedGames(userGame);
    }
}
