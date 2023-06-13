package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 23

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelCreatingNewsFilledFieldsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка полей в разделе Creating News")
    @Description("Проверяем поля на работоспособность и ввод валидных значений.")
    public void newsCheckingControlPanelCreatingNews() throws InterruptedException {
        new LogInSteps().logIn();
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
        сheckInputTitle.perform(typeText("TitleTEST:1234567890!@#$%&*()31"), closeSoftKeyboard());
        сheckInputTitle.check(matches(withText("TitleTEST:1234567890!@#$%&*()31")));
        сheckInputTitle.perform(clearText());
        Thread.sleep(2000);

        ViewInteraction checkInputTitle1 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));

        ViewInteraction clickCategory1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory1.check(matches(isDisplayed()));
        clickCategory1.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory1 =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory1.check(matches(withText("Объявление")));


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
        clickSaveCreatingNews.perform(scrollTo());
        clickSaveCreatingNews.check(matches(isDisplayed()));
        clickSaveCreatingNews.perform(click());

        Thread.sleep(2000);

        new LogOutSteps().logOut();

    }

}

