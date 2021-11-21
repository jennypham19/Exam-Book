package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import jpa.JPA;
import model.Book;

public class BookDao {
	public void insert(Book book) {
		EntityManager em = JPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(book);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public List<Book> findAll(){
		EntityManager em =JPA.getEntityManager();
		String sql="SELECT b FROM Book b";
		TypedQuery<Book> query = em.createQuery("sql",Book.class);
		return query.getResultList();
	}
}
