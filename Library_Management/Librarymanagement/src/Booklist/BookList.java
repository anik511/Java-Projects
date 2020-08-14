/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booklist;

/**
 *
 * @author anikd
 */
public class BookList {
    public int bookId, avi;
    public String bookName, author, publisher;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAvi() {
        return avi;
    }

    public void setAvi(int avi) {
        this.avi = avi;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    

    public BookList(int bookId, int avi, String bookName, String author, String publisher) {
        this.bookId = bookId;
        this.avi = avi;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
    }
    
}
