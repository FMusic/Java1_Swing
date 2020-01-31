package com.fm.ui;

import com.fm.controller.DoctorsController;
import com.fm.model.StaffEntity;
import com.fm.model.TypesEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementScreen extends JFrame {
    private JPanel pnlMain;
    private JList listDr;
    private JList listSpec;
    private JButton newDoctorButton;
    private JButton newSpecialistButton;
    private List<StaffEntity> listOfDocs;
    private List<StaffEntity> listOfSpecs;

    public HospitalManagementScreen(){
        initInitial();
        initData();
        initWidgets();
        initListeners();
        setForm();
    }

    private void initInitial() {
        listOfDocs = new ArrayList<>();
        listOfSpecs = new ArrayList<>();
    }

    private void initData() {
        List<StaffEntity> staff = DoctorsController.getWholeStaff();
        staff.forEach( x -> {
            if (x.getType().equals(new TypesEntity("Doctor"))){
                listOfDocs.add(x);
            }
            if (x.getType().equals(new TypesEntity("Specialist"))){
                listOfSpecs.add(x);
            }
        });
    }

    private void initWidgets() {
        listDr.setListData(listOfDocs.toArray());
        listSpec.setListData(listOfSpecs.toArray());
    }

    private void initListeners() {
        newDoctorButton.addActionListener(actionEvent -> {
            new NewStaffScreen("Doctor").setVisible(true);
        });
        newSpecialistButton.addActionListener(actionEvent -> {
            new NewStaffScreen("Specialist").setVisible(true);
        });
    }

    private void setForm() {
        setSize(700, 550);
        setContentPane(pnlMain);
    }
}
