package com.example;

/*
 * There are many exceelent 3rd party libraries that will handle converting jsons into java objects and 
 * vice versa. HOWEVER, in order to make use of most of these libraries, many of them require you to set up your
 * class in a specific way: they require the Java bean design pattern.
 * 
 * The Java Bean design pattern has just a few requirements:
 *      all fields must be private (not public)
 *      all fields must have getter and setter methods to interact with them
 */

public class Book {
    /*
     * so far we have been using the public access modifier: to make a class a java bean though, all fields
     * must be set to priavte: this means they are only accesible by code within the class itself.
     */

    private String title;
    private String author;
    private String genre;
    private int isbn;

    //the public methods below are used to change the fields of any book objects below

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    
}
