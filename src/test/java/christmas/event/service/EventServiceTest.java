package christmas.event.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.event.model.EventData;
import christmas.event.repository.EventRepository;
import org.junit.jupiter.api.Test;

class EventServiceTest extends NsTest {
    @Test
    void 이벤트_데이터_생성_테스트() {
        // given
        EventRepository eventRepository = new EventRepository();
        EventService eventService = new EventService(eventRepository);
        eventService.createEvent();

        // when
        for (EventData event : eventRepository.findAllEventData()) {
            System.out.printf("이름: %s", event.name());
            System.out.printf(" / 이벤트 마지막 날: %s", event.endDay());
            System.out.printf(" / 기본 할인 금액: %s", event.defaultDiscount());
            System.out.printf(" / 증정품 여부: %s\n", event.hasReward());
        }

        // then
        assertThat(output()).isEqualTo(printExpected());
    }

    private String printExpected() {
        return """
                이름: 크리스마스 디데이 할인 / 이벤트 마지막 날: 25 / 기본 할인 금액: 1000 / 증정품 여부: false
                이름: 평일 할인 / 이벤트 마지막 날: 31 / 기본 할인 금액: 2023 / 증정품 여부: false
                이름: 주말 할인 / 이벤트 마지막 날: 31 / 기본 할인 금액: 2023 / 증정품 여부: false
                이름: 특별 할인 / 이벤트 마지막 날: 31 / 기본 할인 금액: 1000 / 증정품 여부: false
                이름: 증정 이벤트 / 이벤트 마지막 날: 31 / 기본 할인 금액: 25000 / 증정품 여부: true""";
    }

    @Override
    protected void runMain() {

    }
}