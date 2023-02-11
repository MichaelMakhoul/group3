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
     * Method returns
     *
     * @param String dob
     *
     * @return
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
     * Method returns
     *
     * @param String start date and String end date
     *
     * @return
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
     * Method returns
     *
     * @param String start date and String end date
     *
     * @return
     */
    public static boolean startDtbefendDt(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return start.isBefore(end);
    }

    /**
     * Method returns
     *
     * @param String date
     *
     * @return
     */
    public static LocalDate validateDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}
