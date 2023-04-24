package objectsContainer;


import org.openqa.selenium.WebElement;

import pageClasses.AfterPayLoginPage;
import pageClasses.CartPage;
import pageClasses.CreateAccountPage;
import pageClasses.HomePage;
import pageClasses.LoginPage;
import pageClasses.MyAccountDashBoardPage;
import pageClasses.OrderConfirmationPage;
import pageClasses.PDPPage;
import pageClasses.PLPPage;
import pageClasses.PayPalLoginPage;
import pageClasses.ShippingAndPaymentPageStepDefinition;
import stepDefinitions.CucumberHooks;

public class ObjectsContainer {
	
	public HomePage home = new HomePage();
	public PLPPage plp = new PLPPage();
	public PDPPage pdp = new PDPPage();
	public CartPage cart = new CartPage();
	public LoginPage login = new LoginPage();
	public ShippingAndPaymentPageStepDefinition payment = new ShippingAndPaymentPageStepDefinition();
	public OrderConfirmationPage orderConfirmation = new OrderConfirmationPage();
	public MyAccountDashBoardPage account = new MyAccountDashBoardPage();
	public PayPalLoginPage payPal = new PayPalLoginPage();
	public CreateAccountPage newAccount = new CreateAccountPage();
	public AfterPayLoginPage afterPay = new AfterPayLoginPage(); 
	
	public WebElement ele;
	
	public CreateAccountPage getCreateAccountPage()
	{
		return newAccount;
	}
	public static ObjectsContainer getObjectsContainer()
	{
		return CucumberHooks.setUpObject.pageObjects;
	}
	public PayPalLoginPage getPayPalLoginPage()
	{
		return payPal;
	}
	public HomePage getHomePage()
	{
		return home;
	}
	public LoginPage getLoginPage()
	{
		return login;
	}
	public ShippingAndPaymentPageStepDefinition getShippingAndPaymentPage()
	{
		return payment;
	}
	public OrderConfirmationPage getOrderConfirmationPage()
	{
		return orderConfirmation;
	}
	public MyAccountDashBoardPage getMyAccountDashBoard()
	{
		return account;
	}
	public WebElement getPageObject(String field, String page) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		WebElement ele=null;
		if(page.equalsIgnoreCase("HomePage")) {
		ele = (WebElement) home.getClass().getDeclaredField(field).get(home);
			
		}
		else if(page.equalsIgnoreCase("LoginPage")) {
			ele = (WebElement) login.getClass().getDeclaredField(field).get(login);
				
			}
		else if(page.equalsIgnoreCase("CheckoutPaymentBillingPage")) {
			ele = (WebElement) payment.getClass().getDeclaredField(field).get(payment);
				
			}
		else if(page.equalsIgnoreCase("OrderConfirmationPage")) {
			ele = (WebElement) orderConfirmation.getClass().getDeclaredField(field).get(orderConfirmation);
				
			}
		else if(page.equalsIgnoreCase("MyAccountDashBoard")) {
			ele = (WebElement) account.getClass().getDeclaredField(field).get(account);
				
			}
		else if(page.equalsIgnoreCase("PayPalLoginPage")) {

			ele = (WebElement) payPal.getClass().getDeclaredField(field).get(payPal);
		}
		else if(page.equalsIgnoreCase("CreateAccountPage")) {

			ele = (WebElement) newAccount.getClass().getDeclaredField(field).get(newAccount);
		}
		else if(page.equalsIgnoreCase("PLPPage")) {

			ele = (WebElement) plp.getClass().getDeclaredField(field).get(plp);
		}
		else if(page.equalsIgnoreCase("PDPPage")) {

			ele = (WebElement) pdp.getClass().getDeclaredField(field).get(pdp);
		}
		else if(page.equalsIgnoreCase("CartPage")) {

			ele = (WebElement) cart.getClass().getDeclaredField(field).get(cart);
		}
		else if(page.equalsIgnoreCase("AfterPayLoginPage")) {

			ele = (WebElement) afterPay.getClass().getDeclaredField(field).get(afterPay);
		}
		else {
			System.out.println(page + " DOES NOT EXIST");
		}
		 
		return ele;
	}
}
