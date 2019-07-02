package com.chibusoft.africancuisines;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;




@RunWith(AndroidJUnit4.class)
public class contentDisplayTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void NameCheck() {

        // Perform click at item at position 1 and confirm name match
        onData(anything()).inAdapterView(withId(R.id.cuisines_listview)).atPosition(1)
                .check(matches(withText("Ogbono soup")));

        // Perform click at item at position 2 and confirm name match
        onData(anything()).inAdapterView(withId(R.id.cuisines_listview)).atPosition(2)
                .check(matches(withText("Afang Soup")));
    }

    @Test
    public void detailsCheck() {

        // // Perform click at item at position 1
        onData(anything()).inAdapterView(withId(R.id.cuisines_listview)).atPosition(2).perform(click());

        //Check if it displays place of origin
        onView(withId(R.id.origin_tv)).check(matches(withText("Place of origin:")));
    }
}



