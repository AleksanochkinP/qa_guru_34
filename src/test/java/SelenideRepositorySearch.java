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
        $("class='Box-sc-g0xbh4-0 kzfhBO search-match prc-Text-Text-0ima0'").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }

}


