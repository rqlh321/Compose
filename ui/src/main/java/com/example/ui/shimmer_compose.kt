package com.example.ui

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

@Composable
fun Shimmer(
    content: @Composable (brush: Brush) -> Unit
) {
    val gradient = listOf(
        Color.LightGray.copy(alpha = .8f),
        Color.LightGray.copy(alpha = .4f),
        Color.LightGray.copy(alpha = .8f),
    )

    val transition = rememberInfiniteTransition() // animate infinite times

    val translateAnimation = transition.animateFloat( //animate the transition
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Restart,
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = LinearEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = gradient,
        start = Offset.Zero,
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        ),
        tileMode = TileMode.Clamp
    )
    content(brush)
}