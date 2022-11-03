package com.company;

import java.util.*;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, please add the information of the library!");
        var currLibrary = LibraryFunctionality.enterLibrary();
        menu(currLibrary);
    }

    static void menu(Library library) {
        var isLooping = true;
        while(isLooping) {
            System.out.println("1.Add book");
            System.out.println("2.Remove book");
            System.out.println("3.Find book");
            System.out.println("4.Refresh books");
            System.out.println("5.Full list with books");
            System.out.println("6.Exit");
            var menuOption = input.nextInt();
            input.nextLine();
            switch(menuOption) {
                case 6:
                    isLooping = false;
                    System.out.println("Bye! See you!");
                    break;
                case 1:
                    library.books = BooksFunctionality.AddBook(library.books);
                    break;
                case 2:
                    library.books = BooksFunctionality.RemoveBook(library.books);
                    break;
                case 3:
                    BooksFunctionality.SearchBook(library.books);
                    break;
                case 4:
                    library.books = BooksFunctionality.ChangeBook(library.books);
                    break;
                case 5:
                    BooksFunctionality.GetBooks(library.books);
                    break;
                default:

                    break;
            }
        }

    }





}
