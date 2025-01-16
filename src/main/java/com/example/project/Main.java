package com.example.project;
import java.util.Scanner;

public class Main {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static int findUserName(String name, BookStore store){
        for(int i = 0; i < 10; i ++){
            if(store.getUsers()[i] != null && store.getUsers()[i].getName().toLowerCase().equals(name.toLowerCase())){
                return i;
            }
        }
        return 10;
    }
    public static void main(String[] args) {
        BookStore store = new BookStore();
        Scanner scan = new Scanner(System.in);
        int userInput = -22;
        clearScreen();
        
        while(userInput != 0){
            System.out.println("0. Exit\n1. User settings\n2. Login");
            userInput = scan.nextInt();
            scan.nextLine();
            clearScreen();
            
            if(userInput == 1){
                System.out.println("Users: " + store.bookStoreUserInfo());
                System.out.println("1. Add User\n2. Remove User\n3. User Info");
                userInput = scan.nextInt();
                scan.nextLine();
                
                if(userInput == 1){ 
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    IdGenerate.generateID();
                    User newUser = new User(name, IdGenerate.getCurrentId());
                    store.addUser(newUser);
                    clearScreen();
                
                } else if(userInput == 2){
                    System.out.print("Enter the name of the user: ");
                    String name = scan.nextLine();
                    int index = findUserName(name, store);
                    if(index != 10){
                        store.removeUser(store.getUsers()[index]);
                    } 
                    clearScreen();
                } else if(userInput == 3){
                    System.out.print("Enter the name of the user: ");
                    String name = scan.nextLine();
                    int index = findUserName(name, store);
                    if(index != 10){
                        System.out.println(store.getUsers()[index].userInfo());
                    }
                    scan.next();
                    clearScreen();
                }
            
            } else if (userInput == 2){
                System.out.println("1. User login\n2. Admin login");
                userInput = scan.nextInt();
                scan.nextLine();
                clearScreen();
                if(userInput == 1){
                    System.out.println(store.bookStoreUserInfo());
                    System.out.print("Type the name of the user: ");
                    String name = scan.nextLine();
                    if(findUserName(name, store) != 10){
                        User currentUser = store.getUsers()[findUserName(name, store)];
                        userInput = 0;
                        while(userInput != 1){
                            System.out.println("1. Logout\n2. Check Info\n3. Borrow book\n4. Return books");
                            userInput = scan.nextInt();
                            scan.nextLine();
                            if(userInput == 2){
                                System.out.println(currentUser.userInfo());
                            }
                        }
                    }
                }
            }
        }
        scan.close();
    }
}
