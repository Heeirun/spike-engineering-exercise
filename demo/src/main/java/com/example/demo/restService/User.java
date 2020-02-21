package com.example.demo;

public class User {
    
    private int id;
    private String myClasses;
    private String futureGoals;
    private String funStuff;
    private String otherStuff;
    private String interestingLinks;
    private String username;
    private String password;

    public User(int id, String myClasses, String futureGoals, String funStuff, String otherStuff, String interestingLinks, String username, String password) {
        this.id = id;
        this.myClasses = myClasses;
        this.futureGoals = futureGoals;
        this.funStuff = funStuff;
        this.otherStuff = otherStuff;
        this.interestingLinks = interestingLinks;
        this.username = username;
        this.password = password;
    }

    public int getId(){
        return this.id;
    }

    public String getFutureGoals() {
        return this.futureGoals;
    }

    public String getFunStuff() {
        return this.funStuff;
    }

    public String getOtherStuff() {
        return this.otherStuff;
    }

    public String getInterestingLinks() {
        return this.interestingLinks;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isValid(){
        if (this.id >= 0 ){
            return true;
        }
        return false;
    }
}