package com.sunfish.first.controller;

import java.util.ArrayList;
import java.util.List;

import com.sunfish.first.model.Friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hey")
public class FriendController {

    private List<Friend> friends;

    public FriendController() {
        friends = new ArrayList<>();
        friends.add( new Friend("ja", "jace"));
        friends.add( new Friend("js", "Jasper"));
        
    }

    @GetMapping()
    public List<Friend> list () {
        return friends;
    }

    @GetMapping("/{id}")
    public Friend get(@PathVariable String id) {
        return this.friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }
    
}