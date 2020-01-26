package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class ControllersController {
    private static PatientsController patController;
    private static DoctorsController docController;
    /**
     * Hibernate check
     */
    public static void main() {
        final Session session = RepoManager.getSession();
        //Transaction tx = session.beginTransaction();
        //session.save();
        //tx.commit();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }

    public static PatientsController getPatientController(){
        if (patController == null) {
            patController = new PatientsController();
        }
        return patController;
    }

    public static DoctorsController getDoctorController(){
        if (docController == null){
            docController = new DoctorsController();
        }
        return docController;
    }
}
