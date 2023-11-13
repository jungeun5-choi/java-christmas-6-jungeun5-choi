package christmas.date.service;

import christmas.date.model.DayData;
import christmas.date.repository.DateRepository;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DateService {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int DAY_OF_MONTH = 1;
    private static final int NEXT = 1;


    private final DateRepository dateRepository;

    public DateService(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    public void createDate() {
        LocalDate date = LocalDate.of(YEAR, MONTH, DAY_OF_MONTH);
        LocalDate end = date.plusMonths(NEXT);

        for (; date.isBefore(end); date = date.plusDays(1)) {
            dateRepository.save(new DayData(isWeekend(date), hasStar(date)));
        }
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return (Objects.equals(dayOfWeek, DayOfWeek.FRIDAY)
                || Objects.equals(dayOfWeek, DayOfWeek.SATURDAY));
    }

    private boolean hasStar(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        for (int day : DayOfStar.STAR.days) {
            return Objects.equals(dayOfMonth, day);
        }
        return false;
    }

    private enum DayOfStar {
        STAR(Arrays.asList(3, 10, 17, 24, 31));

        private final List<Integer> days;

        DayOfStar(List<Integer> days) {
            this.days = days;
        }
    }
}