package christmas.badge.domain;

import christmas.util.enumerator.BadgeType;

public record BadgeData(
        BadgeType type,
        int requiredAdvantageAmount) {
}
