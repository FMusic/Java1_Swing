package com.fm.ui;

import com.fm.controller.ChartController;
import com.fm.controller.DoctorsController;
import com.fm.model.StaffEntity;
import com.fm.model.TypesEntity;
import javafx.scene.chart.Chart;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel pnlChartsCombo;
    private JComboBox<String> cbPickChart;
    private JComboBox cbPickChartLength;
    private List<StaffEntity> listOfDocs;
    private List<StaffEntity> listOfSpecs;
    private StaffEntity[] arrayOfDocs;
    private StaffEntity[] arrayOfSpecs;
    private StaffEntity selected;
    private String[] listChartsWeek;
    private String[] listChartLength;
    private String[] listChartsDay;

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
        listChartLength = new String[2];
        listChartLength[0] = "Daily";
        listChartLength[1] = "Weekly";
        listChartsDay = new String[3];
        listChartsWeek = new String[2];
        listChartsDay[0] ="New patients by doctor - TIMESERIES";
        listChartsDay[1] ="All fees by patient - COLUMNS";
        listChartsDay[2] = "Patients by doctor -  PIE";
        listChartsWeek[0] ="Weekly patients by doctor";
        listChartsWeek[1] = "Average number of patients per doctor";
    }

    private void initWidgets() {
        listDr.setListData(arrayOfDocs);
        listSpec.setListData(arrayOfSpecs);
        pnlStaff.setVisible(false);
        cbPickChartLength = new JComboBox<>(listChartLength);
        pnlChartsCombo.add(cbPickChartLength);
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
        cbPickChartLength.addActionListener(actionEvent -> {
            String chosen = (String) cbPickChartLength.getSelectedItem();
            if (chosen.equals(listChartLength[0])){
                cbPickChart = new JComboBox<>(listChartsDay);
            } else{
                cbPickChart = new JComboBox<>(listChartsWeek);
            }
            pnlChartsCombo.removeAll();
            pnlChartsCombo.add(cbPickChartLength);
            cbPickChartLength.setSelectedItem(chosen);
            pnlChartsCombo.add(cbPickChart);
            pnlChartsCombo.updateUI();
        });
        cbPickChart.addActionListener(actionEvent -> {
            String chosen = (String) cbPickChart.getSelectedItem();
            if(chosen.equals(listChartsDay[0])){
                pnlChart.add(ChartController.dailyChartTimeseriesNewPatientsByDoctor());
            }
            if (chosen.equals(listChartsDay[1])){
                pnlChart.add(ChartController.dailyChartAllFeesByPatient());
            }
            if(chosen.equals(listChartsDay[2])){
                pnlChart.add(ChartController.dailyChartPiePatientsByDoctors());
            }
            if (chosen.equals(listChartsWeek[0])){
                pnlChart.add(ChartController.weeklyChartTimeseriesNewPatientsByDoctor());
            }
            //todo - last chart
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
        setSize(700, 800);
        setContentPane(pnlMain);
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        showStaffInfo(listOfDocs.get(( (JList) listSelectionEvent.getSource()).getSelectedIndex()), (JList) listSelectionEvent.getSource());
    }
}
