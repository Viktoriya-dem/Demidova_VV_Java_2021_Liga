package ru.philosophyit.internship.javabase.time;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main {
    public static void main(String... args) {
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(Calendar.getInstance().toInstant()));
        getCurrentMonthCalendar();
    }

    public static void getCurrentMonthCalendar() {
        Calendar firstDayOfMonth = Calendar.getInstance();
        Calendar lastDayOfMonth = Calendar.getInstance();

        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));

        int countOfDays = lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        while (firstDayOfMonth.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            firstDayOfMonth.add(Calendar.DAY_OF_MONTH, -1);
            countOfDays++;
        }

        while (lastDayOfMonth.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            lastDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
            countOfDays++;
        }
        System.out.println("| ПН | ВТ | СР | ЧТ | ПТ | СБ | ВС");
        for (int i = 0; i < countOfDays; i++) {
            if (firstDayOfMonth.get(Calendar.DAY_OF_MONTH) < 10)
                System.out.print("| " + firstDayOfMonth.get(Calendar.DAY_OF_MONTH) + "  ");
            else System.out.print("| " + firstDayOfMonth.get(Calendar.DAY_OF_MONTH) + " ");
            if (firstDayOfMonth.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) System.out.println();
            firstDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}

// Отобразите календарь текущего месяца в консоли
// например:
// пн вт ср чт пт сб вс
// 30 31 1  2  3  4  5
// и т.д.