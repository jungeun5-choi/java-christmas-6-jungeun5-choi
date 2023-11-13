package christmas.date.controller;

import christmas.common.controller.Controller;
import christmas.common.controller.Initializable;
import christmas.common.enumerator.ApplicationState;
import christmas.date.service.DateService;

public class DateController extends Controller implements Initializable {
    private final DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
        setState(ApplicationState.CREATE_DATA);
        stateActions.put(ApplicationState.CREATE_DATA, this::initialize);
    }

    @Override
    public void initialize() {
        dateService.createDate();
    }
}