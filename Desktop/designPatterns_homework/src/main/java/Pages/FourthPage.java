package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FourthPage {
    public SelenideElement textField = $("#example-modal-sizes-title-lg"),
            table = $("table.table.table-dark.table-striped.table-bordered.table-hover");
    ElementsCollection tdElements = table.$$("td");


}
