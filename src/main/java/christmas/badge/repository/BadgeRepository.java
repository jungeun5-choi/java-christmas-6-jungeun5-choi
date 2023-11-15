package christmas.badge.repository;

import christmas.badge.model.BadgeData;
import christmas.common.enumerator.BadgeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeRepository {
    private static List<BadgeData> badgeData = new ArrayList<>();

    public void save(BadgeData badgeData) {
        this.badgeData.add(badgeData);
    }

    public static BadgeData findBadgeDataByBadgeType(BadgeType type) {
        for (BadgeData badge : badgeData) {
            if (Objects.equals(type, badge.type())) {
                return badge;
            }
        }
        return null;
    }

    public static int findRequiredAdvantageAmountByBadgeType(BadgeType type) {
        return Objects.requireNonNull(findBadgeDataByBadgeType(type)).requiredAdvantageAmount();
    }

    public List<BadgeData> findAllBadgeData() {
        return badgeData;
    }
}
