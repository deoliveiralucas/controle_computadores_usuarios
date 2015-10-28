package br.managecomputer.dao;

import br.managecomputer.hibernateutil.HibernateUtil;
import br.managecomputer.model.UserSupport;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserSupportDao{

    public void insert(UserSupport us) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(us);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(UserSupport us) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(us);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<UserSupport> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<UserSupport> userSupports = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM UserSupport ORDER BY status, supportId");
            userSupports = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return userSupports;
    }
    
    public List<UserSupport> getAllOpen() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<UserSupport> userSupports = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM UserSupport WHERE status = 1 ORDER BY supportId");
            userSupports = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.getAllOpen(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return userSupports;
    }
    
    public UserSupport getById(UserSupport us) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        UserSupport userSupport = new UserSupport();
        try {
            tx.begin();
            Query query = session
                .createQuery("FROM UserSupport WHERE userId = :id");
            
            query.setParameter("id", us.getSupportId());
            userSupport = (UserSupport) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return userSupport;
    }

    public void remove(UserSupport us) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(us);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception UserSupport.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
