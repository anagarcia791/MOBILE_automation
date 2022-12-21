package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * More Options screen.
 *
 * @author am.garcia
 */
public class MoreOptionsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Privacy\")")
    private AndroidElement privacyLegalButton;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MoreOptionsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * return true if Privacy Legal Button is displayed in screen, otherwise false.
     *
     * @author am.garcia
     */
    public boolean privacyLegalButtonIsDisplayed() {
        return isElementAvailable(privacyLegalButton);
    }

    /**
     * Scrolls to end more options screen.
     *
     * @author am.garcia
     */
    public void scrollToEndMoreOptionsScreen() {
        do {
            swipeVertical(-0.5f);
        } while (!privacyLegalButtonIsDisplayed());
    }

    /**
     * Shows Privacy & Legal Component.
     *
     * @author am.garcia
     */
    public PrivacyAndLegalComponent clickPrivacyLegalButton() {
        click(privacyLegalButton);
        return new PrivacyAndLegalComponent(driver);
    }

}
