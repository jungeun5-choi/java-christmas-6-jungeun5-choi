package christmas.badge.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.badge.model.BadgeData;
import christmas.badge.repository.BadgeRepository;
import christmas.event.repository.AdvantageRepository;
import org.junit.jupiter.api.Test;

class BadgeServiceTest extends NsTest {
    @Test
    void 뱃지_데이터_생성_테스트() {
        // given
        BadgeRepository badgeRepository = new BadgeRepository();
        BadgeService badgeService = new BadgeService(badgeRepository, new AdvantageRepository());
        badgeService.createBadge();

        // when
        for (BadgeData badge : badgeRepository.findAllBadgeData()) {
            System.out.print(badge.type());
            System.out.printf(" / 뱃지 이름: %s", badge.type().getName());
            System.out.printf(" / 뱃지 발급 필요 금액: %s\n", badge.requiredAdvantageAmount());
        }

        // then
        assertThat(output()).isEqualTo(printExpected());
    }

    private String printExpected() {
        return """
                STAR / 뱃지 이름: 별 / 뱃지 발급 필요 금액: 5000
                TREE / 뱃지 이름: 트리 / 뱃지 발급 필요 금액: 10000
                SANTA / 뱃지 이름: 산타 / 뱃지 발급 필요 금액: 20000""";
    }

    @Test
    void issueBadge() {
    }

    @Override
    protected void runMain() {

    }
}