package tests.saucedemo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class LoginTest extends TestBaseRapor{

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage= new ProductsPage();




    @Test
    public void loginTest(){


        //1 - https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        ReusableMethods.bekle(1);

        loginPage.usernameTextbox.sendKeys("saucelab");
        loginPage.passwordTextbox.sendKeys("logintest");
        loginPage.loginButon.click();


        String actualValue= loginPage.errorMessage.getText();
        String expectedValue="Epic sadface";

        Assert.assertTrue( actualValue.contains(expectedValue));

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }

    @Test

    public void loginToApp(){

        Driver.getDriver().get("https://www.saucedemo.com/");
        ReusableMethods.bekle(1);

        loginPage.loginToApp("standard_user","secret_sauce");

        String actualValue= productsPage.productHeader.getText();
        String expectedValue= "Products";

        Assert.assertTrue(actualValue.contains(expectedValue));

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }

    @Test

    public void loginToApp1(){
        Driver.getDriver().get("https://www.saucedemo.com/");
        ReusableMethods.bekle(1);

        loginPage.loginToApp("standard_user","secret_sauce");

        String actualValue=productsPage.getProductHeaderText();
        String expectedValue="Products";

        Assert.assertTrue(actualValue.contains(expectedValue));

    }


}
