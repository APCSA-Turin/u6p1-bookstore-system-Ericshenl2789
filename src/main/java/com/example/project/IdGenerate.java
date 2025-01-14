package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currId = "99";
    // //requires one empty constructor
    public IdGenerate(){}

    // public  getCurrentId(){}
    public static String getCurrentId() {
        return currId;
    }
    public static void reset(){
        currId = "99";
    } //must reset the currentId back to 99
    

    public static void generateID(){
        int temp = Integer.parseInt(currId) + 1;
        currId = Integer.toString(temp);
    } //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
}