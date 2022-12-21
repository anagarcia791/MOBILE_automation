package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

import java.util.List;

/**
 * Privacy & Legal Component.
 *
 * @author am.garcia
 */
public class PrivacyAndLegalComponent extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Privacy & Legal\")")
    private AndroidElement privacyLegalTitle;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*privacy_and_legal_elements\").resourceIdMatches(\".*txt_element\")")
    private List<AndroidElement> privacyLegalList;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public PrivacyAndLegalComponent(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @return true if Privacy & Legal Title is displayed in screen, otherwise false.
     * @author am.garcia
     */
    public boolean privacyLegalTitleTitleIsDisplayed() {
        return isElementAvailable(privacyLegalTitle, 5);
    }

    /**
     * @return true if Privacy & Legal Elements are displayed in screen, otherwise false.
     * @author am.garcia
     */
    public boolean privacyLegalElementsAreDisplayed() {
        return areListElementsDisplayed(privacyLegalList, 10);
    }

}
