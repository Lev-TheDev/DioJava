package edu.lev.datecalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {

    public static void main(String[] args) {
        var date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // HH maiúsculo nas horas padrão 24h hh minúsculo padrão 12h
        System.out.println(formatter.format(date));
        System.out.println(date);
        date.setYear(99);
        var milliseconds = System.currentTimeMillis();
        var newDate = new Date(milliseconds);
        System.out.println(date.before(new Date(milliseconds)));
    }
}
