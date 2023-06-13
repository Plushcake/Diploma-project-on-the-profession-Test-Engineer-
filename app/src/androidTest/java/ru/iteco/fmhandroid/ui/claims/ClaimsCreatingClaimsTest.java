package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 10

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
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
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsCreatingClaimsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Создание Claims. Заполнение полей валидными значениями. Проверка предупреждающих сообщений")
    @Description("Поля заполнены валидными значениями. Claims создается успешно.")
    public void claimsCreatingClaimsTest() throws InterruptedException {
        new LogInSteps().logIn();
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickButtonAddNewClaim1 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim1.check(matches(isDisplayed()));
        clickButtonAddNewClaim1.perform(click());

        new InputNewClaimSteps().inputNewClaim();

        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.check(matches(isDisplayed()));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusProcessing = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing.perform(scrollTo());
        clickStatusProcessing.check(matches(isDisplayed()));
        clickStatusProcessing.perform(click());

        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(click());

        ViewInteraction checkTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        checkTextCommentThrowOff.check(matches(isDisplayed()));
        checkTextCommentThrowOff.perform(typeText("Trow_Off_Test"));

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickStatusButton2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton2.perform(scrollTo());
        clickStatusButton2.perform(click());

        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.perform(click());

        ViewInteraction clickButtonBack2 = onView(
                allOf(withId(R.id.close_image_button)));
        clickButtonBack2.perform(scrollTo());
        clickButtonBack2.check(matches(isDisplayed()));
        clickButtonBack2.perform(click());


        ViewInteraction clickButtonAddNewClaim2 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim2.check(matches(isDisplayed()));
        clickButtonAddNewClaim2.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));

        ViewInteraction clickOk3 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk3.check(matches(isDisplayed()));
        clickOk3.perform(scrollTo(), click());

        ViewInteraction checkTextClaims2 = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        checkTextClaims2.check(matches(isDisplayed()));

        ViewInteraction clickButtonAddNewClaim3 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim3.check(matches(isDisplayed()));
        clickButtonAddNewClaim3.perform(click());

        ViewInteraction clickCancel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickCancel3 = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel3.check(matches(isDisplayed()));
        clickCancel3.perform(scrollTo(), click());


        ViewInteraction clickCancel4 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel4.check(matches(isDisplayed()));
        clickCancel4.perform(scrollTo(), click());

        Thread.sleep(2000);

        ViewInteraction clickOk4 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk4.check(matches(isDisplayed()));
        clickOk4.perform(scrollTo(), click());

        Thread.sleep(2000);

        new LogOutSteps().logOut();

    }

}
