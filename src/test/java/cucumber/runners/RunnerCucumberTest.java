package cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", //cadastroContas.feature
		glue = {"cucumber.steps", "cucumber.config"},
		tags = {"@unitarios", "not @ignore"},
		//tags = "~@ignore",
		//tags = "@tipo1",
		//tags = "@tipo2",
		//tags = {"@tipo1, @tipo2"},
		//tags = "@ignore",
		plugin = {"pretty", "html:target/report-html", "json:target/report-json"},
		monochrome =  false, //false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerCucumberTest {
	
}
