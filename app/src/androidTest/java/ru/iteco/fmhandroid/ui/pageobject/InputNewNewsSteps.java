package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class InputNewNewsSteps {

    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();

    public void inputNewNewsValid() {
        ViewInteraction inputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle.check(matches(isDisplayed()));
        inputTitle.perform(clearText());
        inputTitle.perform(replaceText("TitleTEST:1234567890!@#$%&*()31"), closeSoftKeyboard());
        inputTitle.check(matches(withText("TitleTEST:1234567890!@#$%&*()31")));
        inputTitle.perform(clearText());

        ViewInteraction checkInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));

        ViewInteraction clickCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory.check(matches(isDisplayed()));
        clickCategory.perform(clearText());
        clickCategory.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Объявление")));

        ViewInteraction inputPublicationDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublicationDate.perform(replaceText("01.09.2023"));
        inputPublicationDate.check(matches(withText("01.09.2023")));

        ViewInteraction inputPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime.perform(replaceText("15:00"));
        inputPublishTime.check(matches(withText("15:00")));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.check(matches(isDisplayed()));
        inputDescription.perform(clearText());
        inputDescription.perform(replaceText("Description:12345678910!@#$%^&*(~)36"), closeSoftKeyboard());//closeSoftKeyboard оставлен если будет замена на typeText.
        inputDescription.check(matches(withText("Description:12345678910!@#$%^&*(~)36")));

    }

    //Ввод валидных значений в разделе Фильтр Новостей.
    public void inputFilterValid() {
        ViewInteraction clickCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory.check(matches(isDisplayed()));
        clickCategory.perform(clearText());
        clickCategory.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory.check(matches(withText("Объявление")));

        ViewInteraction inputDataLeft = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        inputDataLeft.perform(replaceText("01.04.2023"));
        inputDataLeft.check(matches(withText("01.04.2023")));

        ViewInteraction inputDataRight = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        inputDataRight.perform(replaceText("01.05.2023"));
        inputDataRight.check(matches(withText("01.05.2023")));

    }

    //Ввод не валидных значений в разделе Creating Edit News.
    public void inputCreatingNewsNotValidComplex() {
        ViewInteraction checkTextCreating = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating.check(matches(isDisplayed()));

        ViewInteraction inputCategory2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory2.perform(clearText());
        inputCategory2.perform(replaceText("Category_//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputCategory2.check(matches(withText("Category_//010101010101010101010101010101010100101010100101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        inputCategory2.perform(clearText());

        ViewInteraction inputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle.perform(replaceText("Title//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputTitle.check(matches(withText("Title//010101010101010101010101010101010100101010100101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        inputTitle.perform(clearText());

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.perform(replaceText("DescriptionOne//010101010101010101010101010101010100101010100101010101010101010101"), closeSoftKeyboard());
        inputDescription.check(matches(withText("DescriptionOne//010101010101010101010101010101010100101010100101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        inputDescription.perform(clearText());

        ViewInteraction inputPublishDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate.perform(replaceText("11.11.1990"));

        ViewInteraction inputPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime.perform(replaceText("15:00"));

        buttonNewsSteps.buttonSaveNews();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonOkAlert();
        buttonNewsSteps.buttonAddNews();

        ViewInteraction inputCategoryFull = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategoryFull.perform(replaceText("Category_Категория//010101010101010101010101010101010100101010100101010101010101010101"));
        inputCategoryFull.check(matches(withText("Category_Категория//010101010101010101010101010101010100101010100101010101010101010101")));

        ViewInteraction inputTitleFull = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitleFull.perform(replaceText("Title//010101010101010101010101010101010100101010100101010101010101010101"));
        inputTitleFull.check(matches(withText("Title//010101010101010101010101010101010100101010100101010101010101010101")));

        ViewInteraction inputPublishDateFull = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDateFull.perform(replaceText("11.11.1991"));

        ViewInteraction inputPublishTimeFull = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTimeFull.perform(replaceText("18:00"));

        ViewInteraction inputDescriptionFull = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescriptionFull.perform(replaceText("DescriptionTwo//010101010101010101010101010101010100101010100101010101010101010101"));
        inputDescriptionFull.check(matches(withText("DescriptionTwo//010101010101010101010101010101010100101010100101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonOkAlert();

    }

    //Ввод не валидных значений в разделе Filter News
    public void inputEditingNewsNotValidComplex() {
        ViewInteraction inputCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory.perform(clearText());
        inputCategory.perform(replaceText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputCategory.check(matches(withText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        ViewInteraction inputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle.perform(clearText());
        inputTitle.perform(replaceText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputTitle.check(matches(withText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101")));


        ViewInteraction inputPublishDate = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate.perform(clearText());
        inputPublishDate.perform(replaceText("01.01.1990"));


        ViewInteraction inputPublishTime = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime.perform(clearText());
        inputPublishTime.perform(replaceText("16:00"));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription.perform(clearText());
        inputDescription.perform(scrollTo());
        inputDescription.perform(replaceText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputDescription.check(matches(withText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        ViewInteraction inputCategory1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        inputCategory1.perform(scrollTo());
        inputCategory1.perform(clearText());
        inputCategory1.perform(replaceText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputCategory1.check(matches(withText("Category//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        inputCategory1.perform(clearText());

        ViewInteraction inputTitle2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        inputTitle2.perform(clearText());
        inputTitle2.perform(replaceText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputTitle2.check(matches(withText("Title////01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        ViewInteraction textCheckEditing2 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing2.check(matches(isDisplayed()));

        inputTitle2.perform(clearText());

        ViewInteraction inputPublishDate1 = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
        inputPublishDate1.perform(clearText());
        inputPublishDate1.perform(replaceText("02.02.1992"));

        buttonNewsSteps.buttonSaveNews();

        ViewInteraction textCheckEditing1_1 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing1_1.check(matches(isDisplayed()));

        inputPublishDate1.perform(clearText());

        ViewInteraction inputPublishTime1_2 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
        inputPublishTime1_2.perform(clearText());
        inputPublishTime1_2.perform(replaceText("18:30"));

        buttonNewsSteps.buttonSaveNews();

        ViewInteraction textCheckEditing1_2 = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing1_2.check(matches(isDisplayed()));

        inputPublishTime1_2.perform(clearText());

        ViewInteraction inputDescription3 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text)));
        inputDescription3.perform(clearText());
        inputDescription3.perform(replaceText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101"), closeSoftKeyboard());
        inputDescription3.check(matches(withText("Description//01010101010101010101010101010101010101010100101010101010101010101010101010101")));

        buttonNewsSteps.buttonSaveNews();

        ViewInteraction textCheckEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        textCheckEditing.check(matches(isDisplayed()));

        inputDescription3.perform(clearText());

        buttonNewsSteps.buttonSaveNews();
    }

}
