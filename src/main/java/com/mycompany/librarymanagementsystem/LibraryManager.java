package com.mycompany.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager
{
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String genre, int year)
    {
        if (title.isBlank() || author.isBlank())
        {
            throw new IllegalArgumentException("Title and author cannot be empty.");
        }
        
        books.add(new Book(title, author, genre, year));
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id)
    {
        boolean removed = books.removeIf(b -> b.getId() == id);
        
        if(!removed)
        {
            throw new IllegalArgumentException("No book found with ID: " + id);
        }
        
        System.out.println("Book removed.");
    }

    public List<Book> searchByTitle(String keyword)
    {
        List<Book> results = new ArrayList<>();
        
        for (Book b : books)
        {
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
            {
                results.add(b);
            }
        }
        
        return results;
    }

    public List<Book> searchByAuthor(String keyword)
    {
        List<Book> results = new ArrayList<>();
        
        for (Book b : books)
        {
            if(b.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
            {
                results.add(b);
            }
        }
        
        return results;
    }
    
    public Book searchById(int id)
    {
        for(Book b : books)
        {
            if(b.getId() == id)
            {
                return b;
            }
        }
        return null;
}

    public void listAll()
    {
        if(books.isEmpty())
        {
            System.out.println("No books in library.");
            return;
        }
        
        books.forEach(System.out::println);
    }

    public ArrayList<Book> getBooks()
    {
        return books;
    }
}