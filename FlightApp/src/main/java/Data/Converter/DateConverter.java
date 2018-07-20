package Data.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateConverter {

    private DateConverter() {
    }


    /**
     *  2018-06-09T07:00 -> 06.09 at 7:00
     *
     * @param date
     */
    public static String formatDate(String date){

        try {
            DateFormat srcDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

            Date newDate = srcDate.parse(date);
            DateFormat destDate = new SimpleDateFormat("dd.MM' at 'hh:mm");
            date = destDate.format(newDate);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String getDuration(String startTime, String endTime){

       DateFormat dF = new SimpleDateFormat("dd.MM' at 'hh:mm");
       try {
           Date startDate = dF.parse(startTime);
           Date endDate = dF.parse(endTime);
           long duration = endDate.getTime() - startDate.getTime();
           return TimeUnit.MILLISECONDS.toHours(duration) + " hour(s) and "  + (TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.MILLISECONDS.toHours(duration) * 60)  +  " minute(s)";
       }
       catch (ParseException e){
           e.printStackTrace();
       }

        return "";
    }

    public static String getDayOfWeek(String time){
        DateFormat dF = new SimpleDateFormat("dd.MM' at 'hh:mm");
        try {
            Date startDate = dF.parse(time);
            dF.getCalendar().setTime(startDate);
            dF.getCalendar().add(Calendar.YEAR,48);
            System.out.println(dF.getCalendar().getTime().toString());
            String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
                    "Friday", "Saturday" };
            return strDays[dF.getCalendar().get(Calendar.DAY_OF_WEEK)-1];

        }
        catch (ParseException e){
            e.printStackTrace();
        }

        return "";

    }




    public static String convertArrivalDate(String depatureDate, String duration){

        DateFormat format = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm");
        int duratioInt = Integer.parseInt(duration);
        Date date = null;
        try {
            date = format.parse(depatureDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, duratioInt);
        cal.getTime();

        return format.format(cal.getTime());


    }

}


