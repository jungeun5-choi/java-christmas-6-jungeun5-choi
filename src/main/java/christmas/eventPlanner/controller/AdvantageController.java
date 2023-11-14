package christmas.eventPlanner.controller;

import christmas.common.controller.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.common.enumerator.EventType;
import christmas.common.view.OutputView;
import christmas.event.model.EventData;
import christmas.eventPlanner.service.AdvantageService;
import java.util.List;
import java.util.Map;

public class AdvantageController extends Controller {
    private final AdvantageService advantageService;

    public AdvantageController(AdvantageService advantageService) {
        this.advantageService = advantageService;

        stateActions.put(ApplicationState.PROCESS_EVENT_PLANNER, this::process);
        stateActions.put(ApplicationState.PRESENT_EVENT_PLANNER, this::present);
    }

    public void process() {
        advantageService.process();
    }

    public void present() {
        printRewardList();      /* <증정 메뉴> */
        printAdvantageList();   /* <혜택 내역> */
        printAdvantageAmount(); /* <총혜택 금액> */
        /* <할인 후 예상 결제 금액> */
        /* <12월 이벤트 배지> */
    }

    private void printRewardList() {
        boolean hasReward = advantageService.hasAdvantage(EventType.REWARD);
        OutputView.getInstance().printReward(hasReward);
    }

    private void printAdvantageList() {
        List<EventData> eventData = advantageService.findAllAdvantages();
        Map<EventType, Integer> discounts = advantageService.findAllDiscounts();
        OutputView.getInstance().printAdvantageList(eventData, discounts);
    }

    private void printAdvantageAmount() {
        int amount = advantageService.calculateTotalDiscountAmount();
        OutputView.getInstance().printAdvantageAmount(amount);
    }
}