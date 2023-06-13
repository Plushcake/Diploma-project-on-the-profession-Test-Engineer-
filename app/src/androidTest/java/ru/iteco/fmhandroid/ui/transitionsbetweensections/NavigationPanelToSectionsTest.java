package ru.iteco.fmhandroid.ui.transitionsbetweensections;

//Пункт в тест кейсе № 3

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NavigationPanelToSectionsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void theLoginProcess() throws InterruptedException {
        new LogInSteps().logIn();
    }

    @Test
    @DisplayName("Проверка на работоспособность кнопки Main menu, our mission и authorization")
    @Description("Прокликивание кнопок Main menu, our mission и authorization")
    public void navigationPanelToSections() throws InterruptedException {
        ViewInteraction mainMenuTest = onView(
                allOf(withId(R.id.main_menu_image_button)));
        mainMenuTest.check(matches(isDisplayed()));
        mainMenuTest.perform(click());
        pressBack();

        ViewInteraction LoveIsAllTest = onView(
                allOf(withId(R.id.our_mission_image_button)));
        LoveIsAllTest.check(matches(isDisplayed()));
        LoveIsAllTest.perform(click());

        ViewInteraction textViewLoveIsAllTest = onView(
                allOf(withId(R.id.our_mission_title_text_view)));
        textViewLoveIsAllTest.check(matches(withId(R.id.our_mission_title_text_view)));

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }

}
