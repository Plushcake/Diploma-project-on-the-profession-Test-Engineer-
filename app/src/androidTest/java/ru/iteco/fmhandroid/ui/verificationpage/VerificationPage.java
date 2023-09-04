package ru.iteco.fmhandroid.ui.verificationpage;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class VerificationPage {

    //Проверка предупреждающих сообщений.
    public void checkTextAlertLogOut() {
        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));
    }

    public void checkTextAlertDeleteTheDocument() {
        ViewInteraction textViewCheck = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textViewCheck.check(matches(isDisplayed()));
    }


    //Проверка по тексту.
    public void checkViewTextAuthorization() {
        ViewInteraction checkTextAuthorization = onView(
                anyOf(withText("Authorization"), withText("Авторизация")));
        checkTextAuthorization.check(matches(isCompletelyDisplayed()));

    }

    public void checkViewLogin() {
        ViewInteraction checkTextHintLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        checkTextHintLogin.check(matches(isDisplayed()));
    }

    public void checkViewPassword() {
        ViewInteraction checkTextHintPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        checkTextHintPassword.check(matches(isDisplayed()));
    }

    public void checkTextSignIn() {
        ViewInteraction checkTextButtonSignIn = onView(
                anyOf(withText("Sign in"), withText("Войти")));
        checkTextButtonSignIn.check(matches(isDisplayed()));
    }

    public void checkTextCreatingClaims() {
        ViewInteraction checkTextClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        checkTextClaims.check(matches(isDisplayed()));
    }

    public void checkTextControlPanel() {
        ViewInteraction checkViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkViewControlPanel.check(matches(isDisplayed()));
    }

    public void checkTextFilterNews() {
        ViewInteraction checkText = onView(
                anyOf(withText("Filter news"), withText("Фильтровать новости")));
        checkText.check(matches(isDisplayed()));

    }

    public void checkTextNews() {
        ViewInteraction checkTextNews = onView(
                anyOf(withText("News"), withText("Новости")));
        checkTextNews.check(matches(isDisplayed()));
    }

    public void checkTextCreating() {
        ViewInteraction checkText = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkText.check(matches(isDisplayed()));
        checkText.perform(click());
    }

    public void checkTextFilteringInFilter() {
        ViewInteraction checkTextFiltering = onView(
                anyOf(withText("Filtering"), withText("Фильтрация")));
        checkTextFiltering.check(matches(isDisplayed()));
    }

    public void checkTextEditing() {
        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));
    }

    public void checkTextSwitchNotActive() {
        ViewInteraction checkNotActive = onView(
                anyOf(withText("Not active"), withText("Не активна")));
        checkNotActive.check(matches(isDisplayed()));
    }

    public void checkTextSwitchActive() {
        ViewInteraction checkActive = onView(
                anyOf(withText("Active"), withText("Активна")));
        checkActive.check(matches(isDisplayed()));
    }

    public void checkTextLoveIsAll() {
        ViewInteraction checkTextLoveIsAll = onView(
                anyOf(withText("Love is all"), withText("Главное - жить любя")));
        checkTextLoveIsAll.check(matches(isDisplayed()));
    }


    //Проверка по ID.
    public void checkContainerListNews() {
        ViewInteraction textViewNews = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        textViewNews.check(matches(isDisplayed()));
        textViewNews.check(matches(withId(R.id.container_list_news_include_on_fragment_main)));
    }

    public void checkContainerInNews() {
        ViewInteraction checkNews = onView(
                allOf(withId(R.id.container_list_news_include)));
        checkNews.check(matches(isDisplayed()));
    }

    public void checkContainerInClaims() {
        ViewInteraction checkClaims = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkClaims.check(matches(isDisplayed()));

    }

    public void checkNewsListRecycler() {
        ViewInteraction checkControlPanel = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkControlPanel.check(matches(isDisplayed()));
    }

    public void checkFilterNews() {
        ViewInteraction checkFilterNews = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterNews.check(matches(isDisplayed()));
    }

    public void checkAppBar() {
        ViewInteraction checkTextCreating = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view)));
        checkTextCreating.check(matches(isDisplayed()));
    }

    public void checkOurMission() {
        ViewInteraction checkTextID = onView(
                allOf(withId(R.id.our_mission_title_text_view)));
        checkTextID.check(matches(isDisplayed()));
    }

    public void checkAboutPrivacyPolicy() {
        ViewInteraction checkAbout = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        checkAbout.check(matches(isDisplayed()));
    }


    //Проверка статуса сообщения.
    public void checkStatusInProgress() {
        ViewInteraction checkInProgress = onView(
                anyOf(withText("In progress"), withText("В работе")));
        checkInProgress.check(matches(isDisplayed()));
    }

    public void checkStatusOpen() {
        ViewInteraction checkStatusOpen = onView(
                anyOf(withText("Open"), withText("Открыта")));
        checkStatusOpen.check(matches(isDisplayed()));
    }

    public void checkStatusExecuted() {
        ViewInteraction checkStatusExecuted = onView(
                anyOf(withText("Executed"), withText("Выполнена")));
        checkStatusExecuted.check(matches(isDisplayed()));
    }

    public void checkStatusCancel() {
        ViewInteraction checkStatusCanceled = onView(
                anyOf(withText("Canceled"), withText("Отменена")));
        checkStatusCanceled.check(matches(isDisplayed()));
    }


    //Проверка кнопок.
    public void checkButtonCancelInFilter() {
        ViewInteraction checkButtonCancel = onView(
                allOf(withId(R.id.claim_filter_cancel_material_button)));
        checkButtonCancel.check(matches(isDisplayed()));
    }

    public void checkButtonStatus() {
        ViewInteraction checkButtonChangeStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        checkButtonChangeStatus.perform(scrollTo());
        checkButtonChangeStatus.check(matches(isDisplayed()));
    }

    //Проверка предупреждающего сообщения Enter a valid time. В разделе Время и Дата.
    public void checkTextAlert() {
        ViewInteraction checkTextAlert = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Enter a valid time"),
                        withParent(allOf(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))),
                        isDisplayed()));
        checkTextAlert.check(matches(withText("Enter a valid time")));
    }

    //Проверка текста. Set time. В разделе Время и Дата.
    public void checkText() {
        ViewInteraction textView = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Set time"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.TimePicker.class))),
                        isDisplayed()));
        textView.check(matches(withText("Set time")));
    }

    //Проверям ID элемента About Privacy Policy, в разделе About.
    public void idCheckAboutPrivacyPolicy() {
        ViewInteraction textCheckPrivacy = onView(
                AllOf.allOf(withId(R.id.about_privacy_policy_label_text_view)));
        textCheckPrivacy.check(matches(isDisplayed()));
    }

    //Проверям ID элемента About Terms of Use, в разделе About.
    public void idCheckAboutTermsOfUse() {
        ViewInteraction textCheckTerms = onView(
                AllOf.allOf(withId(R.id.about_terms_of_use_label_text_view)));
        textCheckTerms.check(matches(isDisplayed()));

    }
}
