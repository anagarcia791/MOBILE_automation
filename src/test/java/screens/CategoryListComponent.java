package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import util.screens.BaseScreen;

import java.util.List;

/**
 * Category List Component
 *
 * @author am.garcia
 */
public class CategoryListComponent extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categorySelectHeader\")")
    private AndroidElement selectCategoryTitle;

    @AndroidFindBy(uiAutomator =
            "new UiSelector().resourceIdMatches(\".*listSelectorContainer\").resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> categoriesList;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public CategoryListComponent(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * @return true if Categories Title is displayed in screen, otherwise false.
     * @author am.garcia
     */
    public boolean selectCategoryTitleIsDisplayed() {
        return isElementAvailable(selectCategoryTitle);
    }

    /**
     * @return true if Categories are displayed in screen, otherwise false.
     * @author am.garcia
     */
    public boolean categoriesAreDisplayed() {
        return areListElementsDisplayed(categoriesList, 11);
    }

    /**
     * @param categoryToFind : category to find
     * @return string after evaluate if the input received coincide with any category.
     * @author am.garcia
     */
    public String categoryIsPresent(String categoryToFind) {
        return elementIsPresentInList(categoriesList, categoryToFind);
    }
}
