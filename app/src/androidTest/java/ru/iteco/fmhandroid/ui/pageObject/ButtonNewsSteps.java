package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ButtonNewsSteps {

    //Кнопка перехода в раздел Control Panel.
    public void buttonEditNews() {
        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.check(matches(isDisplayed()));
        clickEditNews.perform(click());
    }

    //Копка перехода в раздел Creating News.
    public void buttonAddNews() {
        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.check(matches(isDisplayed()));
        clickAddNews.perform(click());
    }

    //Кнопка сохранения
    public void buttonSaveNews() {
        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(click());
    }

    //Кнопка отмены
    public void buttonCancelNews() {
        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(click());
    }

    //Кнопка сохранения в сообщении с предупреждением.
    public void buttonOkAlert() {
        ViewInteraction clickOkAlert = onView(
                allOf(withId(android.R.id.button1)));
        clickOkAlert.check(matches(isDisplayed()));
        clickOkAlert.perform(scrollTo(), click());

    }

    //Кнопка отмена в сообщении с предупреждением.
    public void buttonCancelAlert() {
        ViewInteraction clickCancelAlert = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelAlert.check(matches(isDisplayed()));
        clickCancelAlert.perform(scrollTo(), click());
    }

    //Кнопка сортирования сообщений по дате добавления.
    public void buttonSortNews() {
        ViewInteraction clickSortNews = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSortNews.check(matches(isDisplayed()));
        clickSortNews.perform(click());
    }

    //Кнопка фильтра сообщений.
    public void buttonFilterNews() {
        ViewInteraction clickFilterNews = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews.check(matches(isDisplayed()));
        clickFilterNews.perform(click());
    }

    //Кнопка Filter Button в разделе Фильтр Новостей.
    public void filterButton() {
        ViewInteraction clickFilterButton = onView(
                allOf(withId(R.id.filter_button)));
        clickFilterButton.check(matches(isDisplayed()));
        clickFilterButton.perform(click());
    }

    //Чек бокс Active. В разделе Фильтр Новостей.
    public void checkBoxFilterNewsActive() {
        ViewInteraction materialCheckBoxActive = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive.check(matches(isDisplayed()));
        materialCheckBoxActive.perform(click());
    }

    //Чек бокс Not active. В разделе Фильтр Новостей.
    public void checkBoxFilterNewsInactive() {
        ViewInteraction materialCheckBoxNotActive = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive.check(matches(isDisplayed()));
        materialCheckBoxNotActive.perform(click());
    }

    //Переключение ползунка Active в разделе Create Edit.
    public void switchActive() {
        ViewInteraction clickSwitch = onView(
                allOf(withId(R.id.switcher)));
        clickSwitch.check(matches(isDisplayed()));
        clickSwitch.perform(click());
    }

    //Выбор сообщения из списка. В разделе News.
    public void recyclerViewNews() {
        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));
    }
}
