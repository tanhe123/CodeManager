package com.xiayule.utils;

import freemarker.template.SimpleDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tan on 14-6-25.
 */
public class TimeUtil {
    private static SimpleDateFormat sdf;
    public static SimpleDateFormat sdf_line;

    static
    {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf_line = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    }

    public static String getDate() {
        Calendar dt = Calendar.getInstance();

        return sdf.format(dt.getTime());
    }

    public static String getDate(Calendar c) {
        return sdf.format(c.getTime());
    }

    public static String getDateWithUnderLine(Calendar c) {
        return sdf_line.format(c.getTime());
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(getDate());
    }
}
