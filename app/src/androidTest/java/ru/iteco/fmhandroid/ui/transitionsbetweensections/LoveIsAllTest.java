package ru.iteco.fmhandroid.ui.transitionsbetweensections;

//Пункт в тест кейсе № 5

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoveIsAllTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void theLoginProcess() throws InterruptedException {
        new LogInSteps().logIn();
    }

    @After
    public void logOut() {
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("Проверка раздела Love Is All")
    @Description("Проверяем успешный переход в раздел")
    public void loveIsAllTest() throws InterruptedException {
        ViewInteraction clickButtonLoveIsAll = onView(
                allOf(withId(R.id.our_mission_image_button)));
        clickButtonLoveIsAll.perform(click());

        ViewInteraction checkTextLoveIsAll = onView(
                anyOf(withText("Love is all"), withText("Главное - жить любя")));
        checkTextLoveIsAll.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.our_mission_item_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.our_mission_item_list_recycler_view)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));


        ViewInteraction checkTextID = onView(
                allOf(withId(R.id.our_mission_title_text_view)));
        checkTextID.check(matches(isDisplayed()));

    }

}
