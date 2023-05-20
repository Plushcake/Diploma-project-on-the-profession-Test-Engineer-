package ru.iteco.fmhandroid.ui;
//Пункт в тест кейсе № 25

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
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
public class News_CheckingControlPanel_MessageSection_EditingNews_CreateAndDelete {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка полей в разделе Editing News, проверка кнопки cancel удаление сообщения")
    @Description("Вводим в поля валидные значения. Проверка кнопки Cancel в разделе Editing News. Удаление сообщения.")
    public void CreateAndDelete() throws InterruptedException {
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


        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click(), clearText());
        textInputTitle.perform(typeText("TitleTest:1234567890!@#$%^&*(-+)"), closeSoftKeyboard());
        textInputTitle.check(matches(withText("TitleTest:1234567890!@#$%^&*(-+)")));
        textInputTitle.perform(click(), clearText(), closeSoftKeyboard());
        Thread.sleep(2000);

        ViewInteraction checkInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));

        ViewInteraction clickCategory_1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory_1.perform(clearText());
        clickCategory_1.check(matches(isDisplayed()));
        clickCategory_1.perform(click(), closeSoftKeyboard());

        ViewInteraction MoveThroughCategory =
                onView(withText("Благодарность"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Благодарность")));

        Thread.sleep(2000);

        ViewInteraction textInputPublicationDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        textInputPublicationDate.check(matches(isDisplayed()));
        textInputPublicationDate.perform(clearText());
        textInputPublicationDate.perform(replaceText("01.09.2023"));

        Thread.sleep(1000);

        ViewInteraction textInputTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        textInputTime.check(matches(isDisplayed()));
        textInputTime.perform(clearText());
        textInputTime.perform(replaceText("12:00"));

        Thread.sleep(1000);

        ViewInteraction textInputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        textInputDescription.check(matches(isDisplayed()));
        textInputDescription.perform(click(), clearText());
        textInputDescription.perform(typeText("DescriptionTest:<>_1234567890!@#$%^&*(=-_+)"), closeSoftKeyboard());
        textInputDescription.check(matches(withText("DescriptionTest:<>_1234567890!@#$%^&*(=-_+)")));

        Thread.sleep(2000);

        ViewInteraction checkActive = onView(
                anyOf(withText("Active"), withText("Активна")));
        checkActive.check(matches(isDisplayed()));

        ViewInteraction clickSwitchActiveOff = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOff.check(matches(isDisplayed()));
        clickSwitchActiveOff.perform(click());

        Thread.sleep(1000);

        ViewInteraction clickSwitchActiveOn = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOn.check(matches(isDisplayed()));
        clickSwitchActiveOn.perform(click());

        ViewInteraction checkNotActive = onView(
                anyOf(withText("Not active"), withText("Не активна")));
        checkNotActive.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction clickSaveEditing = onView(
                allOf(withId(R.id.save_button)));
        clickSaveEditing.check(matches(isDisplayed()));
        clickSaveEditing.perform(click());

        Thread.sleep(1000);

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());


//        Thread.sleep(2000);
//
//        ViewInteraction clickEditNewsListStep2 = onView(
//                anyOf(withText("Control panel"), withText("Панель \\n управления")));
//        clickEditNewsListStep2.check(matches(isDisplayed()));
//        clickEditNewsListStep2.perform(pressKey(61), pressKey(61), pressKey(61),
//                pressKey(61), pressKey(61), pressKey(61));
//        Thread.sleep(1000);
//        clickEditNewsListStep2.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(66));
//        Thread.sleep(2000);
//
//        ViewInteraction clickCancelEditing = onView(
//                allOf(withId(R.id.cancel_button)));
//        clickCancelEditing.check(matches(isDisplayed()));
//        clickCancelEditing.perform(scrollTo(), click());
//
//        ViewInteraction clickCancelMessage = onView(
//                allOf(withId(android.R.id.button2)));
//        clickCancelMessage.check(matches(isDisplayed()));
//        clickCancelMessage.perform(scrollTo(), click());
//
//        ViewInteraction clickCancelEditing2 = onView(
//                allOf(withId(R.id.cancel_button)));
//        clickCancelEditing2.check(matches(isDisplayed()));
//        clickCancelEditing2.perform(scrollTo(), click());
//
//        ViewInteraction checkTextMessage = onView(
//                anyOf(withText("The changes won't be saved, do you really want to log out?"),
//                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
//        checkTextMessage.check(matches(isDisplayed()));
//
//        Thread.sleep(2000);
//
//        ViewInteraction clickOkMessage = onView(
//                allOf(withId(android.R.id.button1)));
//        clickOkMessage.check(matches(isDisplayed()));
//        clickOkMessage.perform(scrollTo(), click());
//
//        Thread.sleep(1000);
//
//        ViewInteraction clickDeleteListStep = onView(
//                anyOf(withText("Control panel"), withText("Панель \\n управления")));
//        clickDeleteListStep.check(matches(isDisplayed()));
//        clickDeleteListStep.perform(pressKey(61), pressKey(61), pressKey(61),
//                pressKey(61), pressKey(61), pressKey(61));
//        Thread.sleep(1000);
//        clickDeleteListStep.perform(pressKey(61), pressKey(61), pressKey(66));
//        Thread.sleep(2000);
//
//        ViewInteraction checkMessageDelete = onView(
//                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
//                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
//        checkMessageDelete.check(matches(isDisplayed()));
//
//        Thread.sleep(2000);
//
//        ViewInteraction clickOkMessageDelete = onView(
//                allOf(withId(android.R.id.button1)));
//        clickOkMessageDelete.check(matches(isDisplayed()));
//        clickOkMessageDelete.perform(scrollTo(), click());
//
//        Thread.sleep(3000);
//
//        ViewInteraction clickAuthorization = onView(
//                allOf(withId(R.id.authorization_image_button)));
//        clickAuthorization.check(matches(isDisplayed()));
//        clickAuthorization.perform(click());
//
//
//        ViewInteraction textViewLogOutTest = onView(
//                anyOf(withText("Log out"), withText("Выйти")));
//        textViewLogOutTest.check(matches(isDisplayed()));
//        textViewLogOutTest.perform(click());
    }

}
