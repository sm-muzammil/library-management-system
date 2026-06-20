package com.mycompany.librarymanagementsystem;

public class Book
{
    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    public Book(String title, String author, String genre, int year)
    {
        this.id = counter++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }
    
    Book(int id, String title, String author, String genre, int year)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
 
        if (id >= counter)
        {
            counter = id + 1;
        }
    }

    public int getId()
    {
        return id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public int getYear()
    {
        return year;
    }

    public String toString()
    {
        return "ID : " + id + " | Title : " + title + " | Author : " + author + " | Genre : " + genre + " | Year : " + year;
    }
}