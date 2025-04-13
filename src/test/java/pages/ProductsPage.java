package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='header_container']//span[text()='Products']")
    public WebElement productHeader;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    public WebElement firstProduct;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButon;

    @FindBy(xpath= "//div[@id='shopping_cart_container']//span")
    public WebElement addToCartBadge;





    public String getProductHeaderText(){

        return productHeader.getText();
    }

    public void firstProductClick(){
        firstProduct.click();
    }

    public void addProductToCart(){
        addToCartButon.click();
    }

    public void clickToCartBadge(){
        addToCartBadge.click();
    }





}
