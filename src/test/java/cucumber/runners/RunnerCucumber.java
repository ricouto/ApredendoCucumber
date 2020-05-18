package cucumber.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/aprendercucumber.feature",
		glue = "cucumber.steps",
		//tags = "~@ignore",
		//tags = "@tipo1",
		//tags = "@tipo2",
		tags = {"@tipo1, @tipo2"},
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerCucumber {

}
