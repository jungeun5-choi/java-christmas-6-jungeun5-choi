package christmas.badge.controller;

import christmas.badge.model.Badge;
import christmas.badge.model.BadgeData;
import christmas.util.Controllable;
import christmas.util.enumerator.BadgeType;
import java.util.ArrayList;
import java.util.List;

public class InitializeBadgeController implements Controllable {
    @Override
    public void process() {
        Badge badge = new Badge(initialize());
    }

    private List<BadgeData> initialize() {
        List<BadgeData> badgeData = new ArrayList<>();
        badgeData.add(new BadgeData(BadgeType.STAR, 5000));
        badgeData.add(new BadgeData(BadgeType.TREE, 10000));
        badgeData.add(new BadgeData(BadgeType.SANTA, 20000));
        return badgeData;
    }
}
