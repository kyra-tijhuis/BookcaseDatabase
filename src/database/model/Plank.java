package database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kyra on 14/04/2016.
 */
@Entity
public class Plank {
    private int plankId;
    private int height;
    private Collection<BookDetails> books;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getPlankId() {
        return plankId;
    }

    public void setPlankId(int plankId) {
        this.plankId = plankId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, targetEntity = BookDetails.class)
    public Collection<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(Collection<BookDetails> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plank plank = (Plank) o;

        if (plankId != plank.plankId) return false;
        return books != null ? books.equals(plank.books) : plank.books == null;

    }

    @Override
    public int hashCode() {
        int result = plankId;
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
