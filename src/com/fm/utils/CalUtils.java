package com.fm.utils;

import java.sql.Date;
import java.time.LocalDate;

public class CalUtils {
    public static Date getDate(int dd, int mm, int yyyy){
        return Date.valueOf(LocalDate.of(yyyy, mm, dd));
    }
}
