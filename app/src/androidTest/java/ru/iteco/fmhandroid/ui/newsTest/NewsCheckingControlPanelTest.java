package ru.iteco.fmhandroid.ui.newsTest;

//Пункт в тест кейсе № 21

import static androidx.test.espresso.Espresso.pressBack;

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
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelTest {

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
    @DisplayName("Проверяем раздел Control Panel.")
    @Description("В разделе Control Panel проверяем переходы в подразделы")
    public void newsCheckingControlPanel() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new VerificationPage().checkNewsListRecycler();
        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonFilterNews();
        new VerificationPage().checkFilterNews();
        new ButtonNewsSteps().buttonCancelNews();
        new ButtonNewsSteps().buttonAddNews();
        new VerificationPage().checkAppBar();
        new ButtonNewsSteps().buttonCancelNews();
        new ButtonNewsSteps().buttonOkAlert();
        new ButtonNewsSteps().recyclerViewNews();
        new ButtonNewsSteps().recyclerViewNews();
        new DataHelper().buttonDeleteExperiment();
        new VerificationPage().checkTextAlertDeleteTheDocument();
        new ButtonNewsSteps().buttonCancelAlert();
        new DataHelper().clickEditNews();
        new VerificationPage().checkTextEditing();
        pressBack();
        new LogOutSteps().logOut();
    }


}
