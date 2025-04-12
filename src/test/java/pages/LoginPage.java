package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameTextbox;

    @FindBy(id = "password")
    public WebElement passwordTextbox;

    @FindBy(id = "login-button")
    public WebElement loginButon;

    @FindBy(xpath = "//div[@id='login_button_container']//h3")
    public WebElement errorMessage;


    public void  loginToApp(String username, String password){

        usernameTextbox.sendKeys(username);
        passwordTextbox.sendKeys(password);
        loginButon.click();
    }

}
