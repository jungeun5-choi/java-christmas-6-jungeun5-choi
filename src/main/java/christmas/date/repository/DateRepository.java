package christmas.date.repository;

import christmas.date.model.DayData;
import java.util.ArrayList;
import java.util.List;

public class DateRepository {
    private static List<DayData> dayData = new ArrayList<>();

    public void save(DayData dayData) {
        this.dayData.add(dayData);
    }

    public static DayData findDayData(int day) {
        int index = day - 1; // 입력은 +1한 값이 들어올 것이기 때문에 -1 해준다.
        return dayData.get(index);
    }

    public static boolean findIsWeekend(int day) {
        return findDayData(day).isWeekend();
    }

    public static boolean findIsWeekDay(int day) {
        return !findDayData(day).isWeekend();
    }

    public static boolean findIsSpecialDay(int day) {
        return findDayData(day).isSpecial();
    }
}
