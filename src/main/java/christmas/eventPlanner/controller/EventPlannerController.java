package christmas.eventPlanner.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.view.OutputView;
import christmas.eventPlanner.service.EventPlannerService;

public class EventPlannerController extends Controller {
    private final EventPlannerService eventPlannerService;
    private final OutputView outputView;

    public EventPlannerController(EventPlannerService eventPlannerService, OutputView outputView) {
        this.eventPlannerService = eventPlannerService;
        this.outputView = outputView;

        stateActions.put(ApplicationState.PROCESS_EVENT_PLANNER, this::process);
        stateActions.put(ApplicationState.PRESENT_EVENT_PLANNER, this::present);
    }

    public void process() {

    }

    public void present() {

    }
}
