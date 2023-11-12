package christmas.event.controller;

import christmas.event.service.EventService;

public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    public void createEvent() {
        eventService.createEvent();
    }
}
