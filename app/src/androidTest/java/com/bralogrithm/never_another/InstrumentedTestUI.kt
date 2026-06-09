package com.bralogrithm.never_another

import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.MeasurementItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import com.bralogrithm.never_another.view.components.NavigationBarBottom
import com.bralogrithm.never_another.view.screens.home.elements.HomeSelectBra
import com.bralogrithm.never_another.view.screens.order.MyBraScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.orderstatus.OrderStatusScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.elements.YourMeasurement
import com.bralogrithm.never_another.viewmodel.FlowViewModel

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
    @Test
    fun purchaseFlowSelectionTriggersCorrectFlow() {
        val viewModel = FlowViewModel()

        composeTestRule.setContent {
            MyBraScreen(
                selectedScreen = Screen.MyBra,
                onScreenClick = {},
                onGoToOrderStatus = {},
                flowViewModel = viewModel
            )
        }

        // Test start af Video Flow (NEJ)
        composeTestRule.onNodeWithText("NEJ").performClick()
        assertTrue(viewModel.videoFlowOnGoing)

        // Reset og test start af Tekst Flow (JA)
        viewModel.closeVideoFlow()
        composeTestRule.onNodeWithText("JA").performClick()
        assertTrue(viewModel.textFlowOnGoing)
    }

    // Test af HomePage karrusel
    @Test
    fun homeCarouselToggleColorCallbackIsTriggered() {
        var toggleCalled = false

        composeTestRule.setContent {
            HomeSelectBra(
                selectedColor = BraColor.White,
                onToggleColor = { toggleCalled = true }
            )
        }

        // Find karrusel-knappen via dens Content Description
        composeTestRule.onAllNodesWithContentDescription("Switch Color")[0].performClick()

        assertTrue(toggleCalled)
    }

    // Test af Ordre Status Back knap
    @Test
    fun orderStatusBackButtonTriggersCallback() {
        var backClicked = false

        composeTestRule.setContent {
            OrderStatusScreen(
                onBackClick = { backClicked = true },
                onClickGoToAfterCare = {}
            )
        }

        composeTestRule.onNodeWithContentDescription("Gå tilbage").performClick()
        assertTrue(backClicked)
    }

    // Test af Målingsvisning (Data display)
    @Test
    fun measurementsDisplaysCorrectData() {
        val testMeasurements = listOf(
            MeasurementItem("Bryst", "90 cm", Icons.Default.Person),
            MeasurementItem("Talje", "70 cm", Icons.Default.Person)
        )

        composeTestRule.setContent {
            YourMeasurement(measurement = testMeasurements)
        }

        // Tjek om titler og værdier findes på skærmen
        composeTestRule.onNodeWithText("Bryst").assertExists()
        composeTestRule.onNodeWithText("90 cm").assertExists()
        composeTestRule.onNodeWithText("Talje").assertExists()
        composeTestRule.onNodeWithText("70 cm").assertExists()
    }


}