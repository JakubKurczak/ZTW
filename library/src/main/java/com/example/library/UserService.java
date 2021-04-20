package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements IUserService{
    private static List<User> users = new ArrayList<>();
    static int id_gen=1;

    @Autowired
    IBookService bookService;

    static{
        IBookService bookService = new BooksService();

        bookService.addBook("Bogurodzica",1, 800, true);
        bookService.addBook("Rozmowa mistrza Polikarpa ze Śmiercią",1, 900, true);
        bookService.addBook("Dobra książka",2, 200, false);
        bookService.addBook("Słaba książka",2, 222, false);

        Collection<Book> borrowedBooks = new ArrayList<>();
        borrowedBooks.addAll(bookService.getBooks());

        users.add(new User(1, "maro332", new ArrayList()));

        users.add(new User(2, "login123", borrowedBooks));

        users.add(new User(3, "Robert", new ArrayList()));

        id_gen =4;
    }
    @Override
    public Collection<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        return users.stream().filter(b->b.getUid() == id).findAny().orElse(null);
    }

    @Override
    public void removeUser(int id) {
        users.remove(this.getUser(id));
    }

    @Override
    public void addUser(String username, Collection<Book> borrowedBooks) {
        users.add(new User(id_gen, username, borrowedBooks));
        id_gen++;
    }

    @Override
    public void addBookToUser(int userId, int bookId) {
        User u = (User)users.stream().filter(b->b.getUid() == userId).findAny().orElse(null);
        if(u!=null && bookService.getBook(bookId)!=null){
            bookService.getBook(bookId).setBorrowed(true);
            u.getBorrowedBooks().add(bookService.getBook(bookId));

        }
    }

    @Override
    public void deleteBookFromUser(int userId, int bookId) {
        User u = (User)users.stream().filter(b->b.getUid() == userId).findAny().orElse(null);
        if(u!=null && bookService.getBook(bookId)!=null){
            bookService.getBook(bookId).setBorrowed(false);
            u.getBorrowedBooks().remove(bookService.getBook(bookId));

        }
    }

}
