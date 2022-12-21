package tests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.DashBoardScreen;
import screens.MoreOptionsScreen;
import screens.PrivacyAndLegalComponent;
import util.reporter.Reporter;
import util.tests.BaseMobileTest;

public class PrivacyLegalTest extends BaseMobileTest {

    /**
     * Validate Privacy & Legal elements.
     */
    @Description(value = "More options screen and privacy-legal test")
    @Test(priority = 2)
    public void navigateToPrivacyAndLegal() {
        Reporter.info("TEST START, more options screen and privacy-legal---------------");

        Reporter.info("Start Navigation to More Options Screen");
        DashBoardScreen dashBoard = loadDashBoardScreen();
        MoreOptionsScreen more = dashBoard.goToMoreOptionsScreen();

        Reporter.info("Scroll to end more options screen action");
        more.scrollToEndMoreOptionsScreen();

        Reporter.info("Click in privacy and legal for more info");
        PrivacyAndLegalComponent privacy = more.clickPrivacyLegalButton();

        Reporter.info("Validate Privacy & Legal Title");
        Assert.assertTrue(privacy.privacyLegalTitleTitleIsDisplayed(), "Privacy & Legal List is not displayed");

        Reporter.info("Validate privacy and legal elements");
        Assert.assertTrue(privacy.privacyLegalElementsAreDisplayed(), "Privacy elements are not displayed");

        Reporter.info("TEST FINISH, more options screen and privacy & legal---------------");
    }
}
