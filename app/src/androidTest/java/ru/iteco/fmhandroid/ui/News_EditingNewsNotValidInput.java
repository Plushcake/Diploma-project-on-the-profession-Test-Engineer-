package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
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
public class News_EditingNewsNotValidInput {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_EditingNewsNotValidInput() throws InterruptedException {
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
        clickEditNews.perform(click());

        ViewInteraction clickEditNewsItem = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickEditNewsItem.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(66));

        Thread.sleep(2000);

        ViewInteraction inputCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory.perform(clearText());
        inputCategory.perform(replaceText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputCategory.check(matches(withText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction inputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle.perform(clearText());
        inputTitle.perform(typeText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputTitle.check(matches(withText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101")));


        ViewInteraction inputPublishDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate.perform(clearText());
        inputPublishDate.perform(replaceText("01.01.1990"));


        ViewInteraction inputPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime.perform(clearText());
        inputPublishTime.perform(replaceText("16:00"));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.perform(clearText());
        inputDescription.perform(scrollTo());
        inputDescription.perform(typeText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(click());

        ViewInteraction textCheckEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing.check(matches(isDisplayed()));


        Thread.sleep(4000);


        ViewInteraction inputCategory1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory1.perform(scrollTo());
        inputCategory1.perform(clearText());
        inputCategory1.perform(typeText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputCategory1.check(matches(withText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction clickSave1 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1.perform(click());

        ViewInteraction textCheckEditing1 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing1.check(matches(isDisplayed()));
        Thread.sleep(2000);
        inputCategory1.perform(clearText());


        ViewInteraction inputTitle2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle2.perform(clearText());
        inputTitle2.perform(typeText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputTitle2.check(matches(withText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction clickSave2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave2.perform(click());

        ViewInteraction textCheckEditing2 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing2.check(matches(isDisplayed()));
        Thread.sleep(2000);
        inputTitle2.perform(clearText());

        Thread.sleep(2000);

        ViewInteraction inputPublishDate1 = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate1.perform(clearText());
        inputPublishDate1.perform(replaceText("02.02.1992"));

        ViewInteraction clickSave1_1 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1_1.perform(click());

        ViewInteraction textCheckEditing1_1 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing1_1.check(matches(isDisplayed()));
        Thread.sleep(2000);
        inputPublishDate1.perform(clearText());


        ViewInteraction inputPublishTime1_2 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime1_2.perform(clearText());
        inputPublishTime1_2.perform(replaceText("18:30"));

        ViewInteraction clickSave1_2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1_2.perform(click());

        ViewInteraction textCheckEditing1_2 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing1_2.check(matches(isDisplayed()));
        Thread.sleep(2000);
        inputPublishTime1_2.perform(clearText());

        ViewInteraction inputDescription3 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription3.perform(clearText());
        inputDescription3.perform(typeText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputDescription3.check(matches(withText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction clickSave3 = onView(
                allOf(withId(R.id.save_button)));
        clickSave3.perform(click());

        ViewInteraction textCheckEditing3 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing3.check(matches(isDisplayed()));
        Thread.sleep(2000);
        inputDescription3.perform(clearText());

        Thread.sleep(3000);
        ViewInteraction clickSave4 = onView(
                allOf(withId(R.id.save_button)));
        clickSave4.perform(click());

        ViewInteraction textCheckEditing4 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing4.check(matches(isDisplayed()));
        Thread.sleep(3000);

        pressBack();

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
