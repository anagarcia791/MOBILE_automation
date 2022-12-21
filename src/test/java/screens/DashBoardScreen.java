package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Reserve\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"Reserve\")")
    private AndroidElement addPlansButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator =
            "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"More\")")
    @AndroidFindBy(uiAutomator =
            "new UiSelector().descriptionContains(\"More\")")
    private AndroidElement moreOptionsButton;

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Dismiss PopUps to have clean dashboard.
     *
     * @author am.garcia
     */
    private void dismissPopUps() {
        if (isElementAvailable(dismissWelcome, 12)) {
            click(dismissWelcome);
        }
        if (isElementAvailable(dismissPreferenceUpdateButton, 12)) {
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * Navigate to Map Screen from DashBoard Screen.
     *
     * @author Hans.Marquez
     */
    public MapScreen goToMapScreen() {
        dismissPopUps();
        click(mapButton);
        return new MapScreen(driver);
    }

    /**
     * Navigate to Add Plans Screen from DashBoard Screen.
     *
     * @author am.garcia
     */
    public AddPlansScreen goToAddPlansScreen() {
        dismissPopUps();
        click(addPlansButton);
        return new AddPlansScreen(driver);
    }

    /**
     * Navigate to More Options Screen from DashBoard Screen.
     *
     * @author am.garcia
     */
    public MoreOptionsScreen goToMoreOptionsScreen() {
        dismissPopUps();
        click(moreOptionsButton);
        return new MoreOptionsScreen(driver);
    }

}
