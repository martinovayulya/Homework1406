import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static By username = By.id("username");
    static By password = By.id("password");
    static By submit = By.xpath("//*[contains(text(),'Login')]");
    static WebDriver driver = new ChromeDriver();
    static By UpcomingBookings = By.xpath("//*[contains(text(),'Make a new booking')]");


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        testSuccessfulLoginToPrivate();
//        testLoginToPrivateWithWrongPassword();
        driver.close();
    }

    public static void testSuccessfulLoginToPrivate() {
        String url = "https://192.0.2.17/web-portal/login_private";
        String user = "yuliya.martynova@magenta-technology.com";
        String userPassword = "123";
        driver.get(url);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(submit).click();
        //driver.findElement(UpcomingBookings).click();
        Asserts.check(driver.findElement(UpcomingBookings)==null, "assert works");

    }

    public static void testLoginToPrivateWithWrongPassword() {
        String url = "https://192.0.2.17/web-portal/login_private";
        String user = "yuliya.martynova@magenta-technology.com";
        String userPassword = "WRONG_PASS";
        driver.get(url);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(submit).click();
    }
}

