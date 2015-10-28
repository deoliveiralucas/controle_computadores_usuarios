package br.managecomputer.dao;

import br.managecomputer.hibernateutil.HibernateUtil;
import br.managecomputer.model.Responsible;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResponsibleDao{

    public void insert(Responsible r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.save(r);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ResponsibleDao.insert(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
    public void update(Responsible r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.update(r);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ResponsibleDao.update(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public List<Responsible> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Responsible> responsibles = new ArrayList<>();
        try {
            tx.begin();
            Query query = session.createQuery("FROM Responsible");
            responsibles = query.list();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ResponsibleDao.getAll(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return responsibles;
    }
    
    public Responsible getById(Responsible r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Responsible responsible = new Responsible();
        try {
            tx.begin();
            Query query = session
                .createQuery("FROM Responsible WHERE idUsuario = :id");
            
            query.setParameter("id", r.getResponsibleId());
            responsible = (Responsible) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ResponsibleDao.getById(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
        return responsible;
    }

    public void remove(Responsible r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            session.delete(r);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Exception ResponsibleDao.remove(): " + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }
    
}
