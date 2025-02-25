package pages.WEB;

import helpers.WEB.webUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class homePage extends webUtility {

    String username = randomUsername();
    String password = randomPassword();

    By signupNavigation = By.id("signin2");
    By usernameTextbox_signup = By.id("sign-username");
    By passwordTextbox_signup = By.id("sign-password");
    By signupButton = By.xpath("//*[@onclick='register()']");
    By loginNavigation = By.id("login2");
    By usernameTextbox_login = By.id("loginusername");
    By passwordTextbox_login = By.id("loginpassword");
    By loginButton = By.xpath("//*[@onclick='logIn()']");
    By user_nameNavigation = By.id("nameofuser");
    By logoutButton = By.id("logout2");
    By categories(String text) {
        return By.xpath("//*[text()='"+text+"']");
    }
    By productList = By.id("tbodyid");
    By productTitle(String text){
        return By.xpath("//a[contains(text(),'"+text+"')]");
    }
    By nextButton = By.xpath("//button[@id='next2']");
    By productGrid = By.xpath("//div[@id='tbodyid']/div[contains(@class, 'col-lg-4')]");

    public void goToHomePage(){
        driver.get("https://www.demoblaze.com/");
    }
    public void clickSignupNavigation(){
        driver.findElement(signupNavigation).click();
    }
    public void createUsername(){
        WebElement element = driver.findElement(usernameTextbox_signup);
        element.click();
        element.clear();
        element.sendKeys(username);
    }
    public void createPassword(){
        WebElement element = driver.findElement(passwordTextbox_signup);
        element.click();
        element.clear();
        element.sendKeys(password);
    }
    public void clickSignupButton(){
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(signupButton),
                ExpectedConditions.elementToBeClickable(signupButton)
        ));
        driver.findElement(signupButton).click();
    }
    public void validateAlertMessage(String message){
        wait.until(ExpectedConditions.alertIsPresent());
        String actualText = driver.switchTo().alert().getText();
        assertTrue(actualText.contains(message));
        driver.switchTo().alert().dismiss();
    }
    public void inputExistUser(String text){
        WebElement element = driver.findElement(usernameTextbox_signup);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void clickLoginNavigation(){
        driver.findElement(loginNavigation).click();
    }
    public void inputUsername(){
        WebElement element = driver.findElement(usernameTextbox_login);
        element.click();
        element.clear();
        element.sendKeys(username);
    }
    public void inputPassword(){
        WebElement element = driver.findElement(passwordTextbox_login);
        element.click();
        element.clear();
        element.sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void validateLoginStatus(){
        driver.findElement(user_nameNavigation).isDisplayed();
    }
    public void clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
    public void validateLogoutStatus(){
        driver.findElement(signupNavigation).isDisplayed();
        driver.findElement(loginNavigation).isDisplayed();
    }
    public void inputWrongPassword(String text){
        WebElement element = driver.findElement(passwordTextbox_login);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void chooseCategory(String text){
        driver.findElement(categories(text)).click();
    }
    public void validateProductList(){
        driver.findElement(productList).isDisplayed();
    }
    public void clickProductTitle(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle(text)));
        wait.until(ExpectedConditions.elementToBeClickable(productTitle(text)));
        driver.findElement(productTitle(text)).click();
    }
    public void clickNextButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productGrid));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }
}
