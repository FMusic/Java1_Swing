package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import com.fm.model.StaffEntity;
import com.fm.model.TypesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;

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
        Transaction tx = session.beginTransaction();
        session.save(se);
        tx.commit();
        RepoManager.closeSession();
    }

    public static void remove(StaffEntity entity) {
        Session session = RepoManager.getSession();
        String qs = "delete StaffEntity where id=:id";
        Query q = session.createQuery(qs);
        q.setInteger("id", entity.getIdEmployee());
        Transaction tx = session.beginTransaction();
        q.executeUpdate();
        tx.commit();
        RepoManager.closeSession();
    }
}
