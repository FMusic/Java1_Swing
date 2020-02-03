package com.fm.ui;

import com.fm.controller.ChartController;
import com.fm.controller.DoctorsController;
import com.fm.model.StaffEntity;
import com.fm.model.TypesEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagementScreen extends JFrame implements ListSelectionListener{
    private JPanel pnlMain;
    private JList listDr;
    private JList listSpec;
    private JButton newDoctorButton;
    private JButton newSpecialistButton;
    private JPanel pnlStaff;
    private JButton deleteButton;
    private JButton saveChangesButton;
    private JTextField tfName;
    private JTextField tfSurname;
    private JList listPatients;
    private JCheckBox availableCheckBox;
    private JPanel pnlChart;
    private List<StaffEntity> listOfDocs;
    private List<StaffEntity> listOfSpecs;
    private StaffEntity[] arrayOfDocs;
    private StaffEntity[] arrayOfSpecs;
    private StaffEntity selected;

    public HospitalManagementScreen(){
        initData();
        initWidgets();
        initListeners();
        setForm();
    }

    private void initData() {
        List<StaffEntity> staff = DoctorsController.getWholeStaff();
        listOfDocs = new ArrayList<>();
        listOfSpecs = new ArrayList<>();
        staff.forEach( x -> {
            if (x.getType().equals(new TypesEntity("Doctor"))){
                listOfDocs.add(x);
            }
            if (x.getType().equals(new TypesEntity("Specialist"))){
                listOfSpecs.add(x);
            }
        });
        arrayOfSpecs = new StaffEntity[listOfSpecs.size()];
        for (int i = 0; i < listOfSpecs.size(); i++) {
            arrayOfSpecs[i] = listOfSpecs.get(i);
        }
        arrayOfDocs = new StaffEntity[listOfDocs.size()];
        for (int i = 0; i < listOfDocs.size(); i++) {
            arrayOfDocs[i] = listOfDocs.get(i);
        }
    }

    private void initWidgets() {
        listDr.setListData(arrayOfDocs);
        listSpec.setListData(arrayOfSpecs);
        pnlStaff.setVisible(false);
    }

    private void initListeners() {
        newDoctorButton.addActionListener(actionEvent -> {
            new NewStaffScreen("Doctor").setVisible(true);
            setVisible(false);
        });
        newSpecialistButton.addActionListener(actionEvent -> {
            new NewStaffScreen("Specialist").setVisible(true);
            setVisible(false);
        });
        listDr.addListSelectionListener(this::valueChanged);
        listSpec.addListSelectionListener(this::valueChanged);
        deleteButton.addActionListener(actionEvent -> {
            deleteFromLists(selected);
            setVisible(false);
            new HospitalManagementScreen().setVisible(true);
        });
        saveChangesButton.addActionListener(actionEvent -> {
            DoctorsController.update(selected, tfName.getText(), tfSurname.getText(), availableCheckBox.isSelected());
            new HospitalManagementScreen().setVisible(true);
            setVisible(false);
        });
    }

    private void deleteFromLists(StaffEntity toDelete) {
        if (toDelete.getType().getTypeName().equals("Doctor")){
            listOfDocs.remove(toDelete);
            arrayOfDocs = new StaffEntity[listOfDocs.size()];
            for (int i = 0; i < listOfDocs.size(); i++) {
                arrayOfDocs[i] = listOfDocs.get(i);
            }
        }
        if (toDelete.getType().getTypeName().equals("Specialist")){
            listOfSpecs.remove(toDelete);
            arrayOfSpecs = new StaffEntity[listOfSpecs.size()];
            for (int i = 0; i < listOfSpecs.size(); i++) {
                arrayOfSpecs[i] = listOfSpecs.get(i);
            }
        }
        DoctorsController.remove(toDelete);
    }

    private void showStaffInfo(StaffEntity staffEntity, JList source) {
        //pnlStaff
        if (source == listDr){
            selected = (StaffEntity) listDr.getSelectedValue();
        }
        if (source == listSpec){
            selected = (StaffEntity) listSpec.getSelectedValue();
        }
        if (selected != null){
            pnlStaff.setVisible(true);
            tfName.setText(selected.getName());
            tfSurname.setText(selected.getSurname());
            availableCheckBox.setSelected(selected.getAvailable());
            listPatients.setListData(selected.getPatients() != null ? selected.getPatients().toArray() : new ArrayList<>().toArray());
        }
    }

    private void setForm() {
        setSize(700, 550);
        setContentPane(pnlMain);
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        showStaffInfo(listOfDocs.get(( (JList) listSelectionEvent.getSource()).getSelectedIndex()), (JList) listSelectionEvent.getSource());
    }
}
