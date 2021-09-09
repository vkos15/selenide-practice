
package github;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WikiGithub {

    @Test
    void testPageSoftAssertions() {
        //открыть страницу selenide в github
        open("https://github.com/selenide/selenide/");
        // Переход в раздел Wiki проекта
        $("#wiki-tab").click();
        $("#wiki-pages-box .js-wiki-more-pages-link").click();
        $$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5"));
        //проверили, что есть код для JUnit5
        $x("//*[contains(text(),'Using JUnit5')]").parent().sibling(0)
                .shouldHave(cssClass("highlight-source-java"))
                .shouldHave(text("@ExtendWith"), text("SoftAssertsExtension"), text("@Test"));

    }
}
