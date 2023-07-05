package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 28

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.ClickDeleteNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelDeleteMessageTest {

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
    @DisplayName("В разделе News проверяется удаление сообщения")
    @Description("Удаление сообщения и проверка предупреждающих сообщений")
    public void newsCheckingControlPanelDeleteMessage() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();

        new ClickDeleteNewsListSteps().clickDeleteNewsListStep();//Доделать!
        

        new ButtonNewsSteps().buttonCancelAlert();

        new ClickDeleteNewsListSteps().clickDeleteNewsListStep();

        ViewInteraction textViewCheck = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textViewCheck.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonOkAlert();

        ViewInteraction checkTextViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkTextViewControlPanel.check(matches(isDisplayed()));

        new LogOutSteps().logOut();
    }

}
