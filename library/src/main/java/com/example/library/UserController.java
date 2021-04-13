package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "get/users",method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "get/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeUser(@PathVariable("id") int id){
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "create/user/{username}", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser( @PathVariable("username") String username){
        userService.addUser(username, new ArrayList());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "update/user/book/borrow/{userId}/{bookId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> addBookToUser( @PathVariable("userId") int userId, @PathVariable("bookId") int bookId){
        userService.addBookToUser(userId, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "update/user/book/return/{userId}/{bookId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> deleteBookFromUser( @PathVariable("userId") int userId, @PathVariable("bookId") int bookId){
        userService.deleteBookFromUser(userId, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
