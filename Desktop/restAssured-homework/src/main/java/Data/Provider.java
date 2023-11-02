package Data;

import org.testng.annotations.DataProvider;

public class Provider {
    StaticStrings staticStrings = new StaticStrings();
    @DataProvider(name = "data")
    public Object[][] getInformation() {

        Object[][] dates = {{staticStrings.checkin,staticStrings.checkout,staticStrings.firstname,staticStrings.lastname,
                            staticStrings.totalprice,staticStrings.depositpaid,
                staticStrings.additionalneeds,staticStrings.salesprice,staticStrings.passportNo},
                {staticStrings.checkin,staticStrings.checkout,staticStrings.Name,staticStrings.lstName,
                        staticStrings.totalprice,staticStrings.depositPaid2,
                        staticStrings.additionalneeds,staticStrings.salesprice,staticStrings.passportNo}

        };
        return dates;
    }

}
