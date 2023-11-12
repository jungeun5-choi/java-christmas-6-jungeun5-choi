package christmas.badge.model;

import christmas.util.enumerator.BadgeType;

public record BadgeData(
        BadgeType type,
        int requiredAdvantageAmount) {
}
