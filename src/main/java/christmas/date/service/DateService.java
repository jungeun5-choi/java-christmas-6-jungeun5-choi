package christmas.date.service;

import christmas.date.model.Date;
import christmas.date.model.Day;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateService {
    public Date createDate() {
        List<Day> days = new ArrayList<>();
        LocalDate date = LocalDate.of(2023, 12, 1);
        LocalDate end = date.plusMonths(1);

        for (; date.isBefore(end); date = date.plusDays(1)) {
            days.add(new Day(isWeekend(date), hasStar(date)));
        }

        return new Date(days);
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY);
    }

    private boolean hasStar(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        return (dayOfMonth == 3 || dayOfMonth == 10 || dayOfMonth == 17 || dayOfMonth == 24 || dayOfMonth == 31);
    }
}