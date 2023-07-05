package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 21

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.ClickDeleteNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.ClickEditNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("Проверяем раздел Control Panel.")
    @Description("В разделе Control Panel проверяем переходы в подразделы")
    public void newsCheckingControlPanel() throws InterruptedException {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();

        ViewInteraction checkControlPanel = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkControlPanel.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonSortNews();

        new ButtonNewsSteps().buttonFilterNews();

        ViewInteraction checkFilterNews = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterNews.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonCancelNews();

        new ButtonNewsSteps().buttonAddNews();

        ViewInteraction checkTextCreating = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view)));
        checkTextCreating.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonCancelNews();
        new ButtonNewsSteps().buttonOkAlert();

        new ButtonNewsSteps().recyclerViewNews();
        new ButtonNewsSteps().recyclerViewNews();

        new ClickDeleteNewsListSteps().clickDeleteNewsListStep();

        ViewInteraction textView = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textView.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonCancelAlert();

        new ClickEditNewsListSteps().clickEditNewsListStep();

        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));

        pressBack();

        new LogOutSteps().logOut();
    }


}
