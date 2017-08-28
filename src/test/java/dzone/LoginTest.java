package dzone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        String driverPath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void succeeded() {
        System.out.println("Login with correct credentials");
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("success message not present", login.successMessagePresent());
    }

    @Test
    public void failed(){
        System.out.println("Login with wrong credentials");
        login.with("tester", "somepass");
        assertTrue("failed message is not displayed", login.failedMessagePresent());
    }
}
