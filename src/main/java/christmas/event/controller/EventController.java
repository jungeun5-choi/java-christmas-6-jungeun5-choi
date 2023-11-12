package christmas.event.controller;

import christmas.common.Controller;
import christmas.common.enumerator.ApplicationState;
import christmas.event.service.EventService;

public class EventController extends Controller {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
        stateActions.put(ApplicationState.CREATE, this::create);
    }

    @Override
    public void create() {
        eventService.createEvent();
    }
}
