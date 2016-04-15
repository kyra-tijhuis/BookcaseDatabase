package database.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Kyra on 15/04/2016.
 */
@Entity
public class BookDetails {
    private int bookID;
    private Book book;
    private Orientation orientation;
    private int index;
    private Plank plank;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    @NotNull
    @OneToOne(cascade = {CascadeType.REMOVE}, orphanRemoval = true, targetEntity = Book.class)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @ManyToOne(targetEntity = Plank.class,cascade = {CascadeType.ALL})
    @JoinColumn(name = "plankID")
    public Plank getPlank() {
        return plank;
    }

    public void setPlank(Plank plank) {
        this.plank = plank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDetails details = (BookDetails) o;

        if (bookID != details.bookID) return false;
        if (!book.equals(details.book)) return false;
        return plank.equals(details.plank);

    }

    @Override
    public int hashCode() {
        int result = bookID;
        result = 31 * result + book.hashCode();
        result = 31 * result + plank.hashCode();
        return result;
    }
}
