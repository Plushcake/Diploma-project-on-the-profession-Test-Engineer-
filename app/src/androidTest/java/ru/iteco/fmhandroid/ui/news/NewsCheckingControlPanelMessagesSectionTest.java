package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 24

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
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
import ru.iteco.fmhandroid.ui.pageObject.ClickEditNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelMessagesSectionTest {

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
    @DisplayName("Раздел Control Panel. Проверка кнопок в сообщении.")
    @Description("Проверка работоспособность кнопок в сообщении - переходы по разделам.")
    public void newsCheckingControlPanelMessagesSection() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new ButtonNewsSteps().recyclerViewNews();
        new ButtonNewsSteps().recyclerViewNews();

        new ClickDeleteNewsListSteps().clickDeleteNewsListStep();

        ViewInteraction textCheckView = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textCheckView.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonCancelAlert();

        new ClickEditNewsListSteps().clickEditNewsListStep();

        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));

        pressBack();

        new LogOutSteps().logOut();
    }

}
