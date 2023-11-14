package christmas.badge.service;

import christmas.badge.model.BadgeData;
import christmas.badge.repository.BadgeRepository;
import christmas.common.enumerator.BadgeType;

public class BadgeService {
    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public void createBadge() {
        badgeRepository.save(new BadgeData(BadgeType.STAR, 5000));
        badgeRepository.save(new BadgeData(BadgeType.TREE, 10000));
        badgeRepository.save(new BadgeData(BadgeType.SANTA, 20000));
    }
}
