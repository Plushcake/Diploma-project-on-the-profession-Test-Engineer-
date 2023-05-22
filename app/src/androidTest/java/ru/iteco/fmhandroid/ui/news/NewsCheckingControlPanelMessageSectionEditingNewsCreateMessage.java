package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 25

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.ClickEditNewsListStep;
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelMessageSectionEditingNewsCreateMessage {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка полей в разделе Editing News")
    @Description("Вводим в поля валидные значения")
    public void CreateMessage() throws InterruptedException {
        new LogIn().logIn();
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

        new ClickEditNewsListStep().clickEditNewsListStep();

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

        ViewInteraction moveThroughCategory =
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
        textInputDescription.perform(replaceText("DescriptionTest:<Тест>_1234567890!@#$%^&*(=-_+)"), closeSoftKeyboard());
        textInputDescription.check(matches(withText("DescriptionTest:<Тест>_1234567890!@#$%^&*(=-_+)")));

        Thread.sleep(2000);

        ViewInteraction checkActive = onView(
                anyOf(withText("Active"), withText("Активна")));
        checkActive.check(matches(isDisplayed()));

        ViewInteraction clickSwitchActiveOff = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOff.check(matches(isDisplayed()));
        clickSwitchActiveOff.perform(click());

        Thread.sleep(1000);

        ViewInteraction checkNotActive2 = onView(
                anyOf(withText("Not active"), withText("Не активна")));
        checkNotActive2.check(matches(isDisplayed()));

        ViewInteraction clickSwitchActiveOn = onView(
                allOf(withId(R.id.switcher)));
        clickSwitchActiveOn.check(matches(isDisplayed()));
        clickSwitchActiveOn.perform(click());

        ViewInteraction checkActive3 = onView(
                anyOf(withText("Active"), withText("Активна")));
        checkActive3.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction clickSaveEditing = onView(
                allOf(withId(R.id.save_button)));
        clickSaveEditing.check(matches(isDisplayed()));
        clickSaveEditing.perform(click());

        new LogOut().logOut();

    }

}
