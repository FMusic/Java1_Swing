package com.fm.ui;

import com.fm.controller.DoctorsController;
import com.fm.model.PatientsFilesEntity;
import com.fm.utils.SwingUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class NewStaffScreen extends JFrame implements ActionListener{
    private JButton buttAdd;
    private JTextField tfName;
    private JTextField tfType;
    private JPanel pnlMain;
    private JTextField tfSurname;

    public NewStaffScreen(String staffType) {
        initWidgets(staffType);
        initListeners();
        setForm();
    }

    private void initListeners() {
        buttAdd.addActionListener(this::actionPerformed);
    }

    private void initWidgets(String staffType) {
        pnlMain = new JPanel();
        BoxLayout bl = new BoxLayout(pnlMain, BoxLayout.Y_AXIS);
        buttAdd = new JButton("Add");
        tfType = new JTextField(staffType,30);
        tfType.setEnabled(false);
        tfName = new JTextField(30);
        tfSurname = new JTextField(30);
        SwingUtils.setPanel(pnlMain, tfType, tfName, tfSurname, buttAdd);
        pnlMain.setLayout(bl);
    }

    private void setForm() {
        setSize(300, 200);
        setContentPane(pnlMain);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DoctorsController.SaveNewStaff(tfType.getText(), tfName.getText(), tfSurname.getText());
        setVisible(false);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
