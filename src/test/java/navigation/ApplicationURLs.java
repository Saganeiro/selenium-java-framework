package navigation;

import configuration.AppProperties;

public class ApplicationURLs {

    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String INVENTORY = APPLICATION_URL + "/inventory.html";
    public static final String CARD = APPLICATION_URL + "/cart.html";

}
