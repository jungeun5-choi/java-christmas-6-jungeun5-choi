package christmas.date.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.date.model.DayData;
import christmas.date.repository.DateRepository;
import org.junit.jupiter.api.Test;

class DateServiceTest extends NsTest {
    private static final int DECEMBER_FIRST = 1;
    private static final int DECEMBER_LAST = 31;

    @Override
    protected void runMain() {

    }

    @Test
    void 날짜_데이터_생성_테스트() {
        // given
        DateService dateService = new DateService(new DateRepository());
        dateService.createDate();

        // when
        for (int i = DECEMBER_FIRST; i <= DECEMBER_LAST; i++) {
            DayData day = DateRepository.findDayData(i);
            System.out.printf("isWeekend: %s", day.isWeekend());
            System.out.printf(" / isSpecial: %s\n", day.isSpecial());
        }

        // then
        assertThat(output()).isEqualTo(printExpected());
    }

    private String printExpected() {
        return """
                isWeekend: true / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: false / isSpecial: true
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: false / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: true / isSpecial: false
                isWeekend: false / isSpecial: false""";
    }
}