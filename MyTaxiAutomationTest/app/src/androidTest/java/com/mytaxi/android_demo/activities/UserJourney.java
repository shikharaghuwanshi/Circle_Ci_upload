package com.mytaxi.android_demo.activities;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import com.mytaxi.android_demo.R;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;

@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class UserJourney {


    private String username;
    private String password;
    private String searchText;
    private String driverName;

    private MainActivity mActivity = null;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setData() {
        mActivity = mActivityRule.getActivity();
        username = "crazydog335";
        password = "venture";
        driverName = "Sarah Scott";
        searchText = "sa";
    }


    @Test
    public void test1_userLoginTest() throws Exception {


        //Type Username
        Espresso.onView(ViewMatchers.withId(R.id.edt_username)).perform(typeText(username));
        //Type Password
        Espresso.onView(ViewMatchers.withId(R.id.edt_password)).perform(typeText(password));
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(click());

        Thread.sleep(7000);
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());


        // Assertion checking verify username displayed is correct
        Espresso.onView(ViewMatchers.withId(R.id.nav_username))
                .check(ViewAssertions.matches(ViewMatchers.withText(username)));
        Espresso.onView(ViewMatchers.withId(R.id.drawer_layout)).perform(DrawerActions.open());

    }

    @Test
    public void test2_userSearchDriverAndCall() throws InterruptedException {

        Thread.sleep(7000);

        //Typing the Search Text
        Espresso.onView(ViewMatchers.withId(R.id.textSearch))
                .perform(typeText(searchText));


        Thread.sleep(10000);

        //Verify whether the desired driver is displayed in the list
        onView(withText(driverName))
                .inRoot(RootMatchers.withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
        //Selecting the desired driver
        onView(withText(driverName))
                .inRoot(RootMatchers.withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(scrollTo()).perform(click());
        //Verify the drivername
        onView(withId(R.id.textViewDriverName)).check(matches(withText(driverName)));
        onView(withId(R.id.fab)).perform(click());


    }

}