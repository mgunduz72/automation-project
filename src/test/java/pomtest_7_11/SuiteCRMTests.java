package pomtest_7_11;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompage_7_11.SuiteCRMCreateTaskPage;
import pompage_7_11.SuiteCRMHomePage;
import pompage_7_11.SuiteCRMLoginPage;
import pompage_7_11.SuiteCRMTaskOverviewPage;
          //If I make this static and add .* I can use 
import static utilities.ConfigReader.*;

public class SuiteCRMTests extends TestBase{
	
	SuiteCRMLoginPage loginpage;
	SuiteCRMHomePage  homepage;
	SuiteCRMCreateTaskPage  taskpage;
	SuiteCRMTaskOverviewPage overview;
	
	@BeforeMethod
	public void setupMethod() {
		
		driver.get(getMyValue("suitecrm.url"));
		driver.manage().window().fullscreen();
		loginpage = new SuiteCRMLoginPage(driver);
		taskpage= new SuiteCRMCreateTaskPage(driver);
		overview= new SuiteCRMTaskOverviewPage(driver);
		homepage= new SuiteCRMHomePage(driver);
	}
	
	@Test
	public void createTaskInSuiteCRM() {
		loginpage.login(getMyValue("suitecrm.username"), getMyValue("suitecrm.password"));
		homepage.createNewItem("Create Task");
		taskpage.subject.sendKeys(getMyValue("suitecrm.tasksubject"));
		new Select(taskpage.status).selectByVisibleText(getMyValue("suitecrm.taskstatus"));
		taskpage.description.sendKeys(getMyValue("suitecrm.description"));
		
	}
	}


