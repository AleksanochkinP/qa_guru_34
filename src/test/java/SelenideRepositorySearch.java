import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
        @BeforeAll
        static void setupConfig() {
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserSize = "1920x1080";
            Configuration.holdBrowserOpen = true;
        }
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com");
        $(".header-search-button").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        $("class=prc-Link-Link-85e08").shouldHave(text("selenide"));

    }

}


