/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Issuedbooks;

/**
 *
 * @author anikd
 */
public class IssueTable {
    public int bookId, memberId, fine;
    public String bookName,issueDate, lastDate; 

    
    
    
    public IssueTable(int bookId, int memberId, int fine, String bookName, String issueDate, String lastDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.fine = fine;
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.lastDate = lastDate;
    }
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
