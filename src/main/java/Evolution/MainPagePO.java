package Evolution;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPagePO {

    private SelenideElement switchToRu = $(".a_menu[href=\"/ru/\"]");
    private SelenideElement electrotechnica = $("#td_6 .a1");
    private ElementsCollection mainMenu = $$(".menu_main");

    public void openPage() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.startMaximized = true;
        open("https://www.ss.com/");

        switchToRu.shouldBe(Condition.visible);
    }

    public void switchToRussianLanguage() {
        switchToRu.click();
    }

    public void clickToElectrotechnica() {
        electrotechnica.click();
    }

    public SelenideElement getVariantOnMainMenu(int num) {
        //1 - Подать обьявление
        //2 - Мои обьявления
        //3 - Поиск
        //4 - Закладки
        return mainMenu.get(num - 1);
    }


}
