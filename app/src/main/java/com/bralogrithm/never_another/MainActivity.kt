package com.bralogrithm.never_another

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.ui.theme.NeveranotherTheme
import com.bralogrithm.never_another.view.ExploreScreen
import com.bralogrithm.never_another.view.HomeScreen
import com.bralogrithm.never_another.view.MyBraScreen
import com.bralogrithm.never_another.view.ProfileScreen
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
                            }
                        )
                    }


                    //MyBraScreen
                    composable("mybra-screen"){
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
                    composable("profile-screen"){
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
