package christmas.badge.controller;

import christmas.badge.service.BadgeService;

public class BadgeController {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    public void createBadge() {
        badgeService.createBadge();
    }
}
