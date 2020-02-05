package com.fm.controller;

import com.fm.model.ComprehensivePatientEntity;
import com.fm.model.StaffEntity;
import org.hibernate.cfg.NotYetImplementedException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Week;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class ChartController {
    private static TimeSeriesCollection getTimeseriesPatientsSeenByVariousDoctors(String type){
        TimeSeriesCollection tsc = new TimeSeriesCollection();
        List<StaffEntity> staff = DoctorsController.getListOfDoctors();
        HashMap<Date, Integer> dates = new HashMap<>();
        staff.forEach(x->{
            TimeSeries series = new TimeSeries(x.getName() +  x.getSurname());
            x.getPatients().forEach(y->{
                Date dt = y.getDateOfInput();
                if (dates.containsKey(dt)){
                    Integer inte = dates.get(dt);
                    dates.remove(dt);
                    inte++;
                    dates.put(dt, inte);
                } else{
                    dates.put(dt, 1);
                }
            });
            dates.forEach((date, integer) -> {
                if (type.equals("Day")){
                    series.add(new Day(date), integer);
                }
                if (type.equals("Week")){
                    series.add(new Week(date), integer);
                }
            });
            tsc.addSeries(series);
            dates.clear();
        });
        return tsc;
    }

    public static JPanel dailyChartTimeseriesNewPatientsByDoctor(){
        String type = "Day";
        TimeSeriesCollection tps = getTimeseriesPatientsSeenByVariousDoctors(type);
        JFreeChart jfc=  ChartFactory.createTimeSeriesChart("Number of patients seen by doctors",
                "Dates",
                "Values",
                tps,
                true,
                false,
                false);
        return new ChartPanel(jfc);
    }

    public static JPanel weeklyChartTimeseriesNewPatientsByDoctor(){
        String type = "Week";
        TimeSeriesCollection tps = getTimeseriesPatientsSeenByVariousDoctors(type);
        JFreeChart jfc=  ChartFactory.createTimeSeriesChart("Number of patients seen by doctors",
                "Weeks",
                "Values",
                tps,
                true,
                false,
                false);
        return new ChartPanel(jfc);
    }

    public static JPanel dailyChartPiePatientsByDoctors(){
        DefaultPieDataset dpd = new DefaultPieDataset();
        List<StaffEntity> listOfDoctors = DoctorsController.getListOfDoctors();
        HashMap<StaffEntity, Integer> resDic = new HashMap<>();
        listOfDoctors.forEach(staffEntity -> {
            resDic.put(staffEntity, staffEntity.getPatients().size());
        });
        resDic.forEach((staffEntity, integer) -> {
            dpd.setValue(staffEntity.toString(), integer);
        });

        JFreeChart chart = ChartFactory.createPieChart(
                "Patients by doctors",
                dpd,
                true,
                false,
                false);
        return new ChartPanel(chart);
    }

    public static JPanel dailyChartAllFeesByPatient(){
        String consulFees = "Consulting fees";
        String testFees = "Ordered tests fees";
        String medFees = "Medicine fees";
        List<ComprehensivePatientEntity> allPatients = PatientsController.getAllPatients();
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        allPatients.forEach(comprehensivePatientEntity -> {
            String patientName = comprehensivePatientEntity.getMiniPatient().getFirstName() + comprehensivePatientEntity.getMiniPatient().getLastName();
            dcd.addValue(comprehensivePatientEntity.getFees().getConsultingFees(), patientName,
                    consulFees);
            dcd.addValue(comprehensivePatientEntity.getFees().getOrderedTestsFees(), patientName, testFees);
            dcd.addValue(comprehensivePatientEntity.getFees().getMedicineFees(), patientName, medFees);
        });

        JFreeChart chart = ChartFactory.createBarChart(
                "Fees by patient",
                "Categories",
                "Money",
                dcd,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        return new ChartPanel(chart);
    }

    public static JPanel weeklyChartTimeseriesAveragePatientsByDoctor() {
        TimeSeriesCollection tsc = new TimeSeriesCollection();
        List<StaffEntity> docs = DoctorsController.getListOfDoctors();
        docs.forEach(staffEntity -> {
            //todo - finish
        });
        return null;
    }
}
