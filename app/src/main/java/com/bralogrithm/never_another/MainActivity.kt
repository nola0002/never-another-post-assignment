package com.bralogrithm.never_another

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bralogrithm.never_another.model.BraColor
import com.bralogrithm.never_another.model.Screen
import com.bralogrithm.never_another.model.SubScreensProfile
import com.bralogrithm.never_another.model.exploreCarrouselOne
import com.bralogrithm.never_another.model.exploreCarrouselTwo
import com.bralogrithm.never_another.model.trustPilotCards
import com.bralogrithm.never_another.ui.theme.NeverAnotherTheme
import com.bralogrithm.never_another.view.screens.explore.ExploreScreen
import com.bralogrithm.never_another.view.screens.home.HomeScreen
import com.bralogrithm.never_another.view.screens.order.MyBraScreen
import com.bralogrithm.never_another.view.screens.profile.ProfileScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.aftercare.AfterCareScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.faq.FaqScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.personalinformation.InformationScreen
import com.bralogrithm.never_another.view.screens.profile.subscreens.orderstatus.OrderStatusScreen
import com.bralogrithm.never_another.viewmodel.FlowViewModel
import com.bralogrithm.never_another.viewmodel.NeverAnotherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NeverAnotherTheme {
                val viewModel = viewModel<NeverAnotherViewModel>()

                val flowViewModel = viewModel<FlowViewModel>()

                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = "home-screen") {


                        // HomeScreen
                        composable("home-screen") {
                            HomeScreen(
                                selectedScreen = viewModel.selectedScreen,
                                onScreenClick = { screenClicked -> viewModel.onScreenSelected(navController, screenClicked) }, // Naviger til den klikkede skærm
                                selectedColor = viewModel.selectedColor,
                                onToggleColor = { viewModel.toggleHomeBraColor() }
                            )
                        }

                        //ExploreScreen
                        composable("explore-screen") {
                            ExploreScreen(
                                selectedScreen = viewModel.selectedScreen,
                                onScreenClick = { screenClicked -> viewModel.onScreenSelected(navController, screenClicked) }, // Naviger til den klikkede skærm
                                listOfCardCarrouselPictures = viewModel.selectedCarouselPictures,
                                selectedColor = viewModel.selectedColor,
                                onClickWhite = { viewModel.selectColor(BraColor.White) },
                                onClickBlack = { viewModel.selectColor(BraColor.Black) },
                                listOfCardSectionTextOne = exploreCarrouselOne,
                                selectedCarrousel = viewModel.exploreCarrouselIndex,
                                carrouselBackButtonClick = { viewModel.carrouselBackButtonClick() },
                                carrouselForwardButtonClick = { viewModel.carrouselForwardButtonClick() },
                                trustPilotCards = trustPilotCards,
                                listOfCardSectionTextTwo = exploreCarrouselTwo
                            )
                        }


                        //MyBraScreen
                        composable("mybra-screen") {
                            MyBraScreen(
                                selectedScreen = viewModel.selectedScreen,
                                onScreenClick = { screenClicked -> viewModel.onScreenSelected(navController, screenClicked) }, // Naviger til den klikkede skærm
                                onGoToOrderStatus = { navController.navigate("orderstatus-subscreen") },
                                flowViewModel = flowViewModel
                            )
                        }


                        //ProfileScreen
                        composable("profile-screen") {
                            ProfileScreen(
                                selectedScreen = viewModel.selectedScreen,
                                onScreenClick = { screenClicked -> viewModel.onScreenSelected(navController, screenClicked) }, // Naviger til den klikkede skærm
                                onAction = { subScreenClicked -> viewModel.onSubScreenProfileSelected(navController, subScreenClicked)}
                            )
                        }


                        composable("myinformation-subscreen") {
                            InformationScreen(
                                onBackClick = { navController.popBackStack() },
                                upperCircumference = flowViewModel.upperCircumference,
                                lowerCircumference = flowViewModel.lowerCircumference,
                                breastSpan = flowViewModel.breastSpan,
                                breastHeight = flowViewModel.breastHeight
                            )
                        }

                        composable("aftercare-subscreen") {
                            AfterCareScreen(
                                onBackClick = { navController.popBackStack()}
                            )
                        }

                        composable("orderstatus-subscreen") {
                            OrderStatusScreen(
                                onBackClick = {navController.popBackStack()},
                                onClickGoToAfterCare = {navController.navigate("aftercare-subscreen")}
                            )
                        }

                        composable("faq-subscreen") {
                            FaqScreen(
                                onBackClick = { navController.popBackStack() }
                            )

                        }
                    }
                }
            }
        }
    }
}
