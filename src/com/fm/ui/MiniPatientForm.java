package com.fm.ui;

import com.fm.model.MiniPatientEntity;
import org.hibernate.cfg.NotYetImplementedException;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static com.fm.utils.SwingUtils.setPanel;

public class MiniPatientForm extends JFrame {
    private MiniPatientEntity data;


    private String strFirst = "First name:";
    private String strMiddle = "Middle name:";
    private String strLast = "Last name:";
    private String strSex = "Sex:";
    private String strDate = "Date of birth:";
    private String strBrief = "Brief statement of complaint:";
    private String strTelephone = "Telephone number:";
    private String strKin = "Next-of-kin";

    private JLabel lblFirst;
    private JTextField tfFirst;
    private JLabel lblMiddle;
    private JTextField tfMiddle;
    private JLabel lblLast;
    private JTextField tfLast;
    private JLabel lblSex;
    private ButtonGroup btnGroup;
    private JRadioButton radioMale;
    private JRadioButton radioFemale;
    private JLabel lblDate;
    private JDatePicker jdpDate;
    private JLabel lblBrief;
    private JTextField tfBrief;
    private JLabel lblTelephone1;
    private JTextField tfTelephone1;
    private JLabel lblTelephone2;
    private JTextField tfTelephone2;
    private JLabel lblKinFirst;
    private JTextField tfKinFirst;
    private JLabel lblKinMiddle;
    private JTextField tfKinMiddle;
    private JLabel lblKinLast;
    private JTextField tfKinLast;
    private JLabel lblRelationship;
    private JTextField tfRelationship;

    private FlowLayout fl;
    private JButton btnSave;


    public MiniPatientForm() {
        initWidgets();
        setListeners();
        showFrame();
    }

    private void setListeners() {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveData();
            }
        });
    }

    private void saveData() {
        throw new NotYetImplementedException();
    }

    public MiniPatientForm(MiniPatientEntity mfm){
        new MiniPatientForm();
        data = mfm;
        setTexts();
    }

    private void showFrame() {
        setSize(700,450);
        setVisible(true);
    }

    private void initWidgets() {
        JPanel paneAll = new JPanel();
        fl = new FlowLayout();
        lblFirst = new JLabel(strFirst);
        lblMiddle = new JLabel(strMiddle);
        lblLast = new JLabel(strLast);
        tfFirst = setNewTextField();
        tfMiddle = setNewTextField();
        tfLast = setNewTextField();
        JPanel nameGrid = new JPanel(fl);
        nameGrid = setPanel(nameGrid, lblFirst, tfFirst, lblMiddle, tfMiddle, lblLast, tfLast);

        JPanel sexGrid = new JPanel(fl);
        lblSex = new JLabel(strSex);
        radioFemale = new JRadioButton("Female");
        radioMale = new JRadioButton("Male");
        btnGroup = new ButtonGroup();
        btnGroup.add(radioFemale);
        btnGroup.add(radioMale);
        sexGrid = setPanel(sexGrid, lblSex, radioFemale, radioMale);

        JPanel detailsPanel = new JPanel(new FlowLayout());
        lblTelephone1 = new JLabel(strTelephone);
        tfTelephone1 = setNewTextField();
        lblTelephone2 = new JLabel(strTelephone);
        tfTelephone2 = setNewTextField();
        detailsPanel = setPanel(detailsPanel, lblTelephone1, tfTelephone1, lblTelephone2, tfTelephone2);

        JPanel kinPanel = new JPanel(new FlowLayout());
        lblKinFirst = new JLabel(strFirst);
        tfKinFirst = setNewTextField();
        lblKinMiddle = new JLabel(strMiddle);
        tfKinMiddle = setNewTextField();
        lblKinLast = new JLabel(strLast);
        tfKinLast = setNewTextField();
        kinPanel = setPanel(kinPanel, lblKinFirst, tfKinFirst, lblKinMiddle, tfKinMiddle, lblKinLast, tfKinLast);

        JPanel birthPanel = new JPanel(new FlowLayout());
        lblDate = new JLabel(strDate);
        jdpDate = new JDatePicker(Calendar.getInstance());
        birthPanel = setPanel(birthPanel, lblDate, jdpDate);

        JPanel briefPanel = new JPanel(new FlowLayout());
        lblBrief = new JLabel(strBrief);
        tfBrief = setNewTextField();
        briefPanel = setPanel(briefPanel, lblBrief, tfBrief);

        btnSave = new JButton("Save & Finish");

        GroupLayout gl = new GroupLayout(paneAll);
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                .addComponent(nameGrid)
                .addComponent(sexGrid)
                .addComponent(detailsPanel)
                .addComponent(kinPanel)
                .addComponent(birthPanel)
                .addComponent(briefPanel)
                .addComponent(btnSave)
        );
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(nameGrid)
                .addComponent(sexGrid)
                .addComponent(detailsPanel)
                .addComponent(kinPanel)
                .addComponent(birthPanel)
                .addComponent(briefPanel)
                .addComponent(btnSave)
        );
        paneAll.setLayout(gl);
        paneAll.setSize(640,400);
        add(paneAll);
    }

    private JTextField setNewTextField() {
        return new JTextField(null, 10);
    }


    private void setTexts() {
//        tfFirst.setText(data.getName().getFirstName());
//        tfMiddle.setText(data.getName().getMiddleName());
//        tfLast.setText(data.getName().getLastName());
//
//        tfKinFirst.setText(data.getNextOfKinName().getFirstName());
//        tfKinMiddle.setText(data.getNextOfKinName().getMiddleName());
//        tfKinLast.setText(data.getNextOfKinName().getLastName());
//
//        throw new NotYetImplementedException();
    }
}
