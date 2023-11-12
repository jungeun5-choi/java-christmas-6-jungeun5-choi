package christmas.date.controller;

import christmas.date.service.DateService;

public class DateController {
    private final DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    public void createDate() {
        dateService.createDate();
    }
}
