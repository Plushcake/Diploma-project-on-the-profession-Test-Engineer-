package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 25

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
public class News_CheckingControlPanel_MessageSection_EditingNews {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_CheckingControlPanel_MessageSection_EditingNews() throws InterruptedException {
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


        ViewInteraction clickEditingNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditingNews.perform(click());

        ViewInteraction clickEditNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickEditNewsListStep.check(matches(isDisplayed()));
        clickEditNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        Thread.sleep(1000);
        clickEditNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));


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
        Thread.sleep(3000);


        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click(), clearText());
        textInputTitle.perform(typeText("TitleTest:1234567890!@#$%^&*(-+)"), closeSoftKeyboard());
        textInputTitle.check(matches(withText("TitleTest:1234567890!@#$%^&*(-+)")));


        ViewInteraction textInputPublicationDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        textInputPublicationDate.check(matches(isDisplayed()));
        textInputPublicationDate.perform(replaceText("01.09.2023"));

        Thread.sleep(1000);

        ViewInteraction textInputTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        textInputTime.check(matches(isDisplayed()));
        textInputTime.perform(replaceText("12:00"));

        Thread.sleep(1000);

        ViewInteraction textInputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        textInputDescription.check(matches(isDisplayed()));
        textInputDescription.perform(click(), clearText());
        textInputDescription.perform(typeText("DescriptionTest:\"\"_1234567890!@#$%^&*(=-_+)"), closeSoftKeyboard());

        Thread.sleep(2000);


        ViewInteraction clickSwitchActiveOff = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOff.check(matches(isDisplayed()));
        clickSwitchActiveOff.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickSwitchActiveOn = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOn.check(matches(isDisplayed()));
        clickSwitchActiveOn.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickSaveEditing = onView(
                allOf(withId(R.id.save_button)));
        clickSaveEditing.check(matches(isDisplayed()));
        clickSaveEditing.perform(click());


        Thread.sleep(2000);

        ViewInteraction clickEditNewsListStep2 = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickEditNewsListStep2.check(matches(isDisplayed()));
        clickEditNewsListStep2.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        Thread.sleep(1000);
        clickEditNewsListStep2.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

        ViewInteraction clickCancelEditing = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelEditing.check(matches(isDisplayed()));
        clickCancelEditing.perform(scrollTo(), click());

        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.check(matches(isDisplayed()));
        clickCancelMessage.perform(scrollTo(), click());

        ViewInteraction clickCancelEditing2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelEditing2.check(matches(isDisplayed()));
        clickCancelEditing2.perform(scrollTo(), click());

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickOkMessage = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessage.check(matches(isDisplayed()));
        clickOkMessage.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickDeleteListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickDeleteListStep.check(matches(isDisplayed()));
        clickDeleteListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        Thread.sleep(1000);
        clickDeleteListStep.perform(pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

        ViewInteraction checkMessageDelete = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        checkMessageDelete.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickOkMessageDelete = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessageDelete.check(matches(isDisplayed()));
        clickOkMessageDelete.perform(scrollTo(), click());

        Thread.sleep(3000);

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
