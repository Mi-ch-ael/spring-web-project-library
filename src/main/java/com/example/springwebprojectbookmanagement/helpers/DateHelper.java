package com.example.springwebprojectbookmanagement.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {
    private static final long MS_IN_A_DAY = 86400000L;

    public final int year;
    public final long timestamp;
    public final SimpleDateFormat formatter;

    public DateHelper() {
        this.year = Calendar.getInstance().get(Calendar.YEAR);
        this.formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        long timestamp = new Date().getTime();
        this.timestamp = timestamp - (timestamp % MS_IN_A_DAY);
    }

    public String format(long timestamp) {
        return this.formatter.format(new Date(timestamp));
    }
}
