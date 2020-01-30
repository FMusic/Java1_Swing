package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import com.fm.model.StaffEntity;
import org.hibernate.Session;
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

    public void SaveStaffMember(){
        //todo - implement this
        throw new NotYetImplementedException();
    }

    public StaffEntity getStaffMember(int id){
        String qs = "from StaffEntity where id = " + id;
        //todo - complete this
        throw new NotYetImplementedException();
    }

    public void saveBulkStaffMembers(List<StaffEntity> listOfStaff){
        //todo
        throw new NotYetImplementedException();
    }

    public List<StaffEntity> getAllStaff(){
        //todo
        throw new NotYetImplementedException();
    }
}
