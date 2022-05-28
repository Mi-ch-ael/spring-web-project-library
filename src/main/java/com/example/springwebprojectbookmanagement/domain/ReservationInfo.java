package com.example.springwebprojectbookmanagement.domain;

public class ReservationInfo {
    private String givenTo;
    private String returnDate;

    public ReservationInfo(String givenTo, String returnDate) {
        this.givenTo = givenTo;
        this.returnDate = returnDate;
    }

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
