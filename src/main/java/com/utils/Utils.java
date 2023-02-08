/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 236351
 */
public class Utils {

    public static String nameRegEx = "\\b[A-Z][a-z]*( [A-Z][a-z]*)*\\b";
    public static String emailRegEx = "[a-zA-Z0-9_%+-]+[.][a-zA-Z0-9_%+-]+@[a-zA-Z0-9-]+(.com)";
    public static String passRegEx = "[A-Z][A-Za-z]{5,}\\d{2,}";
    public static String dobRegEx = "\\d{4}-\\d{2}-\\d{2}";
    public static String phoneRegEx = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    
    // Check if the date not in the future 
    public static String dateRegEx = "";

    // Check if the age is over 18
   //  public static String ageRegEx = "";
    
    public static int differenceInDays(String startDate, String endDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date firstDate = sdf.parse(startDate);
            Date secondDate = sdf.parse(endDate);
            
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            
            //System.out.println("Diff : "+ diff);
            return  (int)diff;
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }  
}
