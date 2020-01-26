package com.fm.ui;

import com.fm.controller.PatientsController;
import com.fm.model.MiniPatientEntity;
import com.fm.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReceptionScreen extends JFrame {
    private JButton btnNewPatient;
    private JButton btnPatientSignIn;
    private JComboBox<MiniPatientEntity> comboExistingPatients;
    private MiniPatientEntity[] listOfPatients;
    private JButton btnNext;

    public ReceptionScreen(){
        initData();
        initWidgets();
        initListeners();
        setFrame();
    }

    private void initData() {
        List<MiniPatientEntity> minis = PatientsController.getAllMiniPatients();
        listOfPatients = new MiniPatientEntity[minis.size()];
        for (int i = 0; i < minis.size(); i++) {
            listOfPatients[i] = minis.get(i);
        }
    }

    private void initWidgets() {
        btnNewPatient = new JButton("New patient");
        comboExistingPatients = new JComboBox<>(listOfPatients);
        btnNext = new JButton("Next");
    }

    private void initListeners() {
        btnNewPatient.addActionListener(actionEvent -> new MiniPatientForm());
        btnNext.addActionListener(actionEvent -> {
            MiniPatientEntity mpe = (MiniPatientEntity) comboExistingPatients.getSelectedItem();
            try {
                new ComprehensiveForm(mpe).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setVisible(false);
        });
    }

    private void setFrame() {
        JPanel frame = new JPanel();
        frame = SwingUtils.setPanel(frame, btnNewPatient, comboExistingPatients, btnNext);
        frame.setLayout(new FlowLayout());
        add(frame);
        setSize(300,300);
        setVisible(true);
    }
}
