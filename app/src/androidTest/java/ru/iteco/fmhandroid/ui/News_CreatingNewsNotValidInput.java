package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class News_CreatingNewsNotValidInput {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_CreatingNewsNotValidInput() throws InterruptedException {
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
        Thread.sleep(1000);

        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.perform(click());

        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.perform(click());

        Thread.sleep(1000);


        ViewInteraction clickSaveEmptyField = onView(
                allOf(withId(R.id.save_button)));
        clickSaveEmptyField.check(matches(isDisplayed()));
        clickSaveEmptyField.perform(scrollTo(), click());

        ViewInteraction checkTextCreating1 = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating1.check(matches(isDisplayed()));

        Thread.sleep(3000);

        ViewInteraction inputCategory2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory2.perform(typeText("Category_//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputCategory2.check(matches(withText("Category_//010101010101010101010101010101010100101010100101010101010101010101")));

        ViewInteraction clickSave1 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1.check(matches(isDisplayed()));
        clickSave1.perform(scrollTo(), click());

        ViewInteraction checkTextCreating = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating.check(matches(isDisplayed()));

        Thread.sleep(2000);
        inputCategory2.perform(clearText());

        ViewInteraction inputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle.perform(typeText("Title//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputTitle.check(matches(withText("Title//010101010101010101010101010101010100101010100101010101010101010101")));

        ViewInteraction clickSave2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave2.check(matches(isDisplayed()));
        clickSave2.perform(scrollTo(), click());

        ViewInteraction checkTextCreating3 = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating3.check(matches(isDisplayed()));


        Thread.sleep(3000);
        inputTitle.perform(clearText());

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.perform(typeText("Description//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description//010101010101010101010101010101010100101010100101010101010101010101")));

        ViewInteraction clickSave3 = onView(
                allOf(withId(R.id.save_button)));
        clickSave3.check(matches(isDisplayed()));
        clickSave3.perform(scrollTo(), click());

        ViewInteraction checkTextCreating4 = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating4.check(matches(isDisplayed()));

        Thread.sleep(3000);
        inputDescription.perform(clearText());

        ViewInteraction inputPublishDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate.perform(replaceText("11.11.2011"));

        ViewInteraction inputPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime.perform(replaceText("15:00"));

        ViewInteraction clickSave4 = onView(
                allOf(withId(R.id.save_button)));
        clickSave4.check(matches(isDisplayed()));
        clickSave4.perform(scrollTo(), click());

        ViewInteraction checkTextCreating5 = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating5.check(matches(isDisplayed()));

        Thread.sleep(3000);

        ViewInteraction inputCategoryFull = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategoryFull.perform(replaceText("Category_Категория//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputCategoryFull.check(matches(withText("Category_Категория//010101010101010101010101010101010100101010100101010101010101010101")));

        Thread.sleep(1000);

        ViewInteraction inputTitleFull = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitleFull.perform(typeText("Title//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputTitleFull.check(matches(withText("Title//010101010101010101010101010101010100101010100101010101010101010101")));

        Thread.sleep(2000);

        ViewInteraction inputDescriptionFull = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescriptionFull.perform(typeText("Description//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputDescriptionFull.check(matches(withText("Description//010101010101010101010101010101010100101010100101010101010101010101")));

        Thread.sleep(2000);

        ViewInteraction inputPublishDateFull = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDateFull.perform(replaceText("11.11.2011"));

        Thread.sleep(1000);

        ViewInteraction inputPublishTimeFull = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTimeFull.perform(replaceText("15:00"));

        Thread.sleep(1000);

        ViewInteraction clickSaveFull = onView(
                allOf(withId(R.id.save_button)));
        clickSaveFull.check(matches(isDisplayed()));
        clickSaveFull.perform(scrollTo(), click());

        ViewInteraction checkTextCreatingFull = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreatingFull.check(matches(isDisplayed()));

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
