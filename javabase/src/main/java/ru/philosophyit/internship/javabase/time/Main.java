package ru.philosophyit.internship.javabase.time;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String... args) {
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(Calendar.getInstance().toInstant()));
        getCurrentMonthCalendar();
    }

    public static void getCurrentMonthCalendar() {
        Calendar calendar = new GregorianCalendar();
        System.out.println("             " + new SimpleDateFormat("MMMM").format(calendar.getTime()).toUpperCase());
        System.out.println("| ПН | ВТ | СР | ЧТ | ПТ | СБ | ВС");
        int previousMonth;
        if (calendar.get(Calendar.MONTH) == 0) previousMonth = 11;
        else previousMonth = calendar.get(Calendar.MONTH) - 1;
        Calendar calendarFirstDay = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        Calendar calendarPreviousMonth = new GregorianCalendar(calendar.get(Calendar.YEAR), previousMonth, calendar.get(Calendar.DAY_OF_MONTH));
        Calendar calendarLastDay = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        int firstdayOfMonth = calendarFirstDay.get(Calendar.DAY_OF_WEEK) - 1;
        int lastdayOfMonth = calendarLastDay.get(Calendar.DAY_OF_WEEK) - 1;
        int week = 0;
        if (firstdayOfMonth != 1) {
            week = firstdayOfMonth - 1;
            for (int i = week - 1; i >= 0; i--) {
                System.out.print("| " + (calendarPreviousMonth.getActualMaximum(Calendar.DAY_OF_MONTH) - i) + " ");
            }
            for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                if (week == 7) {
                    week = 0;
                    System.out.println();
                }
                if (i < 10) System.out.print("| " + i + "  ");
                else System.out.print("| " + i + " ");
                week++;
            }
        } else {
            for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                if (week == 7) {
                    week = 0;
                    System.out.println();
                }
                if (i < 10) System.out.print("| " + i + "  ");
                else System.out.print("| " + i + " ");
                week++;
            }
        }
        if (lastdayOfMonth != 7 && lastdayOfMonth != 0) {
            week = 7 - lastdayOfMonth;
            for (int i = 1; i <= week; i++) {
                System.out.print("| " + (i) + "  ");
            }
        }
    }
}

// Отобразите календарь текущего месяца в консоли
// например:
// пн вт ср чт пт сб вс
// 30 31 1  2  3  4  5
// и т.д.