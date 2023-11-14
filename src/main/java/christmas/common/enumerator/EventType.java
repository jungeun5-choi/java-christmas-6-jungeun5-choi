package christmas.common.enumerator;

import christmas.date.repository.DateRepository;
import christmas.event.repository.EventRepository;
import christmas.order.repository.OrderRepository;

public enum EventType {
    CHRISTMAS_D_DAY {
        @Override
        public boolean isSatisfied() {
            int visitDay = OrderRepository.findVisitDay();
            int endDay = EventRepository.findEndDayByEventType(EventType.CHRISTMAS_D_DAY);
            return visitDay <= endDay;
        }
    },
    WEEKDAY {
        @Override
        public boolean isSatisfied() {
            int visitDay = OrderRepository.findVisitDay();
            return DateRepository.findIsWeekDay(visitDay);
        }
    },
    WEEKEND {
        @Override
        public boolean isSatisfied() {
            int visitDay = OrderRepository.findVisitDay();
            return DateRepository.findIsWeekend(visitDay);
        }
    },
    SPECIAL {
        @Override
        public boolean isSatisfied() {
            int visitDay = OrderRepository.findVisitDay();
            return DateRepository.findIsSpecialDay(visitDay);
        }
    },
    REWARD {
        @Override
        public boolean isSatisfied() {
            return OrderRepository.findTotalAmount() >= MIN_REQUIRED_AMOUNT_FOR_REWARD;
        }
    };

    private static final int MIN_REQUIRED_AMOUNT_FOR_REWARD = 12000;

    public abstract boolean isSatisfied();
}
