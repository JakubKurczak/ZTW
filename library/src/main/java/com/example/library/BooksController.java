package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.RectangularShape;

@RestController
public class BooksController {

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "get/books",method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "get/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @RequestMapping(value = "delete/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeBook(@PathVariable("id") int id){
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //wdg mozilla to nie jest prawidłowy path
    //ale robie zgodnie z instrukcją
    @RequestMapping(value = "change/book/title/{id}/{title}", method = RequestMethod.PUT)
    public ResponseEntity<Object> changeBookTitle(@PathVariable("id") int id, @PathVariable("title") String title){
        bookService.changeBookTitle(id,title);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "create/book/{title}/{author}/{pages}", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook( @PathVariable("title") String title, @PathVariable("author") int author, @PathVariable("pages") int pages){
        bookService.addBook(title, author,pages);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
