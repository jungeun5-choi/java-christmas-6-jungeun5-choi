package christmas.badge.controller;

import christmas.badge.service.BadgeService;
import christmas.common.controller.Controller;
import christmas.common.controller.Initializable;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.OutputView;

public class BadgeController extends Controller implements Initializable {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
        stateActions.put(ApplicationState.CREATE_DATA, this::initialize);
        stateActions.put(ApplicationState.PRESENT_BADGE, this::present);
    }

    @Override
    public void initialize() {
        badgeService.createBadge();
    }

    public void present() {
        issueBadge();
    }

    private void issueBadge() {
        String name = badgeService.issueBadge();
        OutputView.getInstance().printBadge(name);
    }
}
