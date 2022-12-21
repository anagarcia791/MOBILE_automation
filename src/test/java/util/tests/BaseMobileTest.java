package util.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.DashBoardScreen;
import screens.TutorialScreen;
import util.ConfigCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Base class for Test classes.
 *
 * @author helberth.bolivar
 */
public abstract class BaseMobileTest {

    protected TutorialScreen tutorialScreen;
    public static AndroidDriver<AndroidElement> driver;

    /**
     * return the driver.
     *
     * @return driver
     * @author Arley.Bolivar
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public void setUpStartApp() {
        tutorialScreen = new TutorialScreen(getDriver());
    }

    /**
     * SetUp before to run suite of test.
     *
     * @author Arley.Bolivar
     */
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        setUpStartApp();
    }

    /**
     * Close the application after completing the test.
     *
     * @author Arley.Bolivar
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        driver.quit();
    }

    /**
     * return SignUpOrLogInScreen after close the alerts.
     *
     * @return SignUpOrLogInScreen
     * @author Arley.Bolivar
     */
    protected DashBoardScreen loadDashBoardScreen() {
        if (tutorialScreen.getStartedButtonIsDisplayed()) {
            tutorialScreen.startPermissionsProcess();
            return tutorialScreen.shareLocationPermissions();
        } else {
            return tutorialScreen.skipPermissions();
        }
    }

}
