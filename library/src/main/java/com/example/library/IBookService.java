package com.example.library;

import java.util.Collection;

public interface IBookService {
    public abstract Collection<Book> getBooks();
    public abstract Book getBook(int id);
    public abstract void removeBook(int id);
    public abstract void addBook(String title, int author, int pages, boolean b);
    public abstract void changeBookTitle(int id, String title);
    public abstract boolean isDeleteAllowed(int id);
}
