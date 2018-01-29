package Evolution;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private SelenideElement searchPut = $("#ptxt");
    private SelenideElement minPrice = $("input[name=\"topt[8][min]\"]");
    private SelenideElement maxPrice = $("input[name=\"topt[8][max]\"]");
    private ElementsCollection searchResultDropDown = $$("#preload_txt>div");
    private SelenideElement searchingButton = $("#sbtn");
    private SelenideElement sortingByPrice = $(".msg_column_td");
    private ElementsCollection filterSelecting = $$(".filter_opt_dv .filter_sel");
    private SelenideElement advSearch = $("a[href=\"/ru/electronics/search/\"]");
    private ElementsCollection checkboxes = $$("input[type=\"checkbox\"]");

    public SelenideElement getSearchPut() {
        return searchPut;
    }

    public ElementsCollection getSearchResultDropDown() {
        return searchResultDropDown;
    }

    public void clickSearchButton() {
        searchingButton.click();
    }

    public void clickSortingByPrice() {
        sortingByPrice.click();
    }

    public SelenideElement getSelectOfFilter(int num) {
        //1 - Режим
        //2 - Район
        //3 - Тип сделки
        return filterSelecting.get(num - 1);
    }

    public void setMinPrice(int minPrice) {
        this.minPrice.click();
        this.minPrice.val(String.valueOf(minPrice));
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice.click();
        this.maxPrice.val(String.valueOf(maxPrice));
    }

    public void clickAdvSearch() {
        advSearch.click();
        searchPut.shouldBe(Condition.visible);
    }

    public void clickCheckbox(int num) {
        checkboxes.get(num - 1).click();
    }

    public ElementsCollection getCheckboxes() {
        return checkboxes;
    }
}
