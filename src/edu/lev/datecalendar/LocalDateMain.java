package edu.lev.datecalendar;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        var strDate = "22/12/2015";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(localDate));
        System.out.println(LocalDate.parse(strDate, formatter));
        System.out.println(localDate.plus(50, ChronoUnit.DAYS));
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.isBefore(LocalDate.parse(strDate, formatter)));
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmt2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(ldt);
        System.out.println(fmt.format(ldt));
        System.out.println(fmt2.format(ldt));
        System.out.println("--------------");
        Date date = Date.from(ldt.toInstant(ZoneOffset.ofHours(-4)));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(date);
        System.out.println(calendar.getTime());
        System.out.println("--------------");
        Date date1 = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar.setTime(date1);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        LocalDateTime ldt1 = LocalDateTime.ofInstant(date1.toInstant(), zoneId);
        System.out.println(ldt1);
        System.out.println("--------------");
        OffsetDateTime odt = OffsetDateTime.now();
        OffsetDateTime odtUTC = odt.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println(odt);
        System.out.println(odtUTC);
        System.out.println(odt.isEqual(odtUTC));
        System.out.println("--------------");
        //conversão
        Date date4 = Date.from(odt.toInstant());
        Calendar calendar4 = Calendar.getInstance();
        calendar.setTime(date4);

        Calendar cal = Calendar.getInstance();
        Date dt = cal.getTime();
        OffsetDateTime odt2 = dt.toInstant().atOffset(ZoneOffset.ofHours(-4));
        System.out.println(odt2);




    }
}
