package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users;
    //requires 1 empty constructor
    public BookStore(){
        users = new User[10];
        books = new Book[6];
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Book[] getBooks() {
        return books;
    }

    public void addUser(User user){
        for(int i = 0; i < users.length; i++){
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }
    } 

    public void removeUser(User user){
        for(int i = 0; i < users.length; i++){
            if(users[i] != null && users[i].equals(user)){
                users[i] = null;
            }
        }
        consolidateUsers();
    }

    public void consolidateUsers(){
        int count = 0;
        for(int i = 0; i < users.length; i++){
            if(users[i] != null){
                User temp = users[i];
                users[i] = null;
                users[count] = temp;
                count++;
            }
        }
    }

    public void addBook(Book book){
        //count the number of nulls(used later)
        int count = 0;
        for(int i = 0; i < books.length; i++){
            if(books[i] == null){
                count ++;
            } 
        }
        //creates a temporary array
        Book[] temp = new Book[books.length + 1];
        //copy "books" into temp
        for(int i = 0; i < books.length; i++){
            temp[i] = books[i];
        }
        //put book at the end
        temp[books.length] = book;
        // set "books" to temp
        books = temp;

        //remove extra null values

        Book[] nullRemover = new Book[books.length - count];
        //copy over without the nulls
        count = 0;
        for(int i = 0; i < books.length; i++ ){
            if(books[i] != null){
                nullRemover[count] = books[i];
                count++;
            }
        }
        books = nullRemover;
    }


    public void insertBook(Book book, int index){
        Book[] temp = new Book[books.length+1];
        int count = 0;
        for (int i = 0; i < temp.length; i++){
            if(i!=index){
                temp[i] = books[count];
                count++;
            } else{
                temp[i] = book;
            }
        }
        books = temp;
    }

    public void removeBook(Book book){
        for(int i = 0; i<books.length;i++){
            if(books[i].equals(book)){
                book.setQuantity(book.getQuantity() - 1);
                if(book.getQuantity() == 0){
                    books[i] = null;
                    Book[] temp = new Book[books.length - 1];
                    int count = 0;
                    for(int j = 0; j < books.length; j++){
                        if(books[j]!=null){
                            temp[count] = books[j];
                            count++;
                        } 
                    }
                    books =  temp;
                }
            }
        }
    }
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}