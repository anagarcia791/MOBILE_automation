package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.CategoryListComponent;
import screens.DashBoardScreen;
import screens.MapScreen;
import util.reporter.Reporter;
import util.tests.BaseMobileTest;

public class CategoryListTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation and categories list.
     */
    @Description(value = "Map screen Navigation test")
    @Test(priority = 1)
    public void navigateToMapScreen() {
        Reporter.info("TEST START, navigation to map and categories list---------------");

        Reporter.info("Start Navigation to Map Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MapScreen map = dashBoard.goToMapScreen();

        Reporter.info("Validate Filter Button");
        Assert.assertTrue(map.filterIsDisplayed(), "Filter is not displayed");

        Reporter.info("Validate Categories Button");
        Assert.assertTrue(map.categoriesIsDisplayed(), "Categories is not displayed");

        Reporter.info("Validate Show List Button");
        Assert.assertTrue(map.showListIsDisplayed(), "Show List is not displayed");

        CategoryListComponent categoryList = map.clickCategoryListComponent();

        Reporter.info("Validate Categories Title");
        Assert.assertTrue(categoryList.selectCategoryTitleIsDisplayed(), "Categories List is not displayed");

        Reporter.info("Validate Categories");
        Assert.assertTrue(categoryList.categoriesAreDisplayed(), "Categories are not displayed");

        Reporter.info("Validate Hotels is displayed");
        Assert.assertEquals(categoryList.categoryIsPresent("Hotels"), "Hotels");

        Reporter.info("TEST FINISH, navigation to map and categories list---------------");
    }

}
