package ru.iteco.fmhandroid.ui.claimsTest;

//Пункт в тест кейсе № 9

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.FilterSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsFilteringTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            new VerificationPage().checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            new LogOutSteps().logOut();
        }
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("Проверяем фильтрацию сообщений.")
    @Description("Проверяем работоспособность каждого пункта.")
    public void claimsFilteringCheck() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new FilterSteps().buttonFilter();
        new FilterSteps().filterOpen();
        new FilterSteps().filterProgress();
        new FilterSteps().buttonOk();

//        ViewInteraction checkButtonRefresh = onView(
//                allOf(withId(R.id.claim_retry_material_button),
//                        withParent(allOf(withId(R.id.all_claims_cards_block_constraint_layout),
//                                withParent(withId(R.id.container_list_claim_include))))));
//        checkButtonRefresh.check(matches(isDisplayed()));

        new FilterSteps().buttonFilter();
        new FilterSteps().filterOpen();
        new FilterSteps().filterProgress();
        new FilterSteps().filterExecuted();
        new FilterSteps().filterCancelled();
        new FilterSteps().buttonOk();
        new FilterSteps().buttonFilter();
        new VerificationPage().checkButtonCancelInFilter();
        new FilterSteps().buttonCancel();
        new LogOutSteps().logOut();
    }

}
