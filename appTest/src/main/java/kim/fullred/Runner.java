package kim.fullred;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "classpath:features/",
        tags = {"not @ignore"},
        plugin = {"pretty"},
        glue = {"kim.fullred"}
)

public class Runner {


}
