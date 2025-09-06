package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));

    }
    public void fillLoginForm(User user) {

        type(By.id("email"), user.getEmail());

        type(By.id("password"), user.getPassword());

    }

    public void fillLoginForm(String email, String password) {

        type(By.id("email"), email);


        type(By.id("password"), password);

    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));


    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));

    }

    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='ok']")))
        click(By.xpath("//button[text()='ok']"));
    }

    public String getMessage() {
        // return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        String text = element.getText();
        return text;


    }
//*****************************************************************************************
    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
        
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getFirstName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));--->variant 1
       // click(By.cssSelector("label[for='terms-of-use']"));--->variant 2
        //variant 3
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");


    }
    public void checkPolicyXY() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rect = label.getRect();
            int w = rect.getWidth();
            // Dimension size = wd.manage().window().getSize();

            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }

    }
    public String getErrorText(){
        return wd.findElement(By.cssSelector("div.error")).getText();

    }

}
