package com.example.library;

import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    static List<Author> authors = new ArrayList<>();
    static int id_gen=1;

    @Override
    public Collection<Author> getAuthors() {
        return authors;
    }

    @Override
    public Author getAuthor(int id) {
        return authors.stream().filter(author -> author.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addAuthor(String firstName, String lastName) {
        authors.add(new Author(id_gen, firstName, lastName));
        id_gen++;
    }

    @Override
    public void deleteAuthor(int id) {
        authors.remove(this.getAuthor(id));
    }

    @Override
    public void changeAuthorFirstName(int id, String firstName) {
        Author author = this.getAuthor(id);
        if(author != null)
            author.setFirstName(firstName);
    }

    @Override
    public void changeAuthorLastName(int id, String lastName) {
        Author author = this.getAuthor(id);
        if(author != null)
            author.setLastName(lastName);
    }

}
