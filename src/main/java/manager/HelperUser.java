package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));

    }


    public void fillLoginForm(String email, String password) {

        type(By.xpath("//input[@id='email']"), email);


        type(By.xpath("//input[@id='password']"), password);

    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));


    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));

    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='ok']"));
    }

    public String getMessage() {
        // return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        String text = element.getText();
        return text;


    }
}
