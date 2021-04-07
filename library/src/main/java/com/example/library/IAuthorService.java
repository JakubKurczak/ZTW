package com.example.library;

import java.util.Collection;

public interface IAuthorService {
    public abstract Collection<Author> getAuthors();
    public abstract Author getAuthor(int id);
    public abstract void addAuthor(String firstName, String lastName);
    public abstract void deleteAuthor(int id);
    public abstract void changeAuthorFirstName(int id, String firstName);
    public void changeAuthorLastName(int id, String lastName);
}
