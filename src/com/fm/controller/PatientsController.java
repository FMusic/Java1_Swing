package com.fm.controller;

import com.fm.dbRepo.RepoManager;
import com.fm.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public static void saveOrUpdatePatient(ComprehensivePatientEntity cpe) {
        MiniPatientEntity mpe = cpe.getMiniPatient();
        ContactDetailsEntity cde = cpe.getContactDetails();
        AddressInfoEntity perm = cde.getPermanentAddress();
        AddressInfoEntity pres = cde.getPresentAddress();
        NextOfKinsEntity nok = cpe.getNextOfKin();
        ContactDetailsEntity nokCde = nok.getContactDetails();
        AddressInfoEntity nokPerm = nokCde.getPermanentAddress();
        AddressInfoEntity nokPres = nokCde.getPresentAddress();
        PersonalDetailsEntity pde = cpe.getPersonalDetails();
        ProfessionDetsEntity prof = cpe.getProfessionDets();
        LifestyleDetsEntity ld = cpe.getLifestyleDets();
        BasicComplaintsEntity bce = cpe.getBasicComplaints();
        ImportantMedicalComplaintsEntity imc = cpe.getImportantMedicalCompl();

        Session s = RepoManager.getSession();
        Transaction tx;
        if (!s.getTransaction().isActive()) {
            tx = s.beginTransaction();
        } else{
            tx = s.getTransaction();
        }
        s.saveOrUpdate(cpe.getBasicComplaints().getPhysicianTreated());
        s.saveOrUpdate(imc);
        s.saveOrUpdate(bce);
        s.saveOrUpdate(ld);
        s.saveOrUpdate(prof);
        s.saveOrUpdate(pde);
        s.saveOrUpdate(nokPres);
        s.saveOrUpdate(nokPerm);
        s.saveOrUpdate(nokCde);
        s.saveOrUpdate(nok);
        s.saveOrUpdate(pres);
        s.saveOrUpdate(perm);
        s.saveOrUpdate(cde);
        s.saveOrUpdate(mpe);
        s.saveOrUpdate(cpe);
        s.flush();
        tx.commit();
        RepoManager.closeSession();
    }

    public static void saveMiniPatient(MiniPatientEntity mpe) {
        List<StaffEntity> docs = DoctorsController.getListOfDoctors();
        final StaffEntity[] sa = new StaffEntity[1];
        docs.forEach(x->{
            if (x.getAvailable()){
                sa[0] = x;
            }
        });
        Session s = RepoManager.getSession();
        Transaction tx;
        if (!s.getTransaction().isActive()) {
            tx = s.beginTransaction();
        } else{
            tx = s.getTransaction();
        }
        mpe.setDoctorForPatient(sa[0]);
        sa[0].getPatients().add(mpe);
        NextOfKinsEntity nok = mpe.getNextOfKin();
        ContactDetailsEntity cde = new ContactDetailsEntity();
        nok.setContactDetails(cde);
        s.saveOrUpdate(cde);
        s.saveOrUpdate(nok);
        s.saveOrUpdate(nok);
        s.saveOrUpdate(sa[0]);
        s.saveOrUpdate(mpe);
        tx.commit();
        RepoManager.closeSession();
    }
}
