package br.managecomputer.dao;

import br.managecomputer.hibernateutil.HibernateUtil;
import br.managecomputer.model.Computer;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ComputerDao{

    public void insert(Computer c) {
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
    
    public void update(Computer c) {
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

    public List<Computer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Computer> computers = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Computer");
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
    
    public Computer getById(Computer c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Computer computer = new Computer();
        try {
            tx.begin();
            Query query = session
                .createQuery("FROM Computer WHERE computerId = :id");
            
            query.setParameter("id", c.getComputerId());
            computer = (Computer) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception computerId.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return computer;
    }

    public void remove(Computer c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(c);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ComputerDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
