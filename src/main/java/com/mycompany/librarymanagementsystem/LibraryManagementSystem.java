package com.mycompany.librarymanagementsystem;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem
{
    public static void main(String[] args)
    {
        LibraryManager library = new LibraryManager();
        library.getBooks().addAll(FileHandler.load());

        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------");
        System.out.println("---------- LIBRARY MANAGEMENT SYSTEM ----------");
        System.out.println("-----------------------------------------------");

        int choice;

        do
        {
            System.out.println();
            System.out.println("MENU");
            System.out.println("----");
            System.out.println("1. Add Book.");
            System.out.println("2. Remove Book.");
            System.out.println("3. Search Book.");
            System.out.println("4. List all Books.");
            System.out.println("0. Exit.");

            System.out.print("What do you want to do: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println();
                    System.out.println("-------------");
                    System.out.println("ADDING A BOOK");
                    System.out.println("-------------");
                    System.out.println("(Enter 0 at any point to go back)");

                    System.out.print("Title : ");
                    String title = input.nextLine();
                    if (title.equals("0")) break;

                    System.out.print("Author : ");
                    String author = input.nextLine();
                    if (author.equals("0")) break;

                    System.out.print("Genre : ");
                    String genre = input.nextLine();
                    if (genre.equals("0")) break;

                    System.out.print("Year : ");
                    String yearInput = input.nextLine().trim();
                    if (yearInput.equals("0")) break;

                    int year;
                    try
                    {
                        year = Integer.parseInt(yearInput);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Invalid year. Must be a number.");
                        break;
                    }

                    try
                    {
                        if (year < 1 || year > 2026)
                        {
                            System.out.println("Invalid year. Must be between 1 and 2026.");
                            break;
                        }

                        library.addBook(title, author, genre, year);
                        FileHandler.save(library.getBooks());
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("[EXCEPTION]: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("---------------");
                    System.out.println("REMOVING A BOOK");
                    System.out.println("---------------");
                    System.out.println("(Enter 0 to go back)");

                    System.out.print("Enter Book ID: ");
                    String removeInput = input.nextLine().trim();
                    if (removeInput.equals("0")) break;

                    int bookId;
                    try
                    {
                        bookId = Integer.parseInt(removeInput);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Please enter a valid numeric ID.");
                        break;
                    }

                    try
                    {
                        library.removeBook(bookId);
                        FileHandler.save(library.getBooks());
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("----------------");
                    System.out.println("SEARCHING A BOOK");
                    System.out.println("----------------");
                    System.out.println("(Enter 0 at any point to go back)");

                    System.out.println("1. Search by Book ID.");
                    System.out.println("2. Search by Book Title.");
                    System.out.println("3. Search by Book Author.");
                    System.out.println();

                    System.out.print("What do you want to do: ");
                    String subInput = input.nextLine().trim();
                    if (subInput.equals("0")) break;

                    int subChoice;
                    try
                    {
                        subChoice = Integer.parseInt(subInput);
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("[ERROR]: Please enter a valid option number.");
                        break;
                    }

                    switch (subChoice)
                    {
                        case 1:
                            System.out.println();
                            System.out.println("SEARCHING BY ID");
                            System.out.println("---------------");

                            System.out.print("Enter ID: ");
                            String searchIdInput = input.nextLine().trim();
                            if (searchIdInput.equals("0")) break;

                            int searchId;
                            try
                            {
                                searchId = Integer.parseInt(searchIdInput);
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("[ERROR]: ID must be a valid number.");
                                break;
                            }

                            Book found = library.searchById(searchId);
                            if (found != null)
                            {
                                System.out.println("Book Found:");
                                System.out.println(found);
                            }
                            else
                            {
                                System.out.println("No book found with ID: " + searchId);
                            }
                            break;

                        case 2:
                            System.out.println();
                            System.out.println("SEARCHING BY TITLE");
                            System.out.println("------------------");

                            System.out.print("Enter Title: ");
                            String searchTitle = input.nextLine().trim();
                            if (searchTitle.equals("0")) break;

                            List<Book> byTitle = library.searchByTitle(searchTitle);
                            if (byTitle.isEmpty())
                            {
                                System.out.println("No book found with this title.");
                            }
                            else
                            {
                                System.out.println("Found Books:");
                                byTitle.forEach(System.out::println);
                            }
                            break;

                        case 3:
                            System.out.println();
                            System.out.println("SEARCHING BY AUTHOR");
                            System.out.println("-------------------");

                            System.out.print("Enter Author: ");
                            String searchAuthor = input.nextLine().trim();
                            if (searchAuthor.equals("0")) break;

                            List<Book> byAuthor = library.searchByAuthor(searchAuthor);
                            if (byAuthor.isEmpty())
                            {
                                System.out.println("No books found with this author.");
                            }
                            else
                            {
                                System.out.println("Found Books:");
                                byAuthor.forEach(System.out::println);
                            }
                            break;

                        default:
                            System.out.println("Invalid search option. Please choose 1, 2, or 3.");
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("--------------");
                    System.out.println("ALL BOOKS LIST");
                    System.out.println("--------------");

                    library.listAll();
                    break;

                case 0:
                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
            }

        } while (choice != 0);

        input.close();
    }
}