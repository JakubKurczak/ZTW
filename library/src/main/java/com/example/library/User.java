package com.example.library;

import java.util.Collection;

public class User {
    private int Uid;
    private String username;
    private Collection borrowedBooks;

    public int getUid() {
        return Uid;
    }

    public String getUsername() {
        return username;
    }

    public Collection getBorrowedBooks() {
        return borrowedBooks;
    }

    public User(int uid, String username, Collection borrowedBooks) {
        Uid = uid;
        this.username = username;
        this.borrowedBooks = borrowedBooks;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBorrowedBooks(Collection borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
