package ru.iteco.fmhandroid.ui.timecalendarTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DateTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            new VerificationPage().checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            new LogOutSteps().logOut();
        }
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность переключения месяца")
    public void changesOfTheMonth() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DateAndTimeSteps().nextMonth();
        new DateAndTimeSteps().previousMonth();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность выбора года")
    public void changesOfTheYear() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DateAndTimeSteps().choiceOfTheYear();
        new DateAndTimeSteps().listOfYears();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Ok")
    public void testTheOkButton() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Cancel")
    public void testTheCancelButton() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем изменение дня")
    public void testChangeOfDay() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();

        ViewInteraction materialTextView4 = onView(
                allOf(withClassName(is("com.google.android.material.textview.MaterialTextView")),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        10),
                                10),
                        isDisplayed()));
        materialTextView4.perform(click());

        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    //Попытка изменения даты.
//        ViewInteraction materialTextView4 = onView(
//                allOf(withClassName(is("com.google.android.material.textview.MaterialTextView")), withText("Sun, Jul 30"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.LinearLayout")),
//                                        0),
//                                1),
//                        isDisplayed()));
//        materialTextView4.perform(click());

//        LinearLayout — Макет, который размещает другие представления либо горизонтально в одном столбце, либо по вертикали в одной строке.
//        Контейнер LinearLayout представляет простейший контейнер - объект ViewGroup, который упорядочивает все дочерние элементы в одном направлении: по горизонтали или по вертикали.
//        Все элемены расположены один за другим.
//
//Коды для размышления.
//        ViewInteraction selectFromTheList =
//                onView(withText("Ivanov Ivan Ivanovich"))
//                        .inRoot(RootMatchers.isPlatformPopup())
//                        .perform(click());
//        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));
//  ////
//        public void buttonDeleteExperiment() {
//            onView(withId(R.id.news_list_recycler_view)).perform(
//                    RecyclerViewActions.actionOnItemAtPosition(0, ChildViewWithIdStep.clickChildViewWithIdStep(R.id.delete_news_item_image_view)));
//        }


    /////////////////////////////////////////////////
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
