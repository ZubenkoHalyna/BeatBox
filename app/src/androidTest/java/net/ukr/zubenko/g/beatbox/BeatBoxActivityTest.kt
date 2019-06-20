package net.ukr.zubenko.g.beatbox

import org.junit.Assert.*
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.anything
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BeatBoxActivityTest {
    @get:Rule
    val mActivityRule: ActivityTestRule<BeatBoxActivity> = ActivityTestRule(BeatBoxActivity::class.java)

    @Test
    fun showsFirstFileName() {
        onView(withText("65_cjipie")).check(matches(anything()))
    }
}
