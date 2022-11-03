package com.company;

import static com.company.Main.input;

public class LibraryFunctionality {

    static Library enterLibrary() {
        String name;
        String address;
        Integer employees;
        while(true) {
            System.out.println("Enter library name: ");
            name = input.nextLine();
            if(name.length() < 100 && name.length() > 0) {
                break;
            }
            System.out.println("Name of the library needs to be smaller than 100 symbols! Please try again!");
        }

        while(true) {
            System.out.println("Enter address of the library: ");
            address = input.nextLine();
            if(address.length() < 500 && address.length() > 0) {
                break;
            }
            System.out.println("The address needs to be smaller than 500 symbols! Please try again!");
        }

        while(true) {
            System.out.println("Enter number of workers: ");
            employees = input.nextInt();
            if(employees > 0 && employees < 50) {
                break;
            }
            System.out.println("The number of workers needs to be bigger than 0 and smaller than 50! Please try again!");
        }
        var library = new Library(name, address, employees);
        return library;
    }
}
