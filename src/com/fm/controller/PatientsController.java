package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import com.fm.model.ComprehensivePatientEntity;
import com.fm.model.MiniPatientEntity;
import com.fm.model.StaffEntity;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;

import java.util.List;

public class PatientsController {

    public static List<ComprehensivePatientEntity> getAllPatients() {
        String qs = "from ComprehensivePatientEntity";
        Query q = RepoManager.getSession().createQuery(qs);
        List<ComprehensivePatientEntity> list = q.list();
        RepoManager.closeSession();
        return list;
    }

    public static List<MiniPatientEntity> getAllMiniPatients(){
        String qs = "from MiniPatientEntity";
        Query q = RepoManager.getSession().createQuery(qs);
        List<MiniPatientEntity> minis = (List<MiniPatientEntity>) q.list();
        RepoManager.closeSession();
        return minis;
    }

    public static ComprehensivePatientEntity getPatientForMini(MiniPatientEntity mpe) throws Exception {
        String qs = "from ComprehensivePatientEntity";
        Query q = RepoManager.getSession().createQuery(qs);
        List<ComprehensivePatientEntity> cpes = (List<ComprehensivePatientEntity>) q.list();
        RepoManager.closeSession();
        ComprehensivePatientEntity cpe;
        for(ComprehensivePatientEntity pe: cpes){
            if (pe.getMiniPatient().equals(mpe)){
                return pe;
            }
        }
        throw new Exception("Patient not found");
    }
}
