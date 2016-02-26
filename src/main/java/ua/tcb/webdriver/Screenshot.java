/**
 * 
 */
package ua.tcb.webdriver;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;

/**
 *  These is Screenshot listener, which is needed to create
 * 	screens on test cases failures.
 * 	Screenshot are usually saved in path.
 * @author Maksym_Mazurkevych on 2/26/2016
 */

public class Screenshot extends TestListenerAdapter {
	private static final Logger LOGGER = Logger.getLogger(Screenshot.class);

	@Override
	public void onTestFailure(ITestResult result) {
		File file = new File("");

		Reporter.setCurrentTestResult(result);
		System.out.println(file.getAbsolutePath());

		try {
			BasicTestCase.captureScreenShot(result.getName());
		} catch (Exception e) {
			LOGGER.warn("Unable to capture screenshot.  Continuing...", e);
		}
		Reporter.setCurrentTestResult(null);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

}
