package com.fm.ui;

import com.fm.controller.PatientsController;
import com.fm.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprehensiveForm extends JFrame {
    //Frane added
    private ComprehensivePatientEntity cpe = null;
    ButtonGroup group1;
    ButtonGroup group2;
    ButtonGroup group3;

    //Form automatically imported
    private JLabel lbl;
    private JPanel panelMain;
    private JButton saveButton;
    private JButton saveAndExitButton;
    private JButton saveAndReturnButton;
    private JTabbedPane tabbedPane1;
    private JTextField tfContactPresDoorNo;
    private JTextField tfContactPresStreet;
    private JTextField tfContactPresArea;
    private JTextField tfContactPresCity;
    private JTextField tfContactPresState;
    private JTextField tfContactPresPincode;
    private JTextField tfContactPermDoorno;
    private JTextField tfContactPermStreet;
    private JTextField tfContactPermArea;
    private JTextField tfContactPermCity;
    private JTextField tfContactPermState;
    private JTextField tfContactPermPincode;
    private JTextField tfContactTelWork;
    //todo
    private JTextField tfContactMobile;
    private JTextField tfContactFax;
    private JTextField tfContactTelHome;
    //todo
    private JTextField tfContactPager;
    private JTextField tfContactEmail;
    private JTextField tfNokFirst;
    private JTextField tfNokMiddle;
    private JTextField tfNokLast;
    private JTextField tfNokRelat;
    //todo
    private JTextField tfNokDoorno;
    private JTextField tfNokStreet;
    private JTextField tfNokArea;
    private JTextField tfNokCity;
    private JTextField tfNokState;
    private JTextField tfNokPin;
    private JTextField tfNokTelWork;
    private JTextField tfNokTelHome;
    private JTextField tfNokMob;
    private JTextField tfMariatl;
    private JTextField tfNoofDep;
    private JCheckBox vegetarianCheckBox;
    private JCheckBox smokerCheckBox;
    private JCheckBox consumeAlchoholicBeveragesCheckBox;
    private JTextField tfNoOfCigarettesPerDay;
    private JTextField tfDrinksPerDay;
    private JTextField tfStimulants;
    private JTextField tfCoffeeTeaDay;
    private JTextField tfSoftDrinks;
    private JRadioButton breakfastRadioButton;
    private JRadioButton lunchRadioButton;
    private JRadioButton dinnerRadioButton;
    private JRadioButton predominantlyOutsideFoodRadioButton;
    private JRadioButton predominantlyEatHomeFoodRadioButton;
    private JTextField tfComplaint;
    private JCheckBox diabeticCheckBox;
    private JTextField tfDiabetic;
    private JCheckBox hypertensiveCheckBox;
    private JTextField tfHypertensive;
    private JCheckBox cardiacConditionCheckBox;
    private JTextField tfCardiacCond;
    private JTextField tfRespCond;
    private JCheckBox digestiveConditionCheckBox;
    private JTextField tfMiniFirst;
    private JTextField tfMiniMiddle;
    private JTextField tfMiniLast;
    private JRadioButton rbMiniMale;
    private JRadioButton rbMiniFemale;
    private JTextField tfBasicBriefStatement;
    private JTextField tfBasicPhoneNumber1;
    private JTextField tfBasicPhone2;
    //todo
    private JTextField tfMiniNextFirst;
    private JTextField tfMiniNextMiddle;
    private JTextField tfMiniNextLast;
    private JTextField tfMiniRelationship;
    private JTextField tfMiniOpid;
    private JTextField tfNokPag;
    private JTextField tfNokFax;
    private JTextField tfNokEmail;
    private JTextField tfOccupation;
    private JTextField tfGrossAnnual;
    private JTextField tfHeight;
    private JTextField tfWeight;
    private JTextField tfBloodType;
    private JTextField tfHistoryPrevTreat;
    private JTextField tfHospitalTreated;
    private JTextField tfDigestiveCond;
    private JTextField tfOrthoepdicCond;
    private JTextField tfMuscularCond;
    private JTextField tfNeuroCond;
    private JTextField tfKnownAllergies;
    private JTextField tfKnownAdverseReact;
    private JTextField tfMajorSurgeries;
    private JCheckBox respiratoryCheckBox;
    private JCheckBox orthopedicCondCheckBox;
    private JCheckBox muscularCheckBox;
    private JCheckBox neuroCheckBox;
    private JCheckBox allergiesCheckBox;
    private JCheckBox adverseReactCheckBox;
    private JCheckBox majorSurgeriesCheckbox;

//    public ComprehensiveForm() {
//        cpe = null;
//        initWidgets();
//        initListeners();
//        setForm();
//    }

    private void setForm() {
        setContentPane(panelMain);
        setSize(new Dimension(1200, 700));
    }

    public ComprehensiveForm(MiniPatientEntity mpe) {
        try {
            cpe = PatientsController.getPatientForMini(mpe);
            initWidgets();
            initListeners();
            initData();
            setForm();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void initWidgets() {
        group1 = new ButtonGroup();
        group1.add(rbMiniFemale);
        group1.add(rbMiniMale);
        group2 = new ButtonGroup();
        group2.add(predominantlyEatHomeFoodRadioButton);
        group2.add(predominantlyOutsideFoodRadioButton);
        group3 = new ButtonGroup();
        group3.add(breakfastRadioButton);
        group3.add(lunchRadioButton);
        group3.add(dinnerRadioButton);
    }

    private void initListeners() {
        saveAndExitButton.addActionListener(actionEvent -> {
            saveData();
            exit();
        });
        saveAndReturnButton.addActionListener(actionEvent -> {
            saveData();
            returnScreen();
        });
        saveButton.addActionListener(actionEvent -> saveData());
        smokerCheckBox.addActionListener(actionEvent -> tfNoOfCigarettesPerDay.setEnabled(smokerCheckBox.isSelected()));
        consumeAlchoholicBeveragesCheckBox.addActionListener(actionEvent -> tfDrinksPerDay.setEnabled(consumeAlchoholicBeveragesCheckBox.isSelected()));
    }

    private void returnScreen() {
        new ReceptionScreen().setVisible(true);
        this.setVisible(false);
    }

    private void exit() {

    }

    private void initData() {
        MiniPatientEntity mpe = cpe.getMiniPatient();
        tfMiniFirst.setText(mpe.getFirstName());
        tfMiniMiddle.setText(mpe.getMiddleName());
        tfMiniLast.setText(mpe.getLastName());
        NextOfKinsEntity nke = cpe.getNextOfKin();
        tfMiniNextFirst.setText(nke.getFirstName());
        tfMiniNextMiddle.setText(nke.getMiddleName());
        tfMiniNextLast.setText(nke.getLastName());
        tfMiniOpid.setText(String.valueOf(mpe.getIdPatient()));
        tfMiniRelationship.setText(nke.getRelationship());
        if (mpe.getSex().equals("M")) {
            rbMiniMale.setSelected(true);
        } else {
            rbMiniFemale.setSelected(true);
        }
        ContactDetailsEntity cde = cpe.getContactDetails();
        tfContactEmail.setText(cde.getEmail());
        tfContactFax.setText(cde.getFax());
        tfContactMobile.setText(cde.getMobile());
        tfContactPager.setText(cde.getPager());
        AddressInfoEntity perm = cde.getPermanentAddress();
        tfContactPermArea.setText(perm.getArea() != null ? perm.getArea() : "");
        tfContactPermCity.setText(perm.getCity() != null ? perm.getCity() : "");
        tfContactPermDoorno.setText(String.valueOf(perm.getDoorNo()) != null ? String.valueOf(perm.getDoorNo()) : "");
        tfContactPermPincode.setText(perm.getPincode() != null ? perm.getPincode() : "");
        tfContactPermState.setText(perm.getState() != null ? perm.getState() : "");
        tfContactPermStreet.setText(perm.getStreet() != null ? perm.getStreet() : "");
        AddressInfoEntity pres = cde.getPresentAddress() != null ? cde.getPresentAddress() : new AddressInfoEntity();
        tfContactPresArea.setText(pres.getArea() != null ? pres.getArea() : "");
        tfContactPresCity.setText(pres.getCity() != null ? pres.getCity() : "");
        tfContactPresState.setText(pres.getState() != null ? pres.getState() : "");
        tfContactPresPincode.setText(pres.getPincode() != null ? pres.getPincode() : "");
        tfContactPresDoorNo.setText(String.valueOf(pres.getDoorNo()) != null ? String.valueOf(pres.getDoorNo()) : "");
        tfContactPresStreet.setText(pres.getStreet() != null ? pres.getStreet() : "");
        NextOfKinsEntity nok = cpe.getNextOfKin();
        ContactDetailsEntity cdeNok = nok.getContactDetails() != null ? nok.getContactDetails() : new ContactDetailsEntity();
        AddressInfoEntity adrNok = cdeNok.getPresentAddress() != null ? cdeNok.getPresentAddress() : new AddressInfoEntity();
        tfNokArea.setText(adrNok.getArea() != null ? adrNok.getArea() : "");
        tfNokCity.setText(adrNok.getCity() != null ? adrNok.getCity() : "");
        tfNokDoorno.setText(adrNok.getDoorNo() != null ? String.valueOf(adrNok.getDoorNo()) : "");
        tfNokState.setText(adrNok.getState() != null ? adrNok.getState() : "");
        tfNokStreet.setText(adrNok.getStreet() != null ? adrNok.getStreet() : "");
        tfNokPin.setText(adrNok.getPincode() != null ? adrNok.getPincode() : "");
        tfNokEmail.setText(cdeNok.getEmail() != null ? cdeNok.getEmail() : "");
        tfNokFax.setText(cdeNok.getFax() != null ? cdeNok.getFax() : "");
        tfNokMob.setText(cdeNok.getMobile() != null ? cdeNok.getMobile() : "");
        tfNokFirst.setText(nok.getFirstName() != null ? nok.getFirstName() : "");
        tfNokMiddle.setText(nok.getMiddleName() != null ? nok.getMiddleName() : "");
        tfNokLast.setText(nok.getLastName() != null ? nok.getLastName() : "");
        tfNokPag.setText(cdeNok.getPager() != null ? cdeNok.getPager() : "");
        tfNokTelHome.setText(cdeNok.getTelephoneHome() != null ? cdeNok.getTelephoneHome() : "");
        tfNokTelWork.setText(cdeNok.getTelephoneWork() != null ? cdeNok.getTelephoneWork() : "");
        PersonalDetailsEntity pde = cpe.getPersonalDetails() != null ? cpe.getPersonalDetails() : new PersonalDetailsEntity();
        tfMariatl.setText(pde.getMaritalStatus() != null ? pde.getMaritalStatus() : "");
        tfNoofDep.setText(String.valueOf(pde.getNoOfDependents()) != null ? String.valueOf(pde.getNoOfDependents()) : "");
        tfHeight.setText(String.valueOf(pde.getHeight()) != null ? String.valueOf(pde.getHeight()) : "");
        tfWeight.setText(String.valueOf(pde.getWeight()) != null ? String.valueOf(pde.getWeight()) : "");
        tfBloodType.setText(pde.getBloodType() != null ? pde.getBloodType() : "");
        ProfessionDetsEntity prof = cpe.getProfessionDets() != null ? cpe.getProfessionDets() : new ProfessionDetsEntity();
        tfOccupation.setText(prof.getOccupation() != null ? prof.getOccupation() : "");
        tfGrossAnnual.setText(prof.getGrossAnnualIncome() != null ? String.valueOf(prof.getGrossAnnualIncome()) : "");
        setLifestyle();
        setComplaints();
    }

    private void setComplaints() {
        ImportantMedicalComplaintsEntity imc = cpe.getImportantMedicalCompl();
        BasicComplaintsEntity bce = cpe.getBasicComplaints();
        tfComplaint.setText(bce.getStatementOfComplaint() != null ? bce.getStatementOfComplaint() : "");
        tfHistoryPrevTreat.setText(bce.getHistoryOfPreviousTreatment() != null ? bce.getHistoryOfPreviousTreatment() : "");
        tfHospitalTreated.setText(bce.getPhysicianTreated().toString() != null ? bce.getPhysicianTreated().toString() : "");
        if (imc.getDiabetic() != null){
            diabeticCheckBox.setSelected(true);
            tfDiabetic.setEnabled(true);
            tfDiabetic.setText(imc.getDiabetic());
        }
        if (imc.getHypertensive()!= null){
            hypertensiveCheckBox.setSelected(true);
            tfHypertensive.setEnabled(true);
            tfHypertensive.setText(imc.getHypertensive());
        }
        if (imc.getCardiacCondition() != null){
            cardiacConditionCheckBox.setSelected(true);
            tfCardiacCond.setEnabled(true);
            tfCardiacCond.setText(imc.getCardiacCondition());
        }
        if (imc.getRespiratoryCondition() != null){
            respiratoryCheckBox.setSelected(true);
            tfRespCond.setEnabled(true);
            tfRespCond.setText(imc.getRespiratoryCondition());
        }
        if (imc.getDigestiveCondition() != null){
            digestiveConditionCheckBox.setSelected(true);
            tfDigestiveCond.setEnabled(true);
            tfDigestiveCond.setText(imc.getDigestiveCondition());
        }
        if (imc.getOrthopedicCondition() != null){
            orthopedicCondCheckBox.setSelected(true);
            tfOrthoepdicCond.setEnabled(true);
            tfOrthoepdicCond.setText(imc.getOrthopedicCondition());
        }
        if (imc.getMuscularCondition() != null){
            muscularCheckBox.setSelected(true);
            tfMuscularCond.setEnabled(true);
            tfMuscularCond.setText(imc.getMuscularCondition());

        }
        if (imc.getNeurologicalCondition() != null){
            neuroCheckBox.setSelected(true);
            tfNeuroCond.setEnabled(true);
            tfNeuroCond.setText(imc.getNeurologicalCondition());
        }
        if (imc.getAllergies() != null){
            allergiesCheckBox.setSelected(true);
            tfKnownAllergies.setEnabled(true);
            tfKnownAllergies.setText(imc.getAllergies());
        }
        if (imc.getAdverseReactions() != null){
            adverseReactCheckBox.setSelected(true);
            tfKnownAdverseReact.setEnabled(true);
            tfKnownAdverseReact.setText(imc.getAdverseReactions());
        }
        if (imc.getMajorSurgeries() != null){
            majorSurgeriesCheckbox.setSelected(true);
            tfMajorSurgeries.setEnabled(true);
            tfMajorSurgeries.setText(imc.getMajorSurgeries());
        }
    }

    private void setLifestyle() {
        LifestyleDetsEntity ld = cpe.getLifestyleDets();
        vegetarianCheckBox.setSelected(ld.getVegetarian());
        if (ld.getSmoker()){
            smokerCheckBox.setSelected(true);
            tfNoOfCigarettesPerDay.setEnabled(true);
        }
        if (ld.getConsumeAlcohol()){
            consumeAlchoholicBeveragesCheckBox.setSelected(true);
            tfDrinksPerDay.setEnabled(true);
        }
        tfStimulants.setText(ld.getStimulants() != null ? ld.getStimulants() : "");
        tfCoffeeTeaDay.setText(String.valueOf(ld.getCoffeePerDay()) != null ? String.valueOf(ld.getCoffeePerDay()) : "");
        tfSoftDrinks.setText(String.valueOf(ld.getSoftDrinksPerDay() != null ? String.valueOf(ld.getSoftDrinksPerDay()) : ""));
        //todo - set food
    }

    private void saveData() {

    }
}
