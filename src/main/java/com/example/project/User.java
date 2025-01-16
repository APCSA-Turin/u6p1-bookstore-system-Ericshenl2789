package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[] book;

    //contructor with two parameters that will initialize the name and id
    public User(String name, String Id){
        this.name = name;
        this.Id = Id;
        book = new Book[5];
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setBooks(Book[] book) {
        this.book = book;
    }
    
    public String getId() {
        return Id;
    }
    
    public void setId(String id) {
        Id = id;
    }
    public Book[] getBook() {
        return book;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    //returns a string with all the book info, replacing null with "empty"
    public String bookListInfo(){
        //intizalizes the result variable
        String result = "";
        //add each book to result
        for(int i = 0; i < book.length; i++){
            //if it is null, add "empty" instead
            if(book[i] == null){
                result += "empty\n";
            }else{
                result += book[i].bookInfo() + "\n";
            }
        }
        return result;
    }

    //returns the name, id and all of the books of the user.
    public String userInfo(){
        String result = "";
        //calls bookListInfo for a String of all the books.
        result += "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
        return result;
    }
       
}