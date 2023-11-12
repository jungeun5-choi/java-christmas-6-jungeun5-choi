package christmas.badge.service;

import christmas.badge.model.Badge;
import christmas.badge.model.BadgeData;
import christmas.common.enumerator.BadgeType;
import java.util.ArrayList;
import java.util.List;

public class BadgeService {
    public Badge createBadge() {
        List<BadgeData> badgeData = new ArrayList<>();
        badgeData.add(new BadgeData(BadgeType.STAR, 5000));
        badgeData.add(new BadgeData(BadgeType.TREE, 10000));
        badgeData.add(new BadgeData(BadgeType.SANTA, 20000));
        return new Badge(badgeData);
    }
}