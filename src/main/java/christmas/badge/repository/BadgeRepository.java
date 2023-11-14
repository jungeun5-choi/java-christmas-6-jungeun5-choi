package christmas.badge.repository;

import christmas.badge.model.BadgeData;
import christmas.common.enumerator.BadgeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeRepository {
    private List<BadgeData> badgeData = new ArrayList<>();

    public void save(BadgeData badgeData) {
        this.badgeData.add(badgeData);
    }
}
