package com.example.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.util.*

data class SmallItem(
    val id: String,
    val imageUrl: String,
    val imageDescription: String,
    val title: String,
)

@Preview
@Composable
fun SmallItemComposePreview() {
    Column {
        SmallItemCompose(
            SmallItem(
                id = UUID.randomUUID().toString(),
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
                imageDescription = "imageDescription",
                title = UUID.randomUUID().toString(),
            )
        ) {

        }
    }

}

@Composable
fun SmallItemCompose(
    item: SmallItem,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick.invoke(item.id) },
    ) {
        Row {
            AsyncImage(
                model = item.imageUrl,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(MaterialTheme.colors.secondary),
                contentDescription = item.imageDescription,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            Text(
                text = item.title,
                maxLines = 2,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(8.dp)

            )
        }
    }

}

@Composable
fun SmallItemLoadingCompose(brush: Brush) {
    Spacer(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(brush)
    )
}