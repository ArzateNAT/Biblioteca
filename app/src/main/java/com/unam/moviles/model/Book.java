package com.unam.moviles.model;

/**
 * Created by Samuel on 19/04/2017.
 */

public class Book {
    private String author, title;
    int id;

    public Book() {}

    public Book(int id, String title, String author)
    {
        this.author = author;
        this.title = title;
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public int getId()
    {
        return this.id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Books (id= " + this.id + "   Title = "
                + this.title +
                "   author = " + this.author + ")";
    }
}
