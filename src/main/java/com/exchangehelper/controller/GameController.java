package com.exchangehelper.controller;

import com.exchangehelper.model.Game;
import com.exchangehelper.model.Platform;
import com.exchangehelper.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

   @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateGame(@RequestBody Game game) {
        gameService.updateGame(game);
    }

    @RequestMapping(value = "/[id]", method = RequestMethod.GET)
    public Game getGameById(@PathVariable long id) {
        return gameService.getGameById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List getAllGames() {
        return gameService.getAllGames();
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteGame(@RequestBody Game game) {
        gameService.deleteGame(game);
    }

    @RequestMapping(value = "/[part]", method = RequestMethod.GET)
    public List getGamesByPartialTitle(@PathVariable String part) {
        return gameService.getGamesByPartialTitle(part);
    }

    @RequestMapping(value = "/[platform]", method = RequestMethod.GET)
    public List getGamesOnPlatform(@PathVariable String platform) {
        return gameService.getGamesOnPlatform(Platform.valueOf(platform));
    }
}
