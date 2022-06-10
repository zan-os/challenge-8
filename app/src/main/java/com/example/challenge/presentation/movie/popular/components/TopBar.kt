package com.example.challenge.presentation.movie.popular.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge.presentation.destinations.FavoriteScreenDestination
import com.example.challenge.presentation.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun TopBar(navigator: DestinationsNavigator) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        IconButton(onClick = { navigator.navigate(SearchScreenDestination) }) {
            Icon(Icons.Default.Search, contentDescription = null)
        }
        Text(text = "Popular Movie", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = { navigator.navigate(FavoriteScreenDestination) }) {
            Icon(Icons.Default.Favorite, contentDescription = null)
        }
    }
}