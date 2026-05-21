package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("**** Starting TC003_LoginDDT *****");

		try
		{
			// Home Page
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);

			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// My Account Page
			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetpage = macc.isMyAccountPageExists();

			// Valid Data
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetpage)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}
			}

			// Invalid Data
			else if(exp.equalsIgnoreCase("invalid"))
			{
				if(targetpage)
				{
					macc.clickLogout();
					Assert.fail();
				}
				else
				{
					Assert.assertTrue(true);
				}
			}

		}
		catch(Exception e)
		{
			logger.error("Test Failed: " + e.getMessage());

			Assert.fail();
		}

		logger.info("**** Finished TC003_LoginDDT *****");
	}
}