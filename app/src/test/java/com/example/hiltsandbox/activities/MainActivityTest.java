package com.example.hiltsandbox.activities;

import android.os.Build;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.hiltsandbox.R;
import com.example.hiltsandbox.di.ToDoRepositoryModule;
import com.example.hiltsandbox.di.qualifiers.LocalToDoDataSource;
import com.example.hiltsandbox.di.qualifiers.RemoteToDoDataSource;
import com.example.hiltsandbox.fakedi.FakeToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoDataSource;
import com.example.hiltsandbox.model.ToDo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.HiltTestApplication;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@HiltAndroidTest
@RunWith(RobolectricTestRunner.class)
@Config(
        sdk = Build.VERSION_CODES.P,
        application = HiltTestApplication.class
)
public class MainActivityTest {

    @Rule(order = 0)
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @Rule(order = 1)
    public ActivityScenarioRule<MainActivity> mainActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Inject
    @RemoteToDoDataSource
    ToDoDataSource toDoDataSource;

    @Before
    public void setUp() {
        hiltRule.inject();
    }

    @Test
    public void testMainActivityIsVisible() {
        onView(withId(R.id.mainActivityConstraintLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void testNavigationHomeFragmentIsVisible() {
        onView(withId(R.id.toDoConstraintLayout)).check(matches(isDisplayed()));
    }

    @Test
    public void testFakeRepository() {
        ToDoDataSource.GetToDoCallback callback = Mockito.mock(ToDoDataSource.GetToDoCallback.class);
        doAnswer(invocation -> {
            List<ToDo> toDos = invocation.getArgument(0);
            assertNotNull(toDos);
            return null;
        }).when(callback).onSuccess(any());

        toDoDataSource.getToDo(callback);

        verify(callback, times(1)).onSuccess(any());
    }

    @Test
    public void testButtonPress() {
        onView(withId(R.id.toDoFloatingActionButton)).perform(click());
    }
}