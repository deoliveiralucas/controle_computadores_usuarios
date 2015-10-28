package br.managecomputer.dao;

import br.managecomputer.hibernateutil.HibernateUtil;
import br.managecomputer.model.ComputerUser;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComputerUserDao {

    public void insert(ComputerUser c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(c);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ComputerDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(ComputerUser c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(c);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ComputerDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<ComputerUser> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<ComputerUser> computers = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM ComputerUser");
            computers = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ComputerDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return computers;
    }
    
    public ComputerUser getById(ComputerUser c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ComputerUser computer = new ComputerUser();
        try {
            tx.begin();
            Query query = session
                .createQuery("FROM ComputerUser WHERE userId = :id");
            
            query.setParameter("id", c.getUserId());
            computer = (ComputerUser) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception userId.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return computer;
    }

    public void remove(ComputerUser c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(c);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ComputerUserDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
