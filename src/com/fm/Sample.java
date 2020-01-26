package com.fm;

import com.fm.dbRepo.RepoManager;
import com.fm.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fm.utils.CalUtils;

import java.sql.Date;

public class Sample {
    public static void putSampleData(){
        final Session session = RepoManager.getSession();
        //objects instantiation
        TypesEntity teDoctor = new TypesEntity("dr");
        TypesEntity teSpec = new TypesEntity("spec");
        StaffEntity teDrFrane = new StaffEntity("Frane", "Music", teDoctor, true);
        StaffEntity teSpecAdela = new StaffEntity("Adela", "Lukic", teSpec, true);
        AddressInfoEntity anaPermAdress = new AddressInfoEntity(17, "Lipovljanska", "Zagreb", "Zagreb",
                "Croatia", "10000");
        AddressInfoEntity anaAdress = anaPermAdress;
        ContactDetailsEntity cde = new ContactDetailsEntity(anaAdress, anaPermAdress, "none", "None",
                "0911611136", "pager", "fax", "email");
        NextOfKinsEntity nke = new NextOfKinsEntity(cde,"Frane", "Music", "Music", "Daddy");
        MiniPatientEntity miniAna = new MiniPatientEntity(new Date(System.currentTimeMillis()), "Ana", "Music",
                "Skocibusic", "F", CalUtils.getDate(27,01,1996),
                "Glupa je", "0911611136", "none", nke);
        ImportantMedicalComplaintsEntity importantMedicalComplAna = new ImportantMedicalComplaintsEntity("no", "no", "good", "bad", "always shitting", "good", "doesn't have",
                "doesnt have a brain", "Frane", "Fucking with him", "none");
        BasicComplaintsEntity basicComplaintsAna = new BasicComplaintsEntity("Stoopid", "history", teDrFrane);
        LifestyleDetsEntity lifestyleAna = new LifestyleDetsEntity(false, true, 20, true, 100, true, 1, 2, false, false);
        PersonalDetailsEntity personalDetsAna = new PersonalDetailsEntity("unamarried", 4, 180, 62, "0");
        ProfessionDetsEntity professionAna = new ProfessionDetsEntity("Mathematician", 20000);
        ComprehensivePatientEntity cpe = new ComprehensivePatientEntity(new Date(System.currentTimeMillis()), miniAna, cde, nke, personalDetsAna, professionAna,
                lifestyleAna, basicComplaintsAna, importantMedicalComplAna);
        Transaction tx = session.beginTransaction();
        session.save(teDoctor);
        session.save(teSpec);
        session.save(teDrFrane);
        session.save(teSpecAdela);
        session.save(anaPermAdress);
        session.save(anaAdress);
        session.save(cde);
        session.save(nke);
        session.save(miniAna);
        session.save(importantMedicalComplAna);
        session.save(basicComplaintsAna);
        session.save(lifestyleAna);
        session.save(personalDetsAna);
        session.save(professionAna);
        session.save(cpe);
        tx.commit();
        RepoManager.closeSession();
    }
}

