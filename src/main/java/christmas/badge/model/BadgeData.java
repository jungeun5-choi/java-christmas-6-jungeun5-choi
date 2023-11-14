package christmas.badge.model;

import christmas.common.enumerator.BadgeType;

public record BadgeData(
        BadgeType badgeType,
        int requiredAdvantageAmount) {
}
