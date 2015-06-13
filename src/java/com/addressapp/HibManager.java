package com.addressapp;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibManager {

    private static SessionFactory factory;      //Heavy

    static {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(ContactInfo.class);
        //new SchemaExport(config).create(true, true);   //for creating new table
        factory = config.buildSessionFactory();
    }

    /*
    public static boolean login(String ContactId, String Passwd) { // not working as encrypted password
        boolean status = false;
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from login where ContactId=:ConId and Passwd=:Pass");
        query.setParameter("ConId", ContactId);
        query.setParameter("Pass", Passwd);
        status = true;
        return status;
    }
    */
    
    public static void updateContact(ContactInfo s){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
    } 
    
    public static void addContact(ContactInfo s) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
    }
    
    public static void deleteContact(String mobile,String userName){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from ContactInfo where mobileNumber=:mno and Username=:user");
        query.setParameter("mno",mobile);
        query.setParameter("user",userName);
        ContactInfo s = (ContactInfo)query.uniqueResult();
        if(s != null){
            session.delete(s);
        }
        session.getTransaction().commit();
    } 
            
    public static ContactInfo getContact(String MobileNumber,String userName){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from ContactInfo where mobileNumber=:mno and Username=:user");
        query.setParameter("mno",MobileNumber);
        query.setParameter("user",userName);
        ContactInfo s = (ContactInfo)query.uniqueResult();
        return s;
    }
    
    public static List getAllContacts(String userName){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from ContactInfo where Username=:user");
        query.setParameter("user",userName);
        List list = query.list();
        return list;
    }   
}
