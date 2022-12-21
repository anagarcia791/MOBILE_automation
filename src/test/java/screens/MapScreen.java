package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoriesButton;

    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * return true if Filter Button element is displayed in screen, otherwise false.
     *
     * @author Hans.Marquez
     */
    public boolean filterIsDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * return true if Categories Button element is displayed in screen, otherwise false.
     *
     * @author Hans.Marquez
     */
    public boolean categoriesIsDisplayed() {
        return isElementAvailable(categoriesButton);
    }

    /**
     * return true if Show List Button element is displayed in screen, otherwise false.
     *
     * @author Hans.Marquez
     */
    public boolean showListIsDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * Shows Categories List Component.
     *
     * @author am.garcia
     */
    public CategoryListComponent clickCategoryListComponent() {
        click(categoriesButton);
        return new CategoryListComponent(driver);
    }

}
