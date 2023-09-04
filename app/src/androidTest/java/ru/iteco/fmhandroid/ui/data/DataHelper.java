package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.github.javafaker.Faker;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Locale;

import ru.iteco.fmhandroid.R;

public class DataHelper {

    Faker faker = new Faker();

    public void logIn() {

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

    }

    public static ViewAction clickChildViewWithIdStep(final int id) {

        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }

    //Установка в календарь года, месяца и дня.
    public void changeЕheYearMonthOfTheDay(int year, int monthOfYear, int dayOfMonth) {
        onView(withClassName(Matchers
                .equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
    }

    //Установка в календарь года, месяца и дня случайными значениями.
    public void changeRandomЕheYearMonthOfTheDayFaker() {
        int year = faker.number().numberBetween(2025, 2035);
        int monthOfYear = faker.number().numberBetween(1, 12);
        int dayOfMonth = faker.number().numberBetween(1, 28);
        onView(withClassName(Matchers
                .equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
    }

    //Установка времени.
    public void changeTimes(int hours, int minutes) {
        onView(withClassName(Matchers
                .equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(hours, minutes));
    }

    //Установка случайного времени.
    public void changeRandomTimes() {
        int hours = faker.number().numberBetween(0, 23);
        int minutes = faker.number().numberBetween(0, 59);
        onView(withClassName(Matchers
                .equalTo(TimePicker.class.getName())))
                .perform(PickerActions.setTime(hours, minutes));
    }

//    public void buttonDeleteNews() {
//        onView(allOf(withId(R.id.delete_news_item_image_view),
//                isDescendantOfA(allOf(withId(R.id.news_item_material_card_view),
//                        hasDescendant(allOf(withId(R.id.news_item_title_text_view), withText("Test button delete news"))))))).perform(click());
//    }

    //Выбор кнопки удаления сообщения.
    public void buttonDeleteExperiment() {
        onView(withId(R.id.news_list_recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, DataHelper.clickChildViewWithIdStep(R.id.delete_news_item_image_view)));
    }

    //Выбор кнопки редактирование сообщения.
    public void clickEditNews() {
        onView(withId(R.id.news_list_recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, DataHelper.clickChildViewWithIdStep(R.id.edit_news_item_image_view)));
    }

    //Ввод в поле Логин случайных символов на латинице.
    public void loginEditTextRandomLatinTextFaker() {
        String loginTextLatin = faker.name().firstName();
        ViewInteraction textInputEditTextLatin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextLatin.check(matches(isDisplayed()));
        textInputEditTextLatin.perform(typeText(loginTextLatin), closeSoftKeyboard());
        textInputEditTextLatin.check(matches(withText(loginTextLatin)));
    }


    //Ввод в поле Логин случайных цифр.
    public void loginEditTextRandomNumberFaker() {
        int loginNumber = faker.number().numberBetween(1000, 1000000);
        String loginNumberString = String.valueOf(loginNumber);
        ViewInteraction textInputEditTextNumber = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextNumber.check(matches(isDisplayed()));
        textInputEditTextNumber.perform(typeText(loginNumberString), closeSoftKeyboard());
        textInputEditTextNumber.check(matches(withText(loginNumberString)));
    }

    //Ввод в поле Логин символов на кириллице.
    public void loginEditTextRandomCyrillicFaker() {
        Faker faker = new Faker(new Locale("Ru"));
        String loginTextCyrillic = faker.name().firstName();
        ViewInteraction editTextCyrillic = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        editTextCyrillic.check(matches(isDisplayed()));
        editTextCyrillic.perform(replaceText(loginTextCyrillic), closeSoftKeyboard());
        editTextCyrillic.check(matches(withText(loginTextCyrillic)));
    }

    //Ввод в поле Пароль случайных символов на латинице.
    public void passwordEditTextRandomLatinFaker() {
        String passwordTextLatin = faker.name().firstName();
        ViewInteraction textInputEditTextLatin = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextLatin.check(matches(isDisplayed()));
        textInputEditTextLatin.perform(typeText(passwordTextLatin), closeSoftKeyboard());
        textInputEditTextLatin.check(matches(withText(passwordTextLatin)));
    }

    //Ввод в поле Пароль случайных цифр.
    public void passwordEditTextRandomNumberFaker() {
        int passwordNumber = faker.number().numberBetween(1000, 1000000);
        String passwordNumberString = String.valueOf(passwordNumber);
        ViewInteraction textInputEditTextNumber = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextNumber.check(matches(isDisplayed()));
        textInputEditTextNumber.perform(typeText(passwordNumberString), closeSoftKeyboard());
        textInputEditTextNumber.check(matches(withText(passwordNumberString)));
    }

    //Ввод в поле Пароль случайных символов на кириллице.
    public void passwordEditTextCyrillicFaker() {
        Faker faker = new Faker(new Locale("Ru"));
        String passwordTextCyrillic = faker.name().firstName();
        ViewInteraction editTextCyrillic = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        editTextCyrillic.check(matches(isDisplayed()));
        editTextCyrillic.perform(replaceText(passwordTextCyrillic), closeSoftKeyboard());
        editTextCyrillic.check(matches(withText(passwordTextCyrillic)));
    }

    //Ввод в поле Пароль случайных специальных символов.
    public void loginEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());
        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
    }

    public void passwordEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());
        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
    }

    //Ввод в поле логин символы на латинице, цифр и специальных символов.
    public void loginEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());
        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
    }

    //Ввод в поле пароль символы на латинице, специальные символы и цифры.
    public void passwordEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());
        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
    }

    //Поле логин и пароль пустые
    public void loginAndPasswordTestEmpty() {
        ViewInteraction testIncorrectLoginEmpty = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        testIncorrectLoginEmpty.check(matches(isDisplayed()));
        testIncorrectLoginEmpty.perform(typeText(""), closeSoftKeyboard());
        testIncorrectLoginEmpty.check(matches(withText("")));

        ViewInteraction testIncorrectPasswordEmpty = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        testIncorrectPasswordEmpty.check(matches(isDisplayed()));
        testIncorrectPasswordEmpty.perform(typeText(""), closeSoftKeyboard());
        testIncorrectPasswordEmpty.check(matches(withText("")));
    }

}
