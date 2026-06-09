package com.bralogrithm.never_another

import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.components.NavigationBarBottom

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

   @get:Rule
   val composeTestRule = createComposeRule()

    // Get package content
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.bralogrithm.never_another", appContext.packageName)
    }

    // Test af Navigation Bar UI
    @Test
    fun navbarDisplaysAllItemsAndTriggersCallbacks() {
        var clickedScreen: Screen? = null

        composeTestRule.setContent {
            NavigationBarBottom(
                selectedScreen = Screen.Home,
                onScreenClick = { screen ->
                    clickedScreen = screen
                }
            )
        }

        // Test Udforsk knap
        composeTestRule.onNodeWithText("Udforsk").performClick()
        assertEquals(Screen.Explore, clickedScreen)

        // Test Bestil knap
        composeTestRule.onNodeWithText("Bestil").performClick()
        assertEquals(Screen.MyBra, clickedScreen)

        // Test Profil knap
        composeTestRule.onNodeWithText("Profil").performClick()
        assertEquals(Screen.Profile, clickedScreen)

    }

    // Test af købsflow UI

    // Test af HomePage karrusel


}