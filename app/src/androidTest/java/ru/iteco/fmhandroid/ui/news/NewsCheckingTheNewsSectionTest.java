package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 19

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingTheNewsSectionTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел News проверка кнопок")
    @Description("В разделе News проверяем работоспособность кнопок и переход в разделы")

    public void newsCheckingTheNewsSectionTest() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();

        ViewInteraction checkTextNews = onView(
                anyOf(withText("News"), withText("Новости")));
        checkTextNews.check(matches(isDisplayed()));

        new ButtonNewsSteps().recyclerViewNews();
        new ButtonNewsSteps().recyclerViewNews();

        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonSortNews();

        new ButtonNewsSteps().buttonFilterNews();

        ViewInteraction checkFilterText = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterText.check(matches(isDisplayed()));

        pressBack();

        new ButtonNewsSteps().buttonEditNews();

        ViewInteraction checkNewsListRecycler = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkNewsListRecycler.check(matches(isDisplayed()));

        pressBack();

        new LogOutSteps().logOut();

    }

}
