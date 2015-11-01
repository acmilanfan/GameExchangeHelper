package com.exchangehelper.controller;

import com.exchangehelper.model.User;
import com.exchangehelper.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/[id]", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
