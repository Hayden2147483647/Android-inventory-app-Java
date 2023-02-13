package com.example.kiwiscookiesandcakes;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InventoryAddRemoveandAddtestitems {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void inventoryAddRemoveandAddtestitems() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextUsernameLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Admin"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextPasswordLogin),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("CookieManagement84"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextPasswordLogin), withText("CookieManagement84"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.signinButton), withText("Sign-In"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialButton.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.userMenuFromAdminMenu), withText("Users Menu"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.inventoryStatusMenuButton), withText("Inventory Status"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.mainMenufromInvStat), withText("Back to Main Menu"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        materialButton4.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.addTestItemButton), withText("Add 20 Test items to Inventory"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.inventoryStatusMenuButton), withText("Inventory Status"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton6.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton12.perform(click());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton13.perform(click());

        ViewInteraction materialButton14 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton14.perform(click());

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.mainMenufromInvStat), withText("Back to Main Menu"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        materialButton15.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton16 = onView(
                allOf(withId(R.id.addItemsMenuButton), withText("Add Items into Inventory"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton16.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.itemNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction materialButton17 = onView(
                allOf(withId(R.id.addItemButton), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton17.perform(click());

        pressBack();

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.itemNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText5.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.itemNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("Yeast"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.itemQuantityEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("0"), closeSoftKeyboard());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.addItemButton), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.itemQuantityEditText), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText8.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.itemQuantityEditText), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("20"));

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.itemQuantityEditText), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText10.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.itemQuantityEditText), withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText11.perform(pressImeActionButton());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.ingredientRadio), withText("Ingredient"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                3),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction materialRadioButton2 = onView(
                allOf(withId(R.id.otherRadio), withText("Other"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                4),
                        isDisplayed()));
        materialRadioButton2.perform(click());

        ViewInteraction materialRadioButton3 = onView(
                allOf(withId(R.id.cakeRadio), withText("Cake"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                2),
                        isDisplayed()));
        materialRadioButton3.perform(click());

        ViewInteraction materialRadioButton4 = onView(
                allOf(withId(R.id.biscuitRadio), withText("Biscuit"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                0),
                        isDisplayed()));
        materialRadioButton4.perform(click());

        ViewInteraction materialRadioButton5 = onView(
                allOf(withId(R.id.ingredientRadio), withText("Ingredient"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                3),
                        isDisplayed()));
        materialRadioButton5.perform(click());

        ViewInteraction materialButton19 = onView(
                allOf(withId(R.id.addItemButton), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton19.perform(click());

        ViewInteraction materialButton20 = onView(
                allOf(withId(android.R.id.button1), withText("Dismiss"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton20.perform(scrollTo(), click());

        ViewInteraction materialButton21 = onView(
                allOf(withId(R.id.inventoryStatFromAddButton), withText("Inventory Status"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton21.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton22 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton22.perform(click());

        ViewInteraction materialButton23 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton23.perform(click());

        ViewInteraction materialButton24 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton24.perform(click());

        ViewInteraction materialButton25 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton25.perform(click());

        ViewInteraction materialButton26 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton26.perform(click());

        ViewInteraction materialButton27 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton27.perform(click());

        ViewInteraction materialButton28 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton28.perform(click());

        ViewInteraction materialButton29 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton29.perform(click());

        ViewInteraction materialButton30 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton30.perform(click());

        ViewInteraction materialButton31 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton31.perform(click());

        ViewInteraction materialButton32 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton32.perform(click());

        ViewInteraction materialButton33 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton33.perform(click());

        ViewInteraction materialButton34 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton34.perform(click());

        ViewInteraction materialButton35 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton35.perform(click());

        ViewInteraction materialButton36 = onView(
                allOf(withId(R.id.previousButton), withText("Previous"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        materialButton36.perform(click());

        ViewInteraction materialButton37 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        materialButton37.perform(click());

        ViewInteraction materialButton38 = onView(
                allOf(withId(R.id.mainMenufromInvStat), withText("Back to Main Menu"),
                        childAtPosition(
                                allOf(withId(R.id.inventory_status),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        materialButton38.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton39 = onView(
                allOf(withId(R.id.clearInventoryButton), withText("Clear all in Inventory"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton39.perform(click());

        ViewInteraction materialButton40 = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton40.perform(scrollTo(), click());

        ViewInteraction materialButton41 = onView(
                allOf(withId(R.id.addItemsMenuButton), withText("Add Items into Inventory"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton41.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.itemNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("Bread"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.itemQuantityEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction materialRadioButton6 = onView(
                allOf(withId(R.id.cookieRadio), withText("Cookie"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                1),
                        isDisplayed()));
        materialRadioButton6.perform(click());

        ViewInteraction materialRadioButton7 = onView(
                allOf(withId(R.id.ingredientRadio), withText("Ingredient"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                3),
                        isDisplayed()));
        materialRadioButton7.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.itemQuantityEditText), withText("10"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText14.perform(pressImeActionButton());

        ViewInteraction materialButton42 = onView(
                allOf(withId(R.id.addItemButton), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton42.perform(click());

        ViewInteraction materialButton43 = onView(
                allOf(withId(android.R.id.button1), withText("Dismiss"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton43.perform(scrollTo(), click());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.itemNameEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("Oreo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.itemQuantityEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("16"), closeSoftKeyboard());

        ViewInteraction materialRadioButton8 = onView(
                allOf(withId(R.id.cookieRadio), withText("Cookie"),
                        childAtPosition(
                                allOf(withId(R.id.typeRadioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                1),
                        isDisplayed()));
        materialRadioButton8.perform(click());

        ViewInteraction materialButton44 = onView(
                allOf(withId(R.id.addItemButton), withText("Add Item"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton44.perform(click());

        ViewInteraction materialButton45 = onView(
                allOf(withId(android.R.id.button1), withText("Dismiss"),
                        childAtPosition(
                                childAtPosition(
                                        withId(androidx.appcompat.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton45.perform(scrollTo(), click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.itemQuantityEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText17.perform(pressImeActionButton());

        ViewInteraction materialButton46 = onView(
                allOf(withId(R.id.inventoryStatFromAddButton), withText("Inventory Status"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton46.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
