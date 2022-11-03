package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static com.company.Main.input;

public class BooksFunctionality {
    static void GetBooks(List<Book> books) {
        System.out.println("********************************************************************");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-5s","Book Name","Author Name","Publisher","Publishing Year","Pages");
        System.out.println();
        System.out.println("********************************************************************");
        for (Book book : books) {
            if(book.getAvailable()) {
                System.out.format("%-10s | %-10s | %-10s | %-10s | %-5s", book.getName(), book.getAuthor(),
                        book.getPublisher(), book.getYearOfPublishing().toString(), book.getPages().toString());
                System.out.println();
            }
        }
        System.out.println("********************************************************************");
    }

    static List<Book> ChangeBook(List<Book> books) {
        System.out.println("Enter ISBN number: ");
        boolean isFound = false;
        String ISBN;
        ISBN = input.nextLine();
        for(var book:books) {
            if(book.getISBN().equals(ISBN)) {
                isFound = true;
                System.out.println("You choose to refresh the information by ISBN number: " + ISBN);
                System.out.println("Choose what do you want to refresh:");
                System.out.println("1.Availability");
                System.out.println("2.Date, when the book is taken:");
                System.out.println("3.Date, when the book need to be returned");
                System.out.println("4.Collection period");
                System.out.println("5.How many times the book is been taken");
                System.out.println("6.Exit");
                var menuOption = input.nextInt();
                input.nextLine();
                switch(menuOption) {
                    case 1:
                        while(true) {
                            System.out.println("Availability (true/false): ");
                            boolean isAvailable;
                            isAvailable = input.nextBoolean();
                            input.nextLine();
                            book.setAvailable(isAvailable);
                            break;
                        }
                        break;
                    case 2:
                        while(true) {
                            System.out.println("Enter collection date: (dd/mm/yyyy)");
                            SimpleDateFormat dateInput = new SimpleDateFormat("dd/mm/yyyy");
                            String strDate;
                            strDate = input.nextLine();
                            try{
                                var date = dateInput.parse(strDate);
                                book.setDateOfReturning(date);
                            } catch (Exception ex) {
                                System.out.println("Parse Exception");
                            }
                            break;
                        }
                        break;
                    case 3:
                        while(true) {
                            System.out.println("Enter date, when the book need to be returned: (dd/mm/yyyy)");
                            SimpleDateFormat dateInput = new SimpleDateFormat("dd/mm/yyyy");
                            String strDate;
                            strDate = input.nextLine();
                            try{
                                var date = dateInput.parse(strDate);
                                book.setDateOfReturning(date);
                            } catch (Exception ex) {
                                System.out.println("Parse Exception");
                            }
                            break;
                        }
                        break;
                    case 4:
                        while(true) {
                            System.out.println("Enter months for returning: ");
                            int monthsToReturn;
                            monthsToReturn = input.nextInt();
                            input.nextLine();
                            if(monthsToReturn > 0) {
                                book.setMonthsToReturn(monthsToReturn);
                                break;
                            }
                            System.out.println("Count of the months need to be bigger than 0! Please try again!");
                        }
                        break;
                    case 5:
                        while(true) {
                            System.out.println("Enter number of receivables : ");
                            int timesTaken;
                            timesTaken = input.nextInt();
                            input.nextLine();
                            if(timesTaken >= 0) {
                                book.setTimesTaken(timesTaken);
                                break;
                            }
                            System.out.println("Number of receivables needs to be bigger than 0! Please try again!");
                        }
                        break;
                }
                break;
            }
        }
        if(!isFound) {
            System.out.println("The book is not found!");
        }
        return books;
    }

    static void SearchBook(List<Book> books) {
        System.out.println("Please choose how do you want to search:");
        System.out.println("1.Name");
        System.out.println("2.Author");
        System.out.println("3.Date published");
        System.out.println("4.ISBN number");
        String name;
        String author;
        Integer yearOfPublishing;
        String ISBN;
        var menuOption = input.nextInt();
        input.nextLine();
        switch(menuOption) {
            case 1:
                System.out.println("Enter name: ");
                name = input.nextLine();
                books.removeIf(book -> !Objects.equals(book.getName(), name));
                GetBooks(books);
                break;
            case 2:
                System.out.println("Enter author: ");
                author = input.nextLine();
                books.removeIf(book -> !Objects.equals(book.getAuthor(), author));
                GetBooks(books);
                break;
            case 3:
                System.out.println("Enter date of publishing: ");
                yearOfPublishing = input.nextInt();
                input.nextLine();
                books.removeIf(book -> !Objects.equals(book.getYearOfPublishing(), yearOfPublishing));
                GetBooks(books);
                break;
            case 4:
                System.out.println("Enter ISBN number: ");
                ISBN = input.nextLine();
                books.removeIf(book -> !Objects.equals(book.getISBN(), ISBN));
                GetBooks(books);
                break;
        }
    }

    static List<Book> RemoveBook(List<Book> books) {
        System.out.println("Enter name or ISBN number: ");
        String nameOrISBN;
        nameOrISBN = input.nextLine();
        books.removeIf(book ->
                book.getISBN().equals(nameOrISBN) || book.getName().toLowerCase().equals(nameOrISBN.toLowerCase()));
        System.out.println("The book is removed successfully!");
        return books;
    }

    static List<Book> AddBook(List<Book> books) {
        String name;
        String author;
        String publisher;
        Integer yearOfPublishing;
        String ISBN;
        Integer pages;
        Boolean isAvailable;
        Integer timesTaken;
        while(true) {
            System.out.println("Enter name: ");
            name = input.nextLine();
            if(name.length() < 100 && name.length() > 0) {
                break;
            }
            System.out.println("Book name needs to be smaller than 100 symbols! Please try again!");
        }

        while(true) {
            System.out.println("Enter author: ");
            author = input.nextLine();
            if(author.length() < 50 && author.length() > 0) {
                break;
            }
            System.out.println("Author name needs to be smaller than 50 symbols! Please try again!");
        }

        while(true) {
            System.out.println("Enter publisher: ");
            publisher = input.nextLine();
            if(publisher.length() > 0 && publisher.length() < 50) {
                break;
            }
            System.out.println("Publishing house name needs to be smaller than 50 symbols! Please try again!");
        }
        while(true) {
            System.out.println("Enter date of publishing: ");
            yearOfPublishing = input.nextInt();
            input.nextLine();
            if(yearOfPublishing <= LocalDate.now().getYear() && yearOfPublishing >= 0) {
                break;
            }
            System.out.println("The year of publishing needs to be smaller than today`s date! Please try again!");
        }

        while(true) {
            System.out.println("Enter ISBN number: ");
            ISBN = input.nextLine();
            if(ISBN.length() <= 10 && ISBN.length() > 0) {
                break;
            }
            System.out.println("ISBN number needs to be smaller than 10 symbols! Please try again!");
        }

        while(true) {
            System.out.println("Enter number of pages: ");
            pages = input.nextInt();
            input.nextLine();
            if(pages > 0) {
                break;
            }
            System.out.println("Number of pager needs to be bigger than 0! Please try again!");
        }
        while(true) {
            System.out.println("Enter availability(true/false): ");
            isAvailable = input.nextBoolean();
            break;
        }

        while(true) {
            System.out.println("Enter count of receivables: ");
            timesTaken = input.nextInt();
            input.nextLine();
            if(timesTaken >= 0) {
                break;
            }
            System.out.println("Count of receivables needs to be bigger or equal to 0! Please try again!");
        }

        var book = new Book(name, author, publisher, yearOfPublishing, ISBN, pages, isAvailable, timesTaken);
        books.add(book);
        System.out.println("The book is added successfully!");
        return books;
    }

}
