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

    public static int findBookName(String name, BookStore store){
        for(int i = 0; i < store.getBooks().length; i ++){
            if(store.getBooks()[i] != null && store.getBooks()[i].getTitle().toLowerCase().equals(name.toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        BookStore store = new BookStore();
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        
        Scanner scan = new Scanner(System.in);
        int userInput = -22;
        IdGenerate.reset();
        clearScreen();

        User test = new User("test", IdGenerate.getCurrentId());
        store.addUser(test);
        while(userInput != 0){
            System.out.println("╒══════════════════════════════════════════════════════");
            System.out.println("|                  BookStore Interface");
            System.out.println("| 0. Exit\n| 1. User settings\n| 2. Login");
            userInput = scan.nextInt();
            scan.nextLine();
            clearScreen();
            
            if(userInput == 1){
                System.out.println("| Users: " + store.bookStoreUserInfo());
                System.out.println("| 1. Add User\n| 2. Remove User\n| 3. User Info");
                userInput = scan.nextInt();
                scan.nextLine();
                
                if(userInput == 1){ 
                    System.out.print("| Enter Name: ");
                    String name = scan.nextLine();
                    IdGenerate.generateID();
                    User newUser = new User(name, IdGenerate.getCurrentId());
                    store.addUser(newUser);
                    clearScreen();
                
                } else if(userInput == 2){
                    System.out.print("| Enter the name of the user: ");
                    String name = scan.nextLine();
                    int index = findUserName(name, store);
                    if(index != 10){
                        store.removeUser(store.getUsers()[index]);
                    } 
                    clearScreen();
                } else if(userInput == 3){
                    System.out.print("| Enter the name of the user: ");
                    String name = scan.nextLine();
                    int index = findUserName(name, store);
                    if(index != 10){
                        System.out.println(store.getUsers()[index].userInfo());
                    } else{
                        System.out.println("| No user found. Press Enter to continue");
                    }
                    scan.nextLine();
                    clearScreen();
                }
            
            } else if (userInput == 2){
                System.out.println("| 1. User login\n| 2. Admin login");
                userInput = scan.nextInt();
                scan.nextLine();
                clearScreen();
                if(userInput == 1){
                    
                    System.out.println("| Users: " + store.bookStoreUserInfo());
                    System.out.print("| Type the name of the user: ");
                    String name = scan.nextLine();
                    
                    if(findUserName(name, store) != 10){
                        User currentUser = store.getUsers()[findUserName(name, store)];
                        userInput = 0;
                        clearScreen();
                        
                        while(userInput != 1){
                            System.out.println("| Account: " + currentUser.getName() + "\n1. Logout\n2. Check Info\n3. Borrow books\n4. Return books");
                            userInput = scan.nextInt();
                            scan.nextLine();
                            clearScreen();
                            
                            if(userInput == 2){
                                System.out.println(currentUser.userInfo());
                                scan.nextLine();
                                clearScreen();
                            } 
                            else if(userInput == 3){
                                
                                if(currentUser.canBorrow()){
                                    System.out.println("| Books: " + store.bookStoreBookInfo());
                                    System.out.print("| Enter the name of the book: ");
                                    String bookName = scan.nextLine();
                                    
                                    if(findBookName(bookName, store) != -1){
                                        Book bookToBorrow = store.getBooks()[findBookName(bookName, store)];
                                        bookToBorrow.setQuantity(1);
                                        store.removeBook(bookToBorrow);
                                        currentUser.addBook(bookToBorrow);
                                        System.out.println("| Press Enter to continue");
                                    } 
                                    else{
                                        System.out.println("| Cannot borrow more books\n| Press Enter to continue");
                                    }
                                    
                                    scan.nextLine();
                                    clearScreen();
                                }
                            } 
                            else if(userInput == 4){
                                System.out.println("| Books: " + currentUser.bookListInfo());
                                System.out.print("| Enter Name of Book to return");
                                String bookName = scan.nextLine();
                                int index = -1;
                                for(int i = 0; i <5; i++){
                                    if(currentUser.getBook()[i] != null && currentUser.getBook()[i].getTitle().toLowerCase().equals(bookName.toLowerCase())){
                                        index = i;
                                    }
                                }
                                if(index != -1){
                                    Book bookReturn = currentUser.getBook()[index];
                                    store.addBook(bookReturn);
                                    currentUser.getBook()[index] = null;
                                    System.out.println("| Returned book");
                                }
                                else{System.out.println("| No book found");}
                                System.out.println("| Press Enter to continue");
                                scan.nextLine();
                                clearScreen();
                            }
                        }
                    } 
                    else{
                        System.out.println("| No user found. Press enter to continue.");
                        scan.nextLine();
                        clearScreen();
                    }
                } 
                else if(userInput == 2){
                    clearScreen();
                    
                    while(userInput != 1){
                        System.out.println("| Admin Account\n| 1. Logout\n| 2. Check Bookstore\n| 3. Add Books\n| 4. Remove Books");
                        userInput = scan.nextInt();
                        scan.nextLine();
                        clearScreen();
                        
                        if(userInput == 2){
                            System.out.println(store.bookStoreBookInfo());
                        }
                        else if(userInput == 3){
                            System.out.println("| Books: " + store.bookStoreBookInfo());
                            String title;
                            String author;
                            String isbn;
                            int yearPublished;
                            int qt;
                            System.out.print("| Enter title:");
                            title = scan.nextLine();
                            System.out.print("| Enter author: ");
                            author = scan.nextLine();
                            System.out.print("| Enter Year of Publication: ");
                            yearPublished = scan.nextInt();
                            scan.nextLine();
                            System.out.print("| Enter Serial # of the Book: ");
                            isbn = scan.nextLine();
                            System.out.print("| Enter the amount of book to be added: ");
                            qt = scan.nextInt();
                            scan.nextLine();
                            Book newBook = new Book(title, author, yearPublished, isbn, qt);
                            System.out.println("| 1. Add Book\n| 2. Add Book to specific index");
                            userInput = scan.nextInt();
                            scan.nextLine();
                            
                            if(userInput == 1){
                                store.addBook(newBook);
                            } 
                            else if(userInput == 2){
                                System.out.print("| At what index? (0 - " + (store.getBooks().length) + ")");
                                userInput = scan.nextInt();
                                scan.nextLine();
                                store.insertBook(newBook, userInput);
                            }
                            userInput = -1;
                        } 
                        else if(userInput == 4){
                            System.out.println("| Books: " + store.bookStoreBookInfo());
                            System.out.print("| Enter the book to remove: ");
                            String bookName = scan.nextLine();
                            if(findBookName(bookName, store) != -1){
                                store.removeBook(store.getBooks()[findBookName(bookName, store)]);
                            }else{System.out.println("| No Books found\n| Press Enter to continue");}
                            scan.nextLine();
                            clearScreen();
                        }
                    }
                }
            }
        }
        scan.close();
    }
}
