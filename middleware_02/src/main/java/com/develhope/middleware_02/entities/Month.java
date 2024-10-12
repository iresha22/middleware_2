package com.develhope.middleware_02.entities;




public class Month {
    // parameters
    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    // empty constructor
    public Month(){}

    // constructor with all the parameters
    public Month(int monthNumber,String italianName,String englishName,String germanName) {
        this.germanName = germanName;
        this.italianName = italianName;
        this.englishName = englishName;
        this.monthNumber = monthNumber;
    }

    // getters and setters
    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }
}
