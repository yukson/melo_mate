package org.techtown.melomate;

import java.util.Calendar;

public class GetTime {
    public static int getHour(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
