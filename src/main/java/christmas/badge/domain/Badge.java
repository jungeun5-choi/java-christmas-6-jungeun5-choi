package christmas.badge.domain;

import java.util.List;

public class Badge {
    private final List<BadgeData> badgeData;

    public Badge(List<BadgeData> badgeData) {
        this.badgeData = badgeData;
    }
}
