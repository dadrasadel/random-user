package com.globallogic.pokemon.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.bilerplatemvvm.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest


@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class MainActivityTest{
    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)
    @Test
    fun changeTextWhenClickButton() {
        // Type text and then press the button.
//        onView(withId(R.id.txtName))
//            .perform(setTextInTextView("test"))
        onView(withId(R.id.btnGenerate)).perform(click())
        // Check that the text was changed.
//        onView(withId(R.id.txtName)).check(matches(withText("test2")))
    }
}