package christmas.menu.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.menu.model.MenuData;
import christmas.menu.repository.MenuRepository;
import org.junit.jupiter.api.Test;

class MenuServiceTest extends NsTest {

    @Test
    void 메뉴_데이터_생성_테스트() {
        // given
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);
        menuService.createMenu();

        // when
        for (MenuData menu : menuRepository.findAllMenuData()) {
            System.out.print(menu.type());
            System.out.printf(" / 이름: %s", menu.name());
            System.out.printf(" / 가격: %s\n", menu.price());
        }

        // then
        assertThat(output()).isEqualTo(printExpected());
    }

    private String printExpected() {
        return """
                Appetizer / 이름: 양송이수프 / 가격: 6000
                Appetizer / 이름: 타파스 / 가격: 5500
                Appetizer / 이름: 시저샐러드 / 가격: 8000
                Main / 이름: 티본스테이크 / 가격: 55000
                Main / 이름: 바비큐립 / 가격: 54000
                Main / 이름: 해산물파스타 / 가격: 35000
                Main / 이름: 크리스마스파스타 / 가격: 25000
                Dessert / 이름: 초코케이크 / 가격: 15000
                Dessert / 이름: 아이스크림 / 가격: 5000
                Drink / 이름: 제로콜라 / 가격: 3000
                Drink / 이름: 레드와인 / 가격: 60000
                Drink / 이름: 샴페인 / 가격: 25000""";
    }

    @Override
    protected void runMain() {

    }
}