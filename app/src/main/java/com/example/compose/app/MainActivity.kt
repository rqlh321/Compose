package com.example.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.compose.app.theme.ComposeTheme
import com.example.contact_feature.presenter.compose.ContactCompose
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            ComposeTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            RootScreen.values().forEach { screen ->
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            painter = painterResource(android.R.drawable.arrow_down_float),
                                            contentDescription = null
                                        )
                                    },
                                    label = { Text(stringResource(screen.resourceId)) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            // Pop up to the start destination of the graph to
                                            // avoid building up a large stack of destinations
                                            // on the back stack as users select items
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            // Avoid multiple copies of the same destination when
                                            // reselecting the same item
                                            launchSingleTop = true
                                            // Restore state when reselecting a previously selected item
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = RootScreen.Contacts.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(RootScreen.Contacts.route) { ContactCompose(hiltViewModel(it)) }
                    }
                }
            }
        }
    }
}
