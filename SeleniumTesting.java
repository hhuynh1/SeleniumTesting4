/*
* Software Testing & Quality Assurance
* Purpose: Use Selenium library to automate web browser testing
*
*
* Created by: Henry Huynh
* Georgia Gwinnett College
* 3/29/2018
* */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTesting {
   public static WebDriver driver;

   /*
   * This method will set the path to the chromedriver.exe and create a new WebDriver
   * */
   @BeforeClass
   public static void setupChrome() {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software Development\\Downloads\\chromedriver.exe");
       driver = new ChromeDriver();
   }

   /*
   * This method will create WebElement objects and retrieve ID of the source.
   * Each object of WebElement will call the clear() and sendKeys() to pass in the values.
   * confirmEmail.submit() will be the method that will submit the form after all codes are ran
   * */
   @Test
   public void resgitrationTest() throws Exception {

       // Stores URL into driver WebDriver object
       driver.get("https://ihgrewardsclubdining.rewardsnetwork.com/join.htm");

       // Creating WebElement objects based on the URL's registration form
       WebElement firstName = driver.findElement(By.id("firstName"));
       WebElement lastName = driver.findElement(By.id("lastName"));
       WebElement zipcode = driver.findElement(By.id("zipcode"));
       WebElement email = driver.findElement(By.id("email"));
       WebElement confirmEmail = driver.findElement(By.id("emailConfirm"));

       // Each object will clear the text field and pass in the values as a String
       firstName.clear();
       firstName.sendKeys("Henry");

       lastName.clear();
       lastName.sendKeys("Huynh");

       zipcode.clear();
       zipcode.sendKeys("30518");

       email.clear();
       email.sendKeys("henryhuynh404@gmail.com");

       confirmEmail.clear();
       confirmEmail.sendKeys("henryhuynh404@gmail.com");

       // Submits the form for testing
       confirmEmail.submit();
       System.out.println("Registration test complete!");
   }

   // Tests the confirmation page
   @AfterClass
   public static void testConfirmationPage() {

       WebElement address = driver.findElement(By.id("address1"));
       if(address.getAttribute("value").isEmpty()) {
           System.out.println("Sucessfully loaded membership creation page");
       } else {
           System.out.println("Error");
       }

   }
}
