package algonquin.cst2335.juna0006;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import algonquin.cst2335.juna0006.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {


        ViewInteraction appCompatEditText2 = onView(
    allOf(withId(R.id.editTextTextPassword)));

        appCompatEditText2.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
allOf(withId(R.id.button)));
        materialButton.perform(click());

        ViewInteraction textView = onView(
allOf(withId(R.id.HelloWorld)));

        textView.check(matches(withText("You shall not pass!")));
        }

    /**
     * Testing function for Finding Missing Upper case
     */
    @Test
    public void testFindMissingUpperCase(){
        ViewInteraction appCompactEditText = onView(withId(R.id.editTextTextPassword));
        appCompactEditText.perform(replaceText("password123#$*"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.HelloWorld));
        textView.check(matches(withText("You shall not pass!")));
    }


    /**
     * Testing function for Finding Missing Lower case
     */
    @Test
    public void testFindMissingLowerCase(){
        ViewInteraction appCompactEditText = onView(withId(R.id.editTextTextPassword));
        appCompactEditText.perform(replaceText("PASSWORD123#$*"));


        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.HelloWorld));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Testing function for Finding Missing Special Character
     */
    @Test
    public void testFindMissingSpecialCharacter(){
        ViewInteraction appCompactEditText = onView(withId(R.id.editTextTextPassword));
        appCompactEditText.perform(replaceText("Password123"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.HelloWorld));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Testing function for Finding Missing Digit
     */
    @Test
    public void testFindMissingDigit(){
        ViewInteraction appCompactEditText = onView(withId(R.id.editTextTextPassword));
        appCompactEditText.perform(replaceText("Password@"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.HelloWorld));
        textView.check(matches(withText("You shall not pass!")));
    }

    /**
     * Testing function for Finding Missing Upper case
     */
    @Test
    public void testPasswordIsComplexEnough(){
        ViewInteraction appCompactEditText = onView(withId(R.id.editTextTextPassword));
        appCompactEditText.perform(replaceText("Password123#$*"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.HelloWorld));
        textView.check(matches(withText("Your password is Complex Enough")));
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
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
