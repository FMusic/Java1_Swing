package com.fm.controller;

import com.fm.model.StaffEntity;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.List;

public class DoctorsController {
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
