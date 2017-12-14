package com.bignerdranch.android.criminalintent;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rober on 12/10/2017.
 */

public class DateParser {

    private static Calendar sCalendar = Calendar.getInstance();

    public static String parseDate(Date date) {
        sCalendar.setTime(date);
        return new StringBuilder().append(parseDayOfWeek(sCalendar.get(Calendar.DAY_OF_WEEK)) + ", ")
                .append(parseMonth(sCalendar.get(Calendar.MONTH)))
                .append(" ")
                .append(parseDayOfMonth(sCalendar.get(Calendar.DAY_OF_MONTH)))
                .append(", ")
                .append(sCalendar.get(Calendar.YEAR)).toString();
    }

    private static String parseDayOfWeek(int dayOfWeek) {
        String result = "";
        switch(dayOfWeek) {
            case Calendar.SUNDAY :
                result = "Sunday";
                break;
            case Calendar.MONDAY :
                result = "Monday";
                break;
            case Calendar.TUESDAY :
                result = "Tuesday";
                break;
            case Calendar.WEDNESDAY:
                result = "Wednesday";
                break;
            case Calendar.THURSDAY :
                result = "Thursday";
                break;
            case Calendar.FRIDAY :
                result = "Friday";
                break;
            case Calendar.SATURDAY:
                result = "Saturday";
                break;
        }
        return result;
    }

    private static String parseMonth(int month) {
        String result = "";
        switch(month) {
            case Calendar.JANUARY :
                result = "January";
                break;
            case Calendar.FEBRUARY :
                result = "February";
                break;
            case Calendar.MARCH :
                result = "March";
                break;
            case Calendar.APRIL :
                result = "April";
                break;
            case Calendar.MAY :
                result = "May";
                break;
            case Calendar.JUNE :
                result = "June";
                break;
            case Calendar.JULY:
                result = "July";
                break;
            case Calendar.AUGUST :
                result = "August";
                break;
            case Calendar.SEPTEMBER :
                result = "September";
                break;
            case Calendar.OCTOBER :
                result = "October";
                break;
            case Calendar.NOVEMBER:
                result = "November";
                break;
            case Calendar.DECEMBER :
                result = "December";
                break;
        }
        return result;
    }

    private static String parseDayOfMonth(int dayOfMonth) {
        String result = "" + dayOfMonth;
        switch(dayOfMonth) {
            case 1 :
            case 21 :
            case 31:
                result += "st";
                break;
            case 2 :
            case 22 :
                result += "nd";
                break;
            case 3 :
            case 23:
                result += "rd";
                break;
            default:
                result += "th";
        }
        return result;
    }
}
