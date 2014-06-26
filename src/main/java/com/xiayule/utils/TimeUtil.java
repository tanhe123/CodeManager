package com.xiayule.utils;

import freemarker.template.SimpleDate;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date dt = new Date();
        return sdf.format(dt);
    }

    public static void main(String[] args) {
        System.out.println(getDate());
    }
}
