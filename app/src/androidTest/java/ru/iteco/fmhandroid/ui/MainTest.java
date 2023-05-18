package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 7

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка раздела Main")
    @io.qameta.allure.kotlin.Description("В разделе Main переходим между разделами")
    public void mainTest() throws InterruptedException {
        Thread.sleep(7000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(typeText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(typeText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.perform(click());


        Thread.sleep(3000);


        ViewInteraction checkTextNews1 = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        checkTextNews1.check(matches(isDisplayed()));

        ViewInteraction clickButton1 = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include_on_fragment_main),
                                        0),
                                4)));
        clickButton1.check(matches(isDisplayed()));
        clickButton1.perform(click());

        ViewInteraction clickButton2 = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include_on_fragment_main),
                                        0),
                                4)));
        clickButton2.check(matches(isDisplayed()));
        clickButton2.perform(click());


        ViewInteraction recyclerViewList = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerViewList.check(matches(isDisplayed()));
        recyclerViewList.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerView2.check(matches(isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));


        ViewInteraction clickAllNews = onView((withId(R.id.all_news_text_view)));
        clickAllNews.check(matches(isDisplayed()));
        clickAllNews.perform(click());

        ViewInteraction checkTextNews2 = onView(
                allOf(withId(R.id.container_list_news_include)));
        checkTextNews2.check(matches(isDisplayed()));

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickTitleMenu1 = onView(
                anyOf(withText("Main"), withText("Главная")));
        clickTitleMenu1.check(matches(isDisplayed()));
        clickTitleMenu1.perform(click());


        ViewInteraction clickClaims1List = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_claim_include_on_fragment_main),
                                        0),
                                3)));
        clickClaims1List.check(matches(isDisplayed()));
        clickClaims1List.perform(click());

        ViewInteraction clickClaims2List = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_claim_include_on_fragment_main),
                                        0),
                                3)));
        clickClaims2List.check(matches(isDisplayed()));
        clickClaims2List.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        materialButton6.perform(click());


        ViewInteraction checkCreatingClaims = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_claim),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))))));
        checkCreatingClaims.check(matches(isDisplayed()));

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickButton3 = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include_on_fragment_main),
                                        0),
                                4)));
        clickButton3.check(matches(isDisplayed()));
        clickButton3.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickAllClaims = onView(
                allOf(withId(R.id.all_claims_text_view),
                        childAtPosition(
                                allOf(withId(R.id.container_list_claim_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                1)));
        clickAllClaims.check(matches(isDisplayed()));
        clickAllClaims.perform(click());

        ViewInteraction checkEditClaims = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkEditClaims.check(matches(isDisplayed()));

        ViewInteraction clickMaimMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMaimMenu.check(matches(isDisplayed()));
        clickMaimMenu.perform(click());

        ViewInteraction clickTitleMenu2 = onView(
                anyOf(withText("Main"), withText("Главная")));
        clickTitleMenu2.check(matches(isDisplayed()));
        clickTitleMenu2.perform(click());
        Thread.sleep(2000);

        ViewInteraction recyclerClaims = onView(
                allOf(withId(R.id.claim_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_claims_cards_block_constraint_layout),
                                4)));
        recyclerClaims.check(matches(isDisplayed()));
        recyclerClaims.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        imageButton.perform(scrollTo());
        imageButton.check(matches(isDisplayed()));


        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());

        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }

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
