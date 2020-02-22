package com.example.spike;

public class User {
    
    private int id;
    private String aboutMe;
    private String myClasses;
    private String futureGoals;
    private String funStuff;
    private String otherStuff;
    private String interestingLinks;
    private String username;
    private String password;

    public User(int id, String aboutMe, String myClasses, String futureGoals, String funStuff, String otherStuff, String interestingLinks, String username, String password) {
        
        this.id = id;
        this.aboutMe = aboutMe;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getAboutMe(){
        return this.aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getMyClasses() {
        return this.myClasses;
    }

    public void setMyClasses(String myClasses) {
        this.myClasses = myClasses;
    }

    public String getFutureGoals() {
        return this.futureGoals;
    }

    public void setFutureGoals(String futureGoals) {
        this.futureGoals = futureGoals;
    }

    public String getFunStuff() {
        return this.funStuff;
    }

    public void setFunStuff(String funStuff) {
        this.funStuff = funStuff;
    }

    public String getOtherStuff() {
        return this.otherStuff;
    }

    public void setOtherStuff(String otherStuff) {
        this.otherStuff = otherStuff;
    }

    public String getInterestingLinks() {
        return this.interestingLinks;
    }

    public void setInterestingLinks() {
        this.interestingLinks = interestingLinks;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid(){
        if (this.id >= 0 ){
            return true;
        }
        return false;
    }
}