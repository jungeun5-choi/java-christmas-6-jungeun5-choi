package christmas.date.controller;

import christmas.date.domain.Date;
import christmas.date.domain.Day;
import christmas.util.Controllable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitializeDateController implements Controllable {
    @Override
    public void process() {
        Date date = new Date(initialize());
    }

    private List<Day> initialize() {
        List<Day> days = new ArrayList<>();
        LocalDate date = LocalDate.of(2023, 12, 1);
        LocalDate end = date.plusMonths(1);

        for (; date.isBefore(end); date = date.plusDays(1)) {
            days.add(new Day(isWeekend(date), hasStar(date)));
        }

        return days;
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