
// test runner file

package nl.abcd.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import nl.abcd.test.utilities.Upload;

import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"
                , "rerun:target/failure/rerun.txt"}
        ,features = "src/test/features",
        glue = {"nl.abcd.test.steps"}
        )

public class RunCucumberIT {
	
	@AfterClass
	public static void test1() throws Exception{
		List<String> files = Upload.fetchFiles(System.getProperty("user.dir")+"/target/cucumber-report/","cucumber/json");
        for(String file:files) {
        	System.out.println(file);
        	Upload.uploadfile(file, "CUCUMBER", "", "", "Selenium", "", "", "cos", "", "");
        }
	}
}
