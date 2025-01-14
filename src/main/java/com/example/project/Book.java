package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished; 
    private String isbn;
    private int quantity;
    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.

    public Book(String _title, String _author, int year, String _isbn, int qt){
        title = _title;
        author = _author;
        yearPublished = year;
        isbn = _isbn;
        quantity = qt;
    }
    
    //getter and setter methods.
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }
    
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String bookInfo(){
        String result = "";
        result += "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity; 
        return result;
    } //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
       
}