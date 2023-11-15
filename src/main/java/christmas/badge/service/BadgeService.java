package christmas.badge.service;

import christmas.badge.model.BadgeData;
import christmas.badge.repository.BadgeRepository;
import christmas.common.enumerator.BadgeType;
import christmas.event.repository.AdvantageRepository;

public class BadgeService {
    private static final String NULL = "없음";

    private final BadgeRepository badgeRepository;
    private final AdvantageRepository advantageRepository;

    public BadgeService(BadgeRepository badgeRepository, AdvantageRepository advantageRepository) {
        this.badgeRepository = badgeRepository;
        this.advantageRepository = advantageRepository;
    }

    public void createBadge() {
        badgeRepository.save(new BadgeData(BadgeType.STAR, 5000));
        badgeRepository.save(new BadgeData(BadgeType.TREE, 10000));
        badgeRepository.save(new BadgeData(BadgeType.SANTA, 20000));
    }

    public String issueBadge() {
        int totalDiscount = advantageRepository.calculateTotalDiscountAmount();
        return findBadge(totalDiscount);
    }

    private String findBadge(int totalDiscount) {
        for (BadgeType type : BadgeType.values()) {
            if (type.isSatisfied(totalDiscount)) {
                return type.getName();
            }
        }
        return NULL;
    }
}
