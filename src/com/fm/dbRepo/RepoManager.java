package com.fm.dbRepo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RepoManager {
    private static final SessionFactory ourSessionFactory;
    private static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void closeSession(){
        //session.flush();
        session.close();
    }

    public static Session getSession() throws HibernateException {
        if (session == null || !session.isOpen()){
            session = ourSessionFactory.openSession();
        }
        return session;
    }
}
