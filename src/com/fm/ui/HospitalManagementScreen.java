package com.fm.ui;

import com.fm.controller.DoctorsController;
import com.fm.model.StaffEntity;

import javax.swing.*;
import java.util.List;

public class HospitalManagementScreen extends JFrame {
    private JPanel pnlMain;
    private JList listDr;
    private JList listSpec;
    private JButton newDoctorButton;
    private JButton newSpecialistButton;

    public HospitalManagementScreen(){
        initData();
        initWidgets();
        initListeners();
        setForm();
    }

    private void initData() {
        List<StaffEntity> staff = DoctorsController.getWholeStaff();
        staff.forEach( x -> {
            //todo - put in lists
        });
    }

    private void initWidgets() {

    }

    private void initListeners() {

    }

    private void setForm() {
        setSize(700, 550);
        setContentPane(pnlMain);
    }
}
