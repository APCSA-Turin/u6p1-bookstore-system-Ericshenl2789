package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    //private attribute String currentId. initialized to 99
    private static String currId = "99";
    // one empty constructor
    public IdGenerate(){}

    // getters
    public static String getCurrentId() {
        return currId;
    }
    //reset the currentId back to 99
    public static void reset(){
        currId = "99";
    } 
    
    //update current Id by one when called
    public static void generateID(){
        //Using parseInt to convert String to int, then adding one
        int temp = Integer.parseInt(currId) + 1;
        //turning it back to String
        currId = Integer.toString(temp);
    } 
}