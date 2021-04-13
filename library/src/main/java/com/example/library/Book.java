package com.example.library;

public class Book {
    private int id;
    private String title;
    private Author author;
    private int pages;
    private boolean isBorrowed;


    public Book(int id, String title, Author author, int pages, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isBorrowed = isBorrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean equals(Object o){
        if (o instanceof Book)
            return ((Book)o).getId() == this.id;
        else
            return false;
    }
}
