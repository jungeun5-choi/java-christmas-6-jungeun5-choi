package christmas.badge.controller;

import christmas.badge.service.BadgeService;
import christmas.common.controller.Controller;
import christmas.common.controller.Initializable;
import christmas.common.enumerator.ApplicationState;

public class BadgeController extends Controller implements Initializable {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
        stateActions.put(ApplicationState.CREATE_DATA, this::initialize);
    }

    @Override
    public void initialize() {
        badgeService.createBadge();
    }
}
