package pages;

import org.openqa.selenium.By;

public class LogInPage extends BaseDriver {

	public String LOGINPAGETITLE = "Daraz.com.bd: Online Shoping Bangladesh - Mobiles, Tablets, Home Appliances, Tv, Audio & amp; More";
	public By PHONE_NUMBER_EMAIL_INPUT_FIELD = By
			.xpath("//input[@placeholder='Please enter your Phone Number or Email']");
	public By PASSWORD_INPUT_FIELD = By.xpath("//input[@placeholder='Please enter your password']");
	public By LOGINBUTTON = By.xpath("//button[normalize-space()='LOGIN']");

	public void doLogin(String email, String password) {

		write(PHONE_NUMBER_EMAIL_INPUT_FIELD, email);
		write(PASSWORD_INPUT_FIELD, password);
		clickOnElemet(LOGINBUTTON);
	}
}
