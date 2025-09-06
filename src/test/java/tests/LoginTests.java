package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //if Logged in present--->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");

        }
    }
    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("margo@gmail.com").setPassword("Mmar123456$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");




    }

    @Test(dataProvider ="loginData")
    public void loginSuccess() {
        logger.info("Start test with name'loginSuccess'");
        logger.info("Test data--->email:'margo@gmail.com'& password:'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo@gmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
      //  app.getHelperUser().clickOkButton();
        logger.info("Assert check is Element button 'Sign out'present");
    }


    //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
    // Assert.assertTrue(app.getHelperUser().isLogged());
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        //fill collection
        list.add(new Object[]{"margo@gmail.com","Mmar123456$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"margo@gmail.com","Mmar123456$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        return list.iterator();

    }


    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo@gmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
       // app.getHelperUser().clickOkButton();


//        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data--->email:'margogmail.com'& password:'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margogmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is error Text 'It's not look like email'appeared");
        logger.info("Assert check is button Yalla not active");



    }
    @Test
    public void loginEmptyEmail(){
        logger.info("Test data--->email:''& password:'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is error Text 'Email is required'appeared");
        logger.info("Assert check is button Yalla not active");


    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data--->email:'margo@gmail.com'& password:'Mmar123'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo@gmail.com", "Mmar123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is error Text 'Login or Password incorrect'appeared");


    }
    @Test
    public void loginEmptyPassword(){
        logger.info("Test data--->email:'margo@gmail.com'& password:''");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo@gmail.com", "");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Assert check is error Text 'Password is required'appeared");
        logger.info("Assert check is button Yalla not active");

    }
    @Test
    public void loginUnregistered(){
        logger.info("Test data--->email:'margo123@gmail.com'& password:'Mmar123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("margo123@gmail.com", "Mmar123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is error Text 'Login or Password incorrect'appeared");


    }




    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }

}

