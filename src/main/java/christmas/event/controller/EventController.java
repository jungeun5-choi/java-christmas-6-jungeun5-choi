package christmas.event.controller;

import christmas.common.controller.Controller;
import christmas.common.controller.Initializable;
import christmas.common.enumerator.ApplicationState;
import christmas.event.service.EventService;

public class EventController extends Controller implements Initializable {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
        stateActions.put(ApplicationState.CREATE_DATA, this::initialize);
    }

    @Override
    public void initialize() {
        eventService.createEvent();
    }
}
