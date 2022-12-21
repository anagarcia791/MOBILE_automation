package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddPlansScreen;
import screens.DashBoardScreen;
import util.reporter.Reporter;
import util.tests.BaseMobileTest;

public class AddPlansTest extends BaseMobileTest {
    @Description(value = "Add plans screen test")
    @Test(priority = 3)
    public void navigateToPrivacyAndLegal() {
        Reporter.info("TEST START, add plans screen---------------");

        Reporter.info("Start Navigation to Add Plans Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        AddPlansScreen addPlans = dashBoard.goToAddPlansScreen();

        Reporter.info("Validate Check Dining Availability Button is displayed");
        Assert.assertEquals(addPlans.planIsPresent("Check Dining Availability"), "Check Dining Availability");

        addPlans.clickPlan(0);

        Reporter.info("Validate Dining Availability Component");
        Assert.assertTrue(addPlans.diningAvailabilityComponentDisplayed(), "Dining Availability Component is not displayed");

        Reporter.info("TEST FINISH, add plans screen---------------");
    }
}
