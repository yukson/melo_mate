package org.techtown.swipe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.lang.String;

public class GetDate {
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd");
        return dateFormat.format(date);
    }
    public static String addDate(int d){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, d);

        Date newDate = calendar.getTime();
        return formatDate(newDate);
    }
    public static String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
        return dateFormat.format(date);
    }
}
