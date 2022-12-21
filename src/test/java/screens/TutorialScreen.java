package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;


/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Arley.Bolivar
 */

public class TutorialScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*com.android.packageinstaller:id/permission_allow_button\")")
    private AndroidElement allowButton;

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Arley.Bolivar
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * return true if Get Started Button element is displayed in screen, otherwise false.
     *
     * @author am.garcia
     */
    public boolean getStartedButtonIsDisplayed() {
        return isElementAvailable(getStartedButton, 10);
    }

    /**
     * Start permissions process.
     *
     * @author Hans.Marquez
     */
    public void startPermissionsProcess() {
        click(getStartedButton);
    }

    /**
     * Share Location permissions process.
     *
     * @author Hans.Marquez
     */
    public DashBoardScreen shareLocationPermissions() {
        click(shareLocationButton);
        click(allowLocationButton);
        click(allowButton);
        return new DashBoardScreen(driver);
    }

    /**
     * Navigate to Dashboard Screen from Tutorial Screen.
     *
     * @author am.garcia
     */
    public DashBoardScreen skipPermissions() {
        return new DashBoardScreen(driver);
    }
}
