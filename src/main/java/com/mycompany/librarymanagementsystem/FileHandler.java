package com.mycompany.librarymanagementsystem;

import java.io.*;
import java.util.ArrayList;

class FileHandler
{
    private static final String FILE = "library.txt";

    public static void save(ArrayList<Book> books)
    {
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE)))
        {
            for (Book b : books)
            {
                pw.println(b.getId() + "|" + b.getTitle() + "|"
                         + b.getAuthor() + "|" + b.getGenre() + "|" + b.getYear());
            }
        }
        catch(IOException e)
        {
            System.out.println("[EXCEPTION]: " + e.getMessage());
        }
    }

    public static ArrayList<Book> load()
    {
        ArrayList<Book> books = new ArrayList<>();
        File f = new File(FILE);
        if(!f.exists())
        {
            return books;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] p = line.split("\\|");
                
                if(p.length == 5)
                {
                    books.add(new Book(Integer.parseInt(p[0]), p[1], p[2], p[3], Integer.parseInt(p[4])));
                }
            }
        }
        catch(IOException | NumberFormatException e)
        {
            System.out.println("[EXCEPTION]: " + e.getMessage());
        }
        return books;
    }
}