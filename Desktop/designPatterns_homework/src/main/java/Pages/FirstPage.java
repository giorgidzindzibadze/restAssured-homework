package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;

public class FirstPage {
    public ElementsCollection buttons =$$("div.card.mt-4.top-card");
    public SelenideElement formsButton =buttons.get(1);

}
