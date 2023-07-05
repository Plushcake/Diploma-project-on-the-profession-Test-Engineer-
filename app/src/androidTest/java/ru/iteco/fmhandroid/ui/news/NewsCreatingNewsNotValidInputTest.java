package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 26

import static androidx.test.espresso.Espresso.pressBack;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreatingNewsNotValidInputTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка раздела Creating News, ввод не валидных значений")
    @Description("Ввод не валидных значений в поля")
    public void newsCreatingNewsNotValidInput() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new ButtonNewsSteps().buttonAddNews();
        new ButtonNewsSteps().buttonSaveNews();
        new InputNewNewsSteps().inputCreatingNewsComplexNotValid();
        pressBack();
        new LogOutSteps().logOut();

    }

}
