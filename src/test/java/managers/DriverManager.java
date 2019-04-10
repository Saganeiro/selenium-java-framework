package managers;

import listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static managers.BrowserType.FIREFOX;

public class DriverManager {

    //Dwie zmiennej instancj klasy ThreadLocal przechowujące kolejno instancję obiektu WebDriver oraz BrowserType dla danego wątku
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {

        WebDriver browser = null;

        if (browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        //Rejestracja obiektu WebDrivera
        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            //Rzucenie wyjątku IllegalStateException w sytuacji gdy dla danego wątku instancja przeglądarki nie została
            // poprawnie zainicializowana metodą setWebDriver
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }

        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();

        //Sprawdzenie czy dla danego wątku przeglądarka to Firefox
        if (!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }

        //Usunięcie zmiennych typu BrowserType oraz WebDriver dla danego wątku
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}