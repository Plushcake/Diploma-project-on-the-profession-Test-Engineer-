package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

//Переход в меню выбора раздела. (Раздел Main).
public class GoToMainMenuSteps {

    public void goToClaims() {
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
    }

    public void goToNews() {
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
    }

    public void goToAbout() {
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickAbout = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAbout.check(matches(isDisplayed()));
        clickAbout.perform(click());
    }

    public void goToMain() {
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickMain = onView(
                anyOf(withText("Main"), withText("Главная")));
        clickMain.check(matches(isDisplayed()));
        clickMain.perform(click());

    }

    public void clickButtonMainMenu() {
        ViewInteraction mainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        mainMenu.check(matches(isDisplayed()));
        mainMenu.perform(click());
    }
}
