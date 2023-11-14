package christmas.badge.repository;

import christmas.badge.model.BadgeData;
import java.util.ArrayList;
import java.util.List;

public class BadgeRepository {
    private List<BadgeData> badgeData = new ArrayList<>();

    public void save(BadgeData badgeData) {
        this.badgeData.add(badgeData);
    }
}
