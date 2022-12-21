package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

import java.util.List;

public class AddPlansScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*actionSheetListView\").resourceIdMatches(\".*actionSheetItemText\")")
    private List<AndroidElement> plansList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filter_clear\")")
    private AndroidElement partySizeLabel;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @param planToFind : plan to find
     * @return string after evaluate if the input received coincide with any category.
     * @author am.garcia
     */
    public String planIsPresent(String planToFind) {
        return elementIsPresentInList(plansList, planToFind);
    }

    /**
     * Click the plan by index.
     *
     * @param planIndex : index of plan in plans list
     * @author am.garcia
     */
    public void clickPlan(int planIndex) {
        click(plansList.get(planIndex));
    }

    /**
     * @return true if Party Size Label is displayed in screen, otherwise false.
     * @author am.garcia
     */
    public Boolean diningAvailabilityComponentDisplayed() {
        return isElementAvailable(partySizeLabel, 5);
    }

}
