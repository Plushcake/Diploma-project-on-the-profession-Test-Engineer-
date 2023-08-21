package ru.iteco.fmhandroid.ui.newsTest;
//Пункт в тест кейсе № 25


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

public class NewsCheckingControlPanelMessageSectionEditingNewsDeleteMessageTest {
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
    @DisplayName("Проверка кнопки cancel удаление сообщения")
    @Description("Проверка кнопки Cancel в разделе Editing News. Удаление сообщения.")
    public void DeleteMessage() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new DataHelper().clickEditNews();
        new ButtonNewsSteps().buttonCancelNews();
        new ButtonNewsSteps().buttonCancelAlert();
        new ButtonNewsSteps().buttonCancelNews();
        new VerificationPage().checkTextAlertLogOut();
        new ButtonNewsSteps().buttonOkAlert();
        new DataHelper().buttonDeleteExperiment();
        new VerificationPage().checkTextAlertDeleteTheDocument();
        new ButtonNewsSteps().buttonCancelAlert();
        new DataHelper().buttonDeleteExperiment();
        new VerificationPage().checkTextAlertDeleteTheDocument();
        new ButtonNewsSteps().buttonOkAlert();
        new LogOutSteps().logOut();
    }


}
