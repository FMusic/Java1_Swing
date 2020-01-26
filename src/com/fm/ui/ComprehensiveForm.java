package com.fm.ui;

import com.fm.controller.PatientsController;
import com.fm.model.ComprehensivePatientEntity;
import com.fm.model.MiniPatientEntity;
import com.fm.model.NextOfKinsEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComprehensiveForm extends JFrame{
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
    private JTextField tfContactMobile;
    private JTextField tfContactFax;
    private JTextField tfContactTelHome;
    private JTextField tfContactPager;
    private JTextField tfContactEmail;
    private JTextField tfNokFirst;
    private JTextField tfNokMiddle;
    private JTextField tfNokLast;
    private JTextField tfNokRelat;
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

    public ComprehensiveForm(){
        cpe = null;
        initWidgets();
        initListeners();
        setForm();
    }

    private void setForm() {
        setContentPane(panelMain);
        setSize(new Dimension(1200, 700));
    }

    public ComprehensiveForm(MiniPatientEntity mpe) throws Exception {
        try {
            cpe = PatientsController.getPatientForMini(mpe);
            initWidgets();
            initListeners();
            initData();
            setForm();
        } catch (Exception ex){
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
        saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveData();
                exit();
            }
        });
        saveAndReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveData();
                returnScreen();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveData();
            }
        });
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
    }

    private void saveData() {

    }
}
