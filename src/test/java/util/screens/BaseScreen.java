package util.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Base class for all screens Objects.
 *
 * @author Arley.Bolivar
 */
public abstract class BaseScreen {

    /**
     * The driver.
     */
    protected final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Swipe vertical.
     *
     * @param percentage of swipe
     * @author am.garcia
     */
    @SuppressWarnings({"rawtypes", "unused"})
    public void swipeVertical(float percentage) {
        Dimension windowSize = driver.manage().window().getSize();

        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point((int) (windowSize.width * 0.5), (int) (windowSize.height * 0.5)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point((int) (windowSize.width * 0.5), (int) (windowSize.height * percentage)))
                .release()
                .perform();
    }

    /**
     * Wrapper for click  event specifying custom wait.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Wrapper for sendKeys event.
     *
     * @param element  : AndroidElement
     * @param sequence : String
     * @author Hans.Marquez
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * @param list                   : list to evaluate
     * @param expectedElementsAmount : expected amount of elements in list
     * @return true if List elements are displayed in screen, otherwise false.
     */
    public boolean areListElementsDisplayed(List<AndroidElement> list, int expectedElementsAmount) {

        AtomicInteger truthyValue = new AtomicInteger();

        list.forEach(element -> {
            if (!element.getText().equalsIgnoreCase("")) {
                truthyValue.addAndGet(1);
            }
        });

        return truthyValue.get() == expectedElementsAmount;
    }

    /**
     * @param list          : list to evaluate
     * @param elementToFind : element to find
     * @return string after evaluate if the input received coincide with any element in list.
     */
    public String elementIsPresentInList(List<AndroidElement> list, String elementToFind) {

        List<AndroidElement> evaluatedList =
                list.stream()
                        .filter(category -> category.getText().equalsIgnoreCase(elementToFind))
                        .collect(Collectors.toList());

        if (evaluatedList.size() == 0) {
            return "";
        } else {
            return evaluatedList.get(0).getText();
        }
    }

}
