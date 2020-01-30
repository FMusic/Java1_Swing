package com.fm.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton btnStaffManagement;
    private JButton btnReception;
    private JButton btnDoctor;

    public MainMenu(){
        super();
        initWidgets();
        setPanel();
        setListeners();
     }

    private void setListeners() {
        btnStaffManagement.addActionListener(actionEvent -> {
            new HospitalManagementScreen().setVisible(true);
            setVisible(false);
        });
        btnDoctor.addActionListener(actionEvent -> {
            new DoctorScreen().setVisible(true);
            setVisible(false);
        });
        btnReception.addActionListener(actionEvent -> {
            new ReceptionScreen();
            setVisible(false);
        });
    }

    private void setPanel() {
        setSize(505,310);
        setLayout(null);
    }

    private void initWidgets() {
        btnStaffManagement = new JButton("Staff Management");
        btnReception = new JButton("Reception");
        btnDoctor = new JButton("Doctor");
        initButton(btnStaffManagement, 0);
        initButton(btnReception, 1);
        initButton(btnDoctor, 2);
        add(btnStaffManagement);
        add(btnReception);
        add(btnDoctor);
    }

    private void initButton(JButton butt, int i) {
        int height = 250;
        int width = 150;
        int initPaddingLeft = 10;
        int initPaddingUp = 10;
        butt.setBounds((i+1)*initPaddingLeft+ i*width, initPaddingUp, width, height);
    }
}
