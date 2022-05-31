package com.example.myunittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class MainActivityTest extends TestCase {
    private final String dummyVolume = "6280.0";
    private final String dummyLuasSelimut = "1256.0";
    private final String dummyLuasTabung = "1884.0";
    private final String dummyLength = "10.0";
    private final String dummyHeight = "20.0";
    private final String emptyInput = "";
    private final String fieldEmpty = "Field ini tidak boleh kosong";

    @Before
    public void setup(){
        ActivityScenario.launch(MainActivity.class);
         }

    @Test
    public void assertGetLuasSelimut() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength),
                closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_circumference)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyLuasSelimut)));
    }

    @Test
    public void assertGetLuasTabung() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength),
                closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.btn_calculate_surface_area)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_surface_area)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyLuasTabung)));
    }

    @Test
    public void assertGetVolume() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength),
                closeSoftKeyboard());
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.btn_calculate_volume)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_calculate_volume)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)));
    }
    @Test
    public void InputKosong() {
// pengecekan input untuk length
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.edt_length)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength),
                closeSoftKeyboard());
        // pengecekan input untuk height
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());

        onView(withId(R.id.edt_height)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight),
                closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
    }

}
