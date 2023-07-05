package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 8

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
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
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.FilterSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsTest {

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
    @DisplayName("Раздел Claims. Проходимся по всем разделам.")
    @Description("Прокликивание в Claims-е всех разделов")
    public void claimsTest() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new FilterSteps().buttonFilter();

        ViewInteraction checkTextFiltering = onView(
                anyOf(withText("Filtering"), withText("Фильтрация")));
        checkTextFiltering.check(matches(isDisplayed()));

        new FilterSteps().buttonCancel();
        new ButtonSteps().buttonCreatingClaims();

        ViewInteraction checkTextCreating = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating.check(matches(isDisplayed()));

        new ButtonSteps().buttonCancelCreatingClaims();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new ButtonSteps().listRecyclerClaims();

        ViewInteraction checkButtonChangeStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        checkButtonChangeStatus.perform(scrollTo());
        checkButtonChangeStatus.check(matches(isDisplayed()));
        new LogOutSteps().logOut();
    }
}
