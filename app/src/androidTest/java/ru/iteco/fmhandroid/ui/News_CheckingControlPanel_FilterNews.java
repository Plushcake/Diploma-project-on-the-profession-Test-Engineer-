package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 22

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class News_CheckingControlPanel_FilterNews {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_ControlPanel_FilterNews() throws InterruptedException {
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

        ViewInteraction clickControlPanel = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickControlPanel.check(matches(isDisplayed()));
        clickControlPanel.perform(click());

        ViewInteraction clickSort1 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSort1.check(matches(isDisplayed()));
        clickSort1.perform(click());

        ViewInteraction clickSort2 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSort2.check(matches(isDisplayed()));
        clickSort2.perform(click());

        ViewInteraction clickFilterNews = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews.check(matches(isDisplayed()));
        clickFilterNews.perform(click());

        ViewInteraction inputCategory_1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_1.perform(click());
        Thread.sleep(1000);
        inputCategory_1.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_1.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_2.perform(click());
        Thread.sleep(1000);
        inputCategory_2.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_2.perform(pressKey(20));
        inputCategory_2.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_3 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_3.perform(click());
        Thread.sleep(1000);
        inputCategory_3.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_3.perform(pressKey(20), pressKey(20));
        inputCategory_3.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_4 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_4.perform(click());
        Thread.sleep(1000);
        inputCategory_4.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_4.perform(pressKey(20), pressKey(20), pressKey(20));
        inputCategory_4.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_5 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_5.perform(click());
        Thread.sleep(1000);
        inputCategory_5.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_5.perform(pressKey(20), pressKey(20), pressKey(20), pressKey(20));
        inputCategory_5.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_6 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_6.perform(click());
        Thread.sleep(1000);
        inputCategory_6.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_6.perform(pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20));
        inputCategory_6.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_7 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_7.perform(click());
        Thread.sleep(1000);
        inputCategory_7.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_7.perform(pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20));
        inputCategory_7.perform(pressKey(66));
        Thread.sleep(1000);
        ViewInteraction inputCategory_8 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_8.perform(click());
        Thread.sleep(1000);
        inputCategory_8.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_8.perform(pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20), pressKey(20));
        inputCategory_8.perform(pressKey(66), closeSoftKeyboard());
        Thread.sleep(1000);
        ViewInteraction inputCategory_1_1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory_1_1.perform(click());
        Thread.sleep(1000);
        inputCategory_1_1.perform(pressKey(20), pressKey(19), pressKey(19));
        inputCategory_1_1.perform(pressKey(66), closeSoftKeyboard());
        Thread.sleep(3000);


        ViewInteraction clickData1 = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        clickData1.perform(replaceText("01.04.2023"));
        Thread.sleep(1000);

        ViewInteraction clickData2 = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        clickData2.perform(replaceText("01.05.2023"));
        Thread.sleep(2000);

        ViewInteraction materialCheckBoxActive = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive.check(matches(isDisplayed()));
        materialCheckBoxActive.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxActive2 = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive2.check(matches(isDisplayed()));
        materialCheckBoxActive2.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxNotActive = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive.check(matches(isDisplayed()));
        materialCheckBoxNotActive.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxNotActive2 = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive2.check(matches(isDisplayed()));
        materialCheckBoxNotActive2.perform(click());

        Thread.sleep(1000);

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filter_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickFilterNews2 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews2.check(matches(isDisplayed()));
        clickFilterNews2.perform(click());

        Thread.sleep(2000);

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.perform(click());

        ViewInteraction checkControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkControlPanel.check(matches(isDisplayed()));

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
