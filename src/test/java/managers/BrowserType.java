package managers;

public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("ie"),
    EDGE("edge");

    private final String browser;

    BrowserType(String browser){

        this.browser = browser;

    }

}
