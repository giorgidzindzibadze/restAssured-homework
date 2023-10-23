package Data;

import org.testng.annotations.DataProvider;

public class Provider {
    @DataProvider(name = "data")
    public Object[][] getInformation() {

        Object[][] dates = {{"books[0].author","Richard E. Silverman","books[0].isbn"},
                {"books[1].author","Addy Osmani","books[1].isbn"}

        };
        return dates;
    }

}
