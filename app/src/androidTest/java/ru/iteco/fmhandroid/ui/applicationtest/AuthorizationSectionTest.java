package ru.iteco.fmhandroid.ui.applicationtest;

//Пункт в тест кейсе № 1

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
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
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationSectionTest {

    VerificationPage authorizationPage = new VerificationPage();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    DataHelper dataHelper = new DataHelper();

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            authorizationPage.checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            logOutSteps.logOut();
        }

    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    //Выдерживает максиму "5" тестов в одном классе.
    //Ввести в cmd команду allure serve
    @Test
    @DisplayName("Проверка авторизации пользователя")
    @Description("Вход в аккаунт с вылидными значениями")
    public void enterAuthorizationTest() {
        verificationPage.checkViewTextAuthorization();
        verificationPage.checkViewLogin();
        verificationPage.checkViewPassword();
        verificationPage.checkTextSignIn();
        dataHelper.logIn();
        verificationPage.checkContainerListNews();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Тестирование раздела LogOut.")
    @Description("Проверяем успешный выход из аккаунта")
    public void logOutTest() {
        dataHelper.logIn();

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isCompletelyDisplayed()));
        clickAuthorization.perform(click());

        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isCompletelyDisplayed()));
        textViewLogOutTest.perform(click());

    }

}
