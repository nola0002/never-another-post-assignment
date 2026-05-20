package com.bralogrithm.never_another

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.view.screens.explore.ExploreScreen
import com.bralogrithm.never_another.view.screens.home.HomeScreen
import com.bralogrithm.never_another.view.screens.order.MyBraScreen
import com.bralogrithm.never_another.view.screens.profile.ProfileScreen
import com.bralogrithm.never_another.viewmodel.NeverAnotherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<NeverAnotherViewModel>()

            val navController = rememberNavController()


            NavHost(navController = navController, startDestination = "home-screen") {


                // HomeScreen
                composable("home-screen") {
                    HomeScreen(
                        selectedScreen = viewModel.selectedScreen,
                        onScreenClick = { screen ->
                            viewModel.selectedScreen = screen
                            when (screen) {
                                Screen.Home -> navController.navigate("home-screen")
                                Screen.Explore -> navController.navigate("explore-screen")
                                Screen.MyBra -> navController.navigate("mybra-screen")
                                Screen.Profile -> navController.navigate("profile-screen")
                            }
                        }
                    )
                }

                //ExploreScreen
                composable("explore-screen") {
                    ExploreScreen(
                        selectedScreen = viewModel.selectedScreen,
                        onScreenClick = { screen ->
                            viewModel.selectedScreen = screen
                            when (screen) {
                                Screen.Home -> navController.navigate("home-screen")
                                Screen.Explore -> navController.navigate("explore-screen")
                                Screen.MyBra -> navController.navigate("mybra-screen")
                                Screen.Profile -> navController.navigate("profile-screen")
                            }
                        },
                        listOfCardSectionText = viewModel.exploreCarrouselOne,
                        selectedCarrouselText = viewModel.exploreCarrouselOneIndex,
                        carrouselBackButtonClick = { viewModel.carrouselBackButtonClick() },
                        carrouselForwardButtonClick = { viewModel.carrouselForwardButtonClick() }
                    )
                }


                //MyBraScreen
                composable("mybra-screen") {
                    MyBraScreen(
                        selectedScreen = viewModel.selectedScreen,
                        onScreenClick = { screen ->
                            viewModel.selectedScreen = screen
                            when (screen) {
                                Screen.Home -> navController.navigate("home-screen")
                                Screen.Explore -> navController.navigate("explore-screen")
                                Screen.MyBra -> navController.navigate("mybra-screen")
                                Screen.Profile -> navController.navigate("profile-screen")
                            }
                        }
                    )
                }


                //ProfileScreen
                composable("profile-screen") {
                    ProfileScreen(
                        selectedScreen = viewModel.selectedScreen,
                        onScreenClick = { screen ->
                            viewModel.selectedScreen = screen
                            when (screen) {
                                Screen.Home -> navController.navigate("home-screen")
                                Screen.Explore -> navController.navigate("explore-screen")
                                Screen.MyBra -> navController.navigate("mybra-screen")
                                Screen.Profile -> navController.navigate("profile-screen")
                            }
                        }
                    )
                }
            }
        }
    }
}
