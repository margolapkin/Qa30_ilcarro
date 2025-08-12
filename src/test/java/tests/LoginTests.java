package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void preCondition() {
        //if Logged in present--->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();

        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo@gmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        app.getHelperUser().clickOkButton();
    }


        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
       // Assert.assertTrue(app.getHelperUser().isLogged());

//    @Test
//    public void loginSuccess2() {
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().fillLoginForm("margopolotsk1980@gmail.com", "Margo270380$");
//        app.getHelperUser().submitLogin();
//
//
//        Assert.assertTrue(app.getHelperUser().isLogged());
    }



