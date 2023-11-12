package christmas.badge.controller;

import christmas.badge.service.BadgeService;
import christmas.common.Controller;
import christmas.common.enumerator.ApplicationState;

public class BadgeController extends Controller {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
        stateActions.put(ApplicationState.CREATE, this::create);
    }

    @Override
    public void create() {
        badgeService.createBadge();
    }
}
