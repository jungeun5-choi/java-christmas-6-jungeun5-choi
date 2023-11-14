package christmas.eventPlanner.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.enumerator.EventType;
import christmas.common.view.OutputView;
import christmas.eventPlanner.service.EventPlannerService;

public class EventPlannerController extends Controller {
    private final EventPlannerService eventPlannerService;

    public EventPlannerController(EventPlannerService eventPlannerService) {
        this.eventPlannerService = eventPlannerService;

        stateActions.put(ApplicationState.PROCESS_EVENT_PLANNER, this::process);
        stateActions.put(ApplicationState.PRESENT_EVENT_PLANNER, this::present);
    }

    public void process() {
        eventPlannerService.process();
    }

    public void present() {
        presentRewardList();
    }

    private void presentRewardList() {
        boolean hasReward = eventPlannerService.hasAdvantage(EventType.REWARD);
        OutputView.getInstance().printReward(hasReward);
    }
}
