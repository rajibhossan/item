package service;

import java.util.List;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import domain.Item;
import manager.HibernateUtil;

public class ItemService {
	private Session session;

	public void create(Item item) {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.save(item);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void update(Item item) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.update(item);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void destroy(Long id) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Item item = session.get(Item.class, id);

			if (item != null) {
				session.remove(item);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public List<Item> findItemEntities() {
		return findItemEntities(true, -1, -1);
	}

	public List<Item> findItemEntities(int maxResults, int firstResult) {
		return findItemEntities(false, maxResults, firstResult);
	}


	private List<Item> findItemEntities(boolean all, int maxResults, int firstResult) {

		session = HibernateUtil.getSessionFactory().openSession();
		List < Item > itemList = null;
		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Item> cq = builder.createQuery(Item.class);
			cq.select(cq.from(Item.class));
			Query<Item> q = session.createQuery(cq);
			
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}								
			itemList=q.getResultList();		
		}		
		finally {
			session.close();
		}
		return itemList;
	}

	public Item findItemById(Long id) {

		session = HibernateUtil.getSessionFactory().openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Item> cq = builder.createQuery(Item.class);
			Root<Item> root = cq.from(Item.class);

			cq.select(root).where(builder.equal(root.get("id"), id));

			Query<Item> q = session.createQuery(cq);
			Item item = q.getSingleResult();

			return item;
		} finally {
			session.close();
		}
	}

	public int getItemCount() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Item> root = criteriaQuery.from(Item.class);

			criteriaQuery.select(builder.count(root));
			Query<Long> query = session.createQuery(criteriaQuery);
			long count = query.getSingleResult();

			return (int) count;
		} finally {
			session.close();
		}
	}

}
