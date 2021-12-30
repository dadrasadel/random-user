package com.opeqe.userrandom.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.bilerplatemvvm.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.action.ViewActions.click

import androidx.test.espresso.assertion.ViewAssertions.matches
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.not


@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class MainActivityTest{
    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)
    @Test
    fun mainActivityIsLoaded() {
//        then
        onView(withId(R.id.root_layout)).check(matches(isDisplayed()))

    }
}