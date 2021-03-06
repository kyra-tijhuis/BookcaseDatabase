package database.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	// Zie de class Person voor toelichting van dit programma
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookcases");

		User user = new User();
        user.setUserName("Kyra");
        user.setSalt("salt");
        user.setPasswordHash("hash");
        user.setBookcases(new ArrayList<>());

        Book book = new Book();
        book.setIsbn("1234567890123");
		book.setAuthor("Author");
        book.setBookTitle("Title");
        book.setWidth(150);
        book.setHeight(200);
        book.setThickness(20);
        book.setCover(null);

        BookDetails details = new BookDetails();
        details.setBook(book);
        details.setOrientation(Orientation.SPINE);

        Plank plank = new Plank();
        plank.setBooks(new ArrayList<>());
        plank.getBooks().add(details);
        details.setPlank(plank);
        details.setIndex(0);
        plank.setHeight(300);

        Bookcase bookcase = new Bookcase();
        bookcase.setBookcaseName("Boekenkast");
        bookcase.setPlanks(new ArrayList<>());
        bookcase.getPlanks().add(plank);
        bookcase.setWidth(800);

        user.getBookcases().add(bookcase);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(user);
        em.persist(bookcase);
        em.persist(plank);
		em.persist(book);
	
		t.commit();
		em.close();
		emf.close();
	}

}
