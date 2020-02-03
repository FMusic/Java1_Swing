package com.fm.ui;

import com.fm.controller.DoctorsController;
import com.fm.controller.PatientsController;
import com.fm.model.*;
import com.fm.utils.SwingUtils;
import com.sun.istack.Nullable;
import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DoctorScreen extends  JFrame{
    private ComprehensivePatientEntity cpe;
    MiniPatientEntity[] listOfPatients;
    private JPanel pnlMain;
    private JComboBox<MiniPatientEntity> cbPatients;
    private JPanel pnlNorth;
    private JButton goButton;
    private JPanel panelCombo;
    private JPanel pnlBoxButtons;
    private JPanel pnlDate;
    private JList list1;
    private JTextArea textArea1;
    private JPanel pnlSpecs;
    private JButton btnSend;
    private JComboBox<StaffEntity> cbSpecs;
    JButton butOpenComprehensive;
    private JButton butNewFile;
    private PatientsFilesEntity[] listOfFiles;
    JDatePicker picker;
    StaffEntity[] specs;

    public DoctorScreen(){
        initData();
        initWidgets();
        initForm();
        initListeners();
    }

    private void initListeners() {
        cbPatients.addActionListener(actionEvent -> loadDataForPatient((MiniPatientEntity) cbPatients.getSelectedItem()));
        goButton.addActionListener(actionEvent -> loadDataForPatient((MiniPatientEntity) cbPatients.getSelectedItem()));
        butNewFile.addActionListener(actionEvent -> {
            setFile(null);
        });
        butOpenComprehensive.addActionListener(actionEvent -> (new ComprehensiveForm((MiniPatientEntity) cbPatients.getSelectedItem())).setVisible(true));
        cbPatients.addActionListener(actionEvent -> setFile(cbPatients.getSelectedItem()));
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DoctorsController.changeDoctor((MiniPatientEntity)cbPatients.getSelectedItem(), (StaffEntity) cbSpecs.getSelectedItem());
            }
        });
    }

    private void setFile(@Nullable Object patientFile) {
        if (patientFile instanceof PatientsFilesEntity || patientFile == null){
            //todo - set controls for file
            PatientsFilesEntity pfe = (PatientsFilesEntity) patientFile;
            if (patientFile != null){
                //todo - set texts
            }
        }
    }

    private void loadDataForPatient(MiniPatientEntity mpeSelected) {
        try {
            cpe = PatientsController.getPatientForMini(mpeSelected);
        } catch (Exception e) {
        }
        listOfFiles = (PatientsFilesEntity[]) mpeSelected.getListOfFiles().toArray();
        initComboBox();
    }

    private void initComboBox() {
        JComboBox<PatientsFilesEntity> files = new JComboBox<>(listOfFiles);
        pnlBoxButtons.add(files);
    }

    private void initData() {
        List<MiniPatientEntity> listOfMinis = PatientsController.getAllMiniPatients();
        listOfPatients = new MiniPatientEntity[listOfMinis.size()];
        for (int i = 0; i < listOfMinis.size(); i++) {
            listOfPatients[i] = listOfMinis.get(i);
        }
        List<StaffEntity> listOfStaff = DoctorsController.getWholeStaff();

        specs = DoctorsController.getSpecialists();
    }

    private void initWidgets() {
        cbPatients = new JComboBox<>(listOfPatients);
        BoxLayout bl = new BoxLayout(pnlBoxButtons, BoxLayout.PAGE_AXIS);
        pnlBoxButtons.setAlignmentX(SwingConstants.CENTER);
        pnlBoxButtons.setLayout(bl);
        butOpenComprehensive = new JButton("Open comprehensive form");
        butNewFile = new JButton("Save file as new");
        picker = new JDatePicker(Calendar.getInstance());
        pnlDate.add(picker);
        cbSpecs = new JComboBox<>(specs);
        pnlSpecs.add(cbSpecs);
//        doesnt work
//        Dimension d = new Dimension(800,30);
//        butOpenComprehensive.setSize(d);
//        butNewFile.setSize(d);
//        butOpenComprehensive.setPreferredSize(d);
//        butNewFile.setPreferredSize(d);
        SwingUtils.setPanel(pnlBoxButtons, butOpenComprehensive, butNewFile);
    }

    private void initForm() {
        SwingUtils.setPanel(panelCombo, cbPatients);
        setContentPane(pnlMain);
        setSize(700, 300);
    }
}
