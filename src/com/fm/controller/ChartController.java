package com.fm.controller;

import com.fm.model.StaffEntity;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChartController {
    public static TimeSeriesCollection getTimeseriesPatientsSeenByVariousDoctors(){
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
                series.add(new Day(date), integer);
            });
            tsc.addSeries(series);
            dates.clear();
        });
        return tsc;
    }

    public static JFreeChart getChartDoctorsWithDates(){
        TimeSeriesCollection tps = getTimeseriesPatientsSeenByVariousDoctors();
        return ChartFactory.createTimeSeriesChart("Number of patients seen by doctors",
                "Dates",
                "Values",
                tps,
                true,
                false,
                false);
    }
}
