package Data.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {

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

    public static String convertArrivalDate(String depatureDate, String duration) throws Exception{

        DateFormat format = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm");
        int duratioInt = Integer.parseInt(duration);
        Date date = format.parse(depatureDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, duratioInt);
        cal.getTime();

        return format.format(cal.getTime());


    }

}


