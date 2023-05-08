package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 23

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
public class News_CheckingControlPanel_CreatingNews {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_CheckingControlPanel_CreatingNews() throws InterruptedException {
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

        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.check(matches(isDisplayed()));
        clickEditNews.perform(click());

        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.check(matches(isDisplayed()));
        clickAddNews.perform(click());

        ViewInteraction сheckInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        сheckInputTitle.check(matches(isDisplayed()));
        сheckInputTitle.perform(replaceText("TitleTEST:1234567890!@#$%&*()31"), closeSoftKeyboard());
        сheckInputTitle.check(matches(withText("TitleTEST:1234567890!@#$%&*()31")));
        сheckInputTitle.perform(clearText());
        Thread.sleep(2000);

//Перемещение по категории.
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
        Thread.sleep(2000);


        ViewInteraction сheckInputTitle2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        сheckInputTitle.check(matches(isDisplayed()));
        сheckInputTitle2.check(matches(withText("Нужна помощь")));

        ViewInteraction checkPublicationDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        checkPublicationDate.perform(replaceText("01.09.2023"));
        checkPublicationDate.check(matches(withText("01.09.2023")));

        ViewInteraction checkPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        checkPublishTime.perform(replaceText("15:00"));
        checkPublishTime.check(matches(withText("15:00")));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(typeText("Description:12345678910!@#$%^&*(~)36"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description:12345678910!@#$%^&*(~)36")));
        Thread.sleep(2000);

        ViewInteraction clickSaveCreatingNews = onView(
                allOf(withId(R.id.save_button)));
        clickSaveCreatingNews.check(matches(isDisplayed()));
        clickSaveCreatingNews.perform(scrollTo(), click());

        ViewInteraction clickAddNews1 = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews1.check(matches(isDisplayed()));
        clickAddNews1.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickCancelCreatingNews1 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelCreatingNews1.check(matches(isDisplayed()));
        clickCancelCreatingNews1.perform(scrollTo(), click());
        Thread.sleep(3000);

        ViewInteraction clickCancelText = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelText.perform(scrollTo(), click());

        Thread.sleep(2000);
        ViewInteraction clickCancelCreatingNews2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelCreatingNews2.check(matches(isDisplayed()));
        clickCancelCreatingNews2.perform(scrollTo(), click());

        ViewInteraction textCheck = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        textCheck.check(matches(isDisplayed()));
        Thread.sleep(2000);

        ViewInteraction clickOkText = onView(
                allOf(withId(android.R.id.button1)));
        clickOkText.check(matches(isDisplayed()));
        clickOkText.perform(scrollTo(), click());


        ViewInteraction checkViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkViewControlPanel.check(matches(isDisplayed()));
        Thread.sleep(2000);

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

