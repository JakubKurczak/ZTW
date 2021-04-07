package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @RequestMapping(value = "get/authors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthors(){
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @RequestMapping(value = "get/author/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") int id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "create/author/{firstName}/{lastName}", method = RequestMethod.POST)
    public ResponseEntity<Object> createAuthor(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        authorService.addAuthor(firstName,lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "change/author/firstName/{id}/{firstName}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeAuthorsFirstName(@PathVariable("id") int id, @PathVariable("firstName") String firstName){
        authorService.changeAuthorFirstName(id, firstName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "change/author/lastName/{id}/{lastName}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeAuthorsLastName(@PathVariable("id") int id, @PathVariable("lastName") String lastName){
        authorService.changeAuthorFirstName(id, lastName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
