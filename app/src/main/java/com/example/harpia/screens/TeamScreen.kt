package com.example.harpia.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harpia.R
import com.example.harpia.components.CommonBulletList
import com.example.harpia.components.CommonText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.navigation.HarpiaAppRouter
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue10
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White

@Composable
fun TeamScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple20)
            .paint(
                painter = painterResource(id = R.drawable.fundo_camada_de_formas_destaque),
                contentScale = ContentScale.FillBounds
            )
            .padding(start = 48.dp, top = 80.dp, end = 48.dp, bottom = 90.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple20)
        ) {
            NavigatorIconButton(
                destinationScreen = Screen.AboutScreen,
                text = stringResource(id = R.string.back_text),
                color = White
            )
            Spacer(modifier = Modifier.height(10.dp))
            CommonText(
                text = stringResource(id = R.string.team_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = Typography.titleLarge,
                color = Blue10
            )
            Spacer(modifier = Modifier.height(30.dp))
            CommonText(
                text = stringResource(id = R.string.team_content_1),
                textStyle = Typography.bodyLarge,
                color = White,
                textAlign = TextAlign.Justify
            )
            CommonBulletList(
                items = listOf(
                    stringResource(id = R.string.team_bullet_content_1),
                    stringResource(id = R.string.team_bullet_content_2),
                    stringResource(id = R.string.team_bullet_content_3),
                    stringResource(id = R.string.team_bullet_content_4),
                    stringResource(id = R.string.team_bullet_content_5)
                ), textStyle = Typography.bodyLarge, color = Blue10, textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
fun TeamScreenPreview() {
    TeamScreen()
}