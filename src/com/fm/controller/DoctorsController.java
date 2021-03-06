package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import com.fm.model.MiniPatientEntity;
import com.fm.model.StaffEntity;
import com.fm.model.TypesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DoctorsController {
    public static List<StaffEntity> getWholeStaff() {
        String qs = "from StaffEntity";
        Session session = RepoManager.getSession();
        Query q = session.createQuery(qs);
        List<StaffEntity> staff = ((List<StaffEntity>) q.list());
        return staff;
    }

    public static void SaveNewStaff(String type, String firstname, String surname) {
        Session session = RepoManager.getSession();
        String qs = "from TypesEntity where typeName=:typename";
        Query q = session.createQuery(qs);
        q.setString("typename", type);
        TypesEntity te = (TypesEntity) q.uniqueResult();
        StaffEntity se = new StaffEntity(firstname, surname, te, true);
        Transaction tx;
        if (!session.getTransaction().isActive()) {
            tx = session.beginTransaction();
        } else{
            tx = session.getTransaction();
        }
        session.save(se);
        tx.commit();
        RepoManager.closeSession();
    }

    public static void remove(StaffEntity entity) {
        Session session = RepoManager.getSession();
        String qs = "delete StaffEntity where id=:id";
        Query q = session.createQuery(qs);
        q.setInteger("id", entity.getIdEmployee());
        Transaction tx;
        if (!session.getTransaction().isActive()) {
            tx = session.beginTransaction();
        } else{
            tx = session.getTransaction();
        }
        q.executeUpdate();
        tx.commit();
        RepoManager.closeSession();
    }

    public static void update(StaffEntity entity, String firstName, String surname, boolean availabilty) {
        Session session = RepoManager.getSession();
        Transaction tx;
        if (!session.getTransaction().isActive()) {
            tx = session.beginTransaction();
        } else{
            tx = session.getTransaction();
        }
        StaffEntity se = session.load(StaffEntity.class, entity.getIdEmployee());
        se.setName(firstName);
        se.setSurname(surname);
        se.setAvailable(availabilty);
        session.save(se);
        tx.commit();
        RepoManager.closeSession();
    }

    public static StaffEntity[] getSpecialists() {
        List<StaffEntity> specStaff = getListOfSpecs();
        StaffEntity[] toReturn = new StaffEntity[specStaff.size()];
        for (int i = 0; i < specStaff.size(); i++) {
            toReturn[i] = specStaff.get(i);
        }
        return  toReturn;
    }

    public static List<StaffEntity> getListOfSpecs() {
        return getSubset("Specialist");
    }

    public static void changeDoctor(MiniPatientEntity patient, StaffEntity toDoctor) {
        StaffEntity oldDoc = patient.getDoctorForPatient();
        patient.setDoctorForPatient(toDoctor);
        oldDoc.getPatients().remove(patient);
        toDoctor.getPatients().add(patient);
    }

    public static List<StaffEntity> getListOfDoctors() {
        return getSubset("Doctor");
    }

    private static List<StaffEntity> getSubset(String subsetString) {
        List<StaffEntity> wholeStaff = getWholeStaff();
        List<StaffEntity> specs = new ArrayList<>();
        wholeStaff.forEach(x->{
            if (x.getType().getTypeName().equals(subsetString)){
                specs.add(x);
            }
        });
        return specs;
    }

    public static List<TypesEntity> getAvailableTypes(){
        String qs = "from TypesEntity";
        List<TypesEntity> lista = new ArrayList<>();
        Session s = RepoManager.getSession();
        Query q = s.createQuery(qs);
        q.list().forEach(x-> {
            lista.add((TypesEntity) x);
        });
        RepoManager.closeSession();
        return lista;
    }
}
