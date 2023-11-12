package christmas.date.controller;

import christmas.common.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.date.service.DateService;

public class DateController extends Controller {
    private final DateService dateService;

    private ApplicationState currentState;

    public DateController(DateService dateService) {
        this.dateService = dateService;
        stateActions.put(ApplicationState.CREATE, this::create);
    }

    @Override
    public void create() {
        dateService.createDate();
    }
}