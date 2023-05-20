package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 20

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class News_CheckingFilterNews {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка раздела Filter News")
    @Description("Проверка полей на работоспособность")
    public void news_CheckingFilterNews() throws InterruptedException {
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

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickFilterNews1 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews1.check(matches(isDisplayed()));
        clickFilterNews1.perform(click());

        ViewInteraction checkTextView = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkTextView.check(matches(isDisplayed()));

        ViewInteraction checkViewCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        checkViewCategory.check(matches(isDisplayed()));

        //Перемещение по категории.

        ViewInteraction clickCategory_1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_1.check(matches(isDisplayed()));
        clickCategory_1.perform(click(), closeSoftKeyboard());

        ViewInteraction MoveThroughCategory_1 =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_1.check(matches(withText("Объявление")));
        Thread.sleep(1000);

        ViewInteraction clickCategory_2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_2.check(matches(isDisplayed()));
        clickCategory_2.perform(clearText());
        clickCategory_2.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_2 =
                onView(withText("День рождения"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_2.check(matches(withText("День рождения")));


        ViewInteraction clickCategory_3 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_3.check(matches(isDisplayed()));
        clickCategory_3.perform(clearText());
        clickCategory_3.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_3 =
                onView(withText("Зарплата"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_3.check(matches(withText("Зарплата")));


        ViewInteraction clickCategory_4 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_4.check(matches(isDisplayed()));
        clickCategory_4.perform(clearText());
        clickCategory_4.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_4 =
                onView(withText("Профсоюз"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_4.check(matches(withText("Профсоюз")));


        ViewInteraction clickCategory_5 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_5.check(matches(isDisplayed()));
        clickCategory_5.perform(clearText());
        clickCategory_5.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_5 =
                onView(withText("Праздник"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_5.check(matches(withText("Праздник")));


        ViewInteraction clickCategory_6 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_6.check(matches(isDisplayed()));
        clickCategory_6.perform(clearText());
        clickCategory_6.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_6 =
                onView(withText("Массаж"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_6.check(matches(withText("Массаж")));


        ViewInteraction clickCategory_7 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_7.check(matches(isDisplayed()));
        clickCategory_7.perform(clearText());
        clickCategory_7.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_7 =
                onView(withText("Благодарность"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_7.check(matches(withText("Благодарность")));


        ViewInteraction clickCategory_8 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_8.check(matches(isDisplayed()));
        clickCategory_8.perform(clearText());
        clickCategory_8.perform(click(), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction MoveThroughCategory_8 =
                onView(withText("Нужна помощь"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory_8.check(matches(withText("Нужна помощь")));

        Thread.sleep(2000);

        ViewInteraction inputDate1 = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        inputDate1.check(matches(isDisplayed()));
        inputDate1.perform(replaceText("01.04.2023"));

        ViewInteraction inputDate2 = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        inputDate2.check(matches(isDisplayed()));
        inputDate2.perform(replaceText("01.05.2023"));
        Thread.sleep(2000);

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filter_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());
        Thread.sleep(3000);

        ViewInteraction clickFilterNews2 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews2.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(click());


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
