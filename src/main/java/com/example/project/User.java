package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    private Book[] book;
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id){
        this.name = name;
        this.Id = Id;
        book = new Book[5];
    }

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
    public String bookListInfo(){
        String result = "";
        for(int i = 0; i < book.length; i++){
            if(book[i] == null){
                result += "empty\n";
            }else{
                result += book[i].bookInfo() + "\n";
            }
        }
        return result;
    } //returns a booklist for the user, if empty, output "empty"

    public String userInfo(){
        String result = "";
        result += "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
        return result;
    } //returns  "Name: []\nID: []\nBooks:\n[]"
       
}