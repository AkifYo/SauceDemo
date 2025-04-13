package tests.saucedemo;


import org.testng.Assert;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.awt.*;
import java.awt.event.KeyEvent;

import static utilities.Driver.driver;


public class AddingTheProductToTheCart {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage=new ProductsPage();
    CartPage cartPage=new CartPage();



    @Test

    public void productAddingTest() throws AWTException {

        Driver.getDriver().get("https://www.saucedemo.com/");
        ReusableMethods.bekle(1);

        loginPage.loginToApp(ConfigReader.getProperty("loginUsername"),ConfigReader.getProperty("loginPassword"));
        /*ReusableMethods.bekle(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();*/
        Robot robot = new Robot();
        robot.delay(1000); // Pop-up çıkması için bekleme
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        productsPage.firstProductClick();
        productsPage.addProductToCart();
        productsPage.clickToCartBadge();
        String actualValue=cartPage.getCheckoutButonText();
        String expectedValue="Checkout";
        Assert.assertTrue(actualValue.contains(expectedValue));

        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }



}
