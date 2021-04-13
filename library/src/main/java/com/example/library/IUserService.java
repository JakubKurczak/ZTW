package com.example.library;

import java.util.Collection;

public interface IUserService {
    public abstract Collection<User> getUsers();
    public abstract User getUser(int id);
    public abstract void removeUser(int id);
    public abstract void addUser(String username, Collection<Book> borrowedBooks);
    public abstract void addBookToUser(int userId, int bookId);
    public abstract void deleteBookFromUser(int userId, int bookId);
}
