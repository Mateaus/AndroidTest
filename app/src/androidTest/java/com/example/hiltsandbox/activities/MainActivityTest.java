package com.example.hiltsandbox.activities;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.hiltsandbox.R;
import com.example.hiltsandbox.di.qualifiers.RemoteToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoDataSource;
import com.example.hiltsandbox.model.ToDo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

@HiltAndroidTest
public class MainActivityTest {

    @Rule(order = 0)
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule(order = 1)
    public ActivityScenarioRule<MainActivity> mainActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        hiltRule.inject();
    }

    @Test
    public void t() {

    }

//    @Test
//    public void testMainActivityIsVisible() {
//        onView(withId(R.id.mainActivityConstraintLayout)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void testNavigationHomeFragmentIsVisible() {
//        onView(withId(R.id.toDoConstraintLayout)).check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void testButtonPress() {
//        onView(withId(R.id.toDoFloatingActionButton)).perform(click());
//    }
}