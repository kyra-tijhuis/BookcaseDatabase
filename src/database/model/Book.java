package database.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;

/**
 * Created by Kyra on 13/04/2016.
 */
@Entity
public class Book {
    private String isbn;
    private String bookTitle;
    private String author;
    private int height;
    private int width;
    private int thickness;
    private File cover;

    @Id
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (height != book.height) return false;
        if (width != book.width) return false;
        if (thickness != book.thickness) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (bookTitle != null ? !bookTitle.equals(book.bookTitle) : book.bookTitle != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (cover!= null ? !cover.equals(book.cover) : book.cover != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + thickness;
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        return result;
    }
}
