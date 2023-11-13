package christmas.date.repository;

import christmas.date.model.DayData;
import java.util.ArrayList;
import java.util.List;

public class DateRepository {
    private List<DayData> dayData = new ArrayList<>();

    public void save(DayData dayData) {
        this.dayData.add(dayData);
    }
}
