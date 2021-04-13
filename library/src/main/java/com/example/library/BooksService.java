package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BooksService implements IBookService {
    private static List<Book> booksRepo = new ArrayList<>();
    static int id_gen = 1;

    @Autowired
    IAuthorService authorService;

    static{
        IAuthorService authorService = new AuthorService();
        authorService.addAuthor("Henryk","Sienkiewicz");
        authorService.addAuthor("Stanisław","Reymont");
        authorService.addAuthor( "Adam", "Mickiewicz");
/*
        booksRepo.add(new Book(1,"Potop", authorService.getAuthor(0), 936,false));

        booksRepo.add(new Book(2,"Wesele", authorService.getAuthor(1), 150, false));

        booksRepo.add(new Book(3,"Dziady", authorService.getAuthor(2), 292, false));

        id_gen =4;*/
    }

    @Override
    public Collection<Book> getBooks() {
        return booksRepo;
    }

    @Override
    public Book getBook(int id) {
        return booksRepo.stream().filter(b->b.getId() == id).findAny().orElse(null);
    }

    @Override
    public void removeBook(int id) {
        booksRepo.remove(this.getBook(id));
    }

    @Override
    public void addBook(String title, int author, int pages, boolean b) {
        Author a;
        if(authorService != null){
             a = authorService.getAuthor(author);
        }else{
            a = null;
        }
        booksRepo.add(new Book(id_gen, title,  a, pages, b));
        id_gen++;
    }

    @Override
    public void changeBookTitle(int id, String title) {
        Book book = this.getBook(id);
        if(book != null)
            book.setTitle(title);
    }
    @Override
    public boolean isDeleteAllowed(int id){
        if(booksRepo.stream().filter(b->b.getId() == id).findAny().orElse(null)==null)
            return false;
        if(booksRepo.stream().filter(b->b.getId() == id).findAny().orElse(null).isBorrowed())
            return false;
        return true;
    }
}
