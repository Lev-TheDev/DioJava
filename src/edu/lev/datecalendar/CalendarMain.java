package edu.lev.datecalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarMain {

    public static void main(String[] args) throws ParseException {
        var calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        System.out.println("Current date and time: " + calendar.getTime());
        System.out.println("Formatted date and time: " + formatter.format(calendar.getTime()));
        /*Date date = calendar.getTime();
        System.out.println("Date object: " + date);
        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1)); // Months are 0-based
        System.out.println("Day of Month: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hour of Day: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("Second: " + calendar.get(Calendar.SECOND));
        System.out.println("Millisecond: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("Day of Week: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Day of Year: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Week of Year: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Week of Month: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("AM or PM: " + (calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));
        System.out.println("Time Zone: " + calendar.getTimeZone().getID());
        System.out.println("Is Daylight Saving Time: " + calendar.getTimeZone().inDaylightTime(date));
        */var stringDate = formatter.format(calendar.getTime());
        stringDate = stringDate.replace("11:", "21:");
        var newDate = formatter.parse(stringDate);
        var newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);
        System.out.println("Formatted date: " + formatter.format(calendar.getTime()));
        System.out.println("Changed date: " + formatter.format(newCalendar.getTime()));
    }
}
