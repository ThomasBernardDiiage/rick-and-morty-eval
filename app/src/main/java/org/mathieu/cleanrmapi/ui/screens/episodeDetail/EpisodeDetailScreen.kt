package org.mathieu.cleanrmapi.ui.screens.episodeDetail

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import org.mathieu.cleanrmapi.ui.core.composables.EpisodeCard
import org.mathieu.cleanrmapi.ui.core.composables.PreviewContent
import org.mathieu.cleanrmapi.ui.core.theme.Purple40
import org.mathieu.cleanrmapi.ui.screens.characterdetails.CharacterDetailsState
import org.mathieu.cleanrmapi.ui.screens.characterdetails.CharacterDetailsViewModel

private typealias UIState = EpisodeDetailsState

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    id: Int
) {
    val viewModel: EpisodeDetailViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    viewModel.init(episodeId = id)

    CharacterDetailsContent(
        state = state,
        onClickBack = navController::popBackStack
    )

}


@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
private fun CharacterDetailsContent(
    state: UIState = UIState(),
    onClickBack: () -> Unit = { }
) = Scaffold(topBar = {

    Row(
        modifier = Modifier
            .background(Purple40)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp)
                .clickable(onClick = onClickBack),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(
            text = state.name,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}) { paddingValues ->
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues), contentAlignment = Alignment.Center) {

        EpisodeCard(
            modifier = Modifier.fillMaxWidth(),
            date = state.date,
            episode = state.episode,
            name = state.name)
    }
}


@Preview
@Composable
private fun CharacterDetailsPreview() = PreviewContent {
    CharacterDetailsContent()
}

