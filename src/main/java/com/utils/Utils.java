
package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class has generic utility - RegEx for name, email, password, DOB and phone
 * number - Utilitarian functions
 *
 * @author Aiman, Antonella, Micheal, Monte, Shilpa
 */
public class Utils {

    //Regular expression
    public static String nameRegEx = "\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b";
    public static String emailRegEx = "[a-zA-Z0-9_%+-\\.]+@[a-zA-Z0-9-]+(.com)";
    public static String staffEmailRegEx = "[a-zA-Z0-9_%+-\\.]+@+(tgsstaff.com)";
    public static String passRegEx = "[A-Z][A-Za-z]{5,}\\d{2,}";
    public static String dobRegEx = "\\d{4}-\\d{2}-\\d{2}";
    public static String phoneRegEx = "^\\+(?:[0-9] ?){6,14}[0-9]$";

    /**
     * Checks whether a person is older than 18 on the present day  
     *
     * @param String dob
     *
     * @return true or false
     */
    public static boolean isOlderThen18(String dob) {
        try {
            LocalDate startDate = LocalDate.parse(dob);
            LocalDate endDate = LocalDate.now();
            Period diff = Period.between(startDate, endDate);
            System.out.println("Age" + diff.getYears());
            return (diff.getYears() >= 18);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Checks the difference in number of days between two dates 
     * and returns the absolute value of the that.
     *
     * @param String start date and String end date
     *
     * @return Number of days
     */
    public static int differenceInDays(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date firstDate = sdf.parse(startDate);
            Date secondDate = sdf.parse(endDate);

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            System.out.println("Diff : " + diff);
            return (int) diff;
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    /**
     * Checks whether the parameter date is occurring later than three months 
     * from present date This is to put a limit of the max booking date
     *
     * @param date
     * @return true or false
     */
    public static boolean morethanThreeMonths(String date) {
        try {
            LocalDate dDate = LocalDate.parse(date);
            LocalDate today = LocalDate.now();
            Period diff = Period.between(today, dDate);
            System.out.println("months" + diff.getMonths());
            return (diff.getMonths() >= 3);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Checks whether the start date occurs before end date
     *
     * @param String start date and String end date
     *
     * @return true or false
     */
    public static boolean startDtbefendDt(String startDate, String endDate) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return start.isBefore(end);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Checks whether the format of the Date is Valid
     *
     * @param String date
     *
     * @return true or false
     */
    public static LocalDate validateDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
