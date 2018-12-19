package pompage_7_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SuiteCRMTaskOverviewPage extends SuiteCRMCreateTaskPage{
	
	public SuiteCRMTaskOverviewPage(WebDriver driver) {
		//PageFactory.initElements(driver, this);  Since we extend it we need to use implemented class driver and constructor
		super(driver);
	}

}
