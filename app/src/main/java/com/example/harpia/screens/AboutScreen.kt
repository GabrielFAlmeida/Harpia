package com.example.harpia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harpia.R
import com.example.harpia.components.CommonBulletList
import com.example.harpia.components.CommonText
import com.example.harpia.components.NavigatorClickableText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue10
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White

@Composable
fun AboutScreen() {
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
                destinationScreen = Screen.LoginScreen,
                text = stringResource(id = R.string.back_text),
                color = White
            )
            Spacer(modifier = Modifier.height(10.dp))
            CommonText(
                text = stringResource(id = R.string.about_title),
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = Typography.titleLarge,
                color = Blue10
            )
            Spacer(modifier = Modifier.height(30.dp))
            CommonText(
                text = stringResource(id = R.string.about_content_1),
                textStyle = Typography.bodyLarge,
                color = White,
                textAlign = TextAlign.Justify
            )
            CommonBulletList(
                items = listOf(
                    stringResource(id = R.string.about_bullet_content_1),
                    stringResource(id = R.string.about_bullet_content_2)
                ),
                textStyle = Typography.bodyLarge,
                color = White,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(20.dp))
            NavigatorClickableText(
                text = stringResource(id = R.string.about_thanks),
                destinationScreen = Screen.TeamScreen,
                textStyle = Typography.bodyLarge,
                color = Blue10
            )
        }
    }
}

@Preview()
@Composable
fun AboutScreenPreview() {
    AboutScreen()
}