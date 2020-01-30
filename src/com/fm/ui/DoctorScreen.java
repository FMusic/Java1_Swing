package com.fm.ui;

import com.fm.controller.PatientsController;
import com.fm.dbRepo.RepoManager;
import com.fm.model.MiniPatientEntity;

import javax.swing.*;
import java.util.List;

public class DoctorScreen extends  JFrame{
    MiniPatientEntity[] listOfPatients;
    private JPanel pnlMain;
    private JComboBox<MiniPatientEntity> cbPatients;
    private JButton goButton;

    public DoctorScreen(){
        initData();
        initWidgets();
        initForm();
    }

    private void initData() {
        List<MiniPatientEntity> listOfMinis = PatientsController.getAllMiniPatients();
        listOfPatients = new MiniPatientEntity[listOfMinis.size()];
        for (int i = 0; i < listOfMinis.size(); i++) {
            listOfPatients[i] = listOfMinis.get(i);
        }
    }

    private void initWidgets() {
        cbPatients = new JComboBox<>(listOfPatients);
    }

    private void initForm() {
        setContentPane(pnlMain);
        setSize(400, 300);
    }
}
