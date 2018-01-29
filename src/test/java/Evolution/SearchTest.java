package Evolution;

import com.codeborne.selenide.CollectionCondition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {

    MainPagePO mainPagePO = new MainPagePO();
    SearchPage searchPage = new SearchPage();

    @BeforeClass
    public void beforeClass() {
        mainPagePO.openPage();
    }

    @Test
    public void searchTestByRequirements() {
        mainPagePO.switchToRussianLanguage();
        mainPagePO.clickToElectrotechnica();
        mainPagePO.getVariantOnMainMenu(3).click();

        searchPage.getSearchPut().val("Computer");
        searchPage.getSearchResultDropDown().shouldHave(CollectionCondition.sizeGreaterThan(0));
        searchPage.getSearchResultDropDown().get(0).click();

        searchPage.clickSearchButton();
        searchPage.clickSortingByPrice();
        searchPage.getSelectOfFilter(3).selectOption("Продажа");

        searchPage.clickAdvSearch();
        searchPage.setMinPrice(160);
        searchPage.setMaxPrice(300);
        searchPage.clickSearchButton();

        int countOfResults = searchPage.getCheckboxes().size();
        if (countOfResults >= 3) {
            searchPage.clickCheckbox(1);
            searchPage.clickCheckbox(2);
            searchPage.clickCheckbox(3);
        } else {
            for (int i = 0; i < countOfResults; i++) {
                searchPage.clickCheckbox(i + 1);
            }
        }

    }
}
