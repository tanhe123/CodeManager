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

    static
    {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String getDate() {
        Calendar dt = Calendar.getInstance();

        return sdf.format(dt.getTime());
    }

    public static String getDate(Calendar c) {
        return sdf.format(c.getTime());
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(getDate());
    }
}
