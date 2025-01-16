package com.example.project;

public class BookStore{

    //2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users;
    //1 empty constructor
    public BookStore(){
        users = new User[10];
        books = new Book[6];
    }

    //getters and setters
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
        //finds the first null and put the user there
        for(int i = 0; i < users.length; i++){
            if(users[i] == null){
                users[i] = user;
                //afterwards, break so only one user is added
                break;
            }
        }
    } 

    public void removeUser(User user){
        for(int i = 0; i < users.length; i++){
            //finds the user to be removed
            if(users[i] != null && users[i].equals(user)){
                //set it to null
                users[i] = null;
                break;
            }
        }
        //remove the nulls between the users using consolidate
        consolidateUsers();
    }

    //[u1, null, u2, null, null, u3...] ---> [u1, u2, u3, null, null...]
    public void consolidateUsers(){
        int count = 0;
        //loops through users, finding and user and put it at index "count"
        for(int i = 0; i < users.length; i++){
            //find user
            if(users[i] != null){
                //move the user
                User temp = users[i];
                users[i] = null;
                users[count] = temp;
                //update the index at which the next user will be placed
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
        //set books to the new array without any nulls
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

    public String bookStoreUserInfo(){ 
        String result = "| ";
        for(User user : users){
            if(user != null){
                result += user.getName() + " | ";    
            }else{
                result += "Empty | ";
            }
        }
        return result;
    } 

}