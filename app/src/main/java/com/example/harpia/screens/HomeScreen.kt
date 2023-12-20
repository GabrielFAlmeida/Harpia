package com.example.harpia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.harpia.R
import com.example.harpia.components.ClickableImageButton
import com.example.harpia.components.CommonText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple20)
            .paint(
                painter = painterResource(id = R.drawable.fundo_camada_de_formas_destaque),
                contentScale = ContentScale.FillBounds
            )
            .padding(start = 50.dp, top = 80.dp, end = 50.dp, bottom = 120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple20)
        ) {
            NavigatorIconButton(
                navController = navController,
                route = Screen.LoginScreen.route,
                text = stringResource(id = R.string.close_text),
                color = White,
                imageVector = Icons.Filled.Close,
                contentDescription = "Sair"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                modifier = Modifier
                    .background(Purple20),
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    CommonText(
                        text = stringResource(id = R.string.home_title).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = Typography.titleMedium,
                        color = Blue30
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ClickableImageButton(
                            modifier = Modifier
                                .width(125.dp)
                                .background(Color.Transparent),
                            navController = navController,
                            route = Screen.NewExperienceScreen.route,
                            imageId = R.drawable.icone_compartilhar_experiencia,
                            text = stringResource(id = R.string.home_button_content_1),
                            color = Blue30,
                        )
                        ClickableImageButton(
                            modifier = Modifier
                                .width(125.dp)
                                .background(Color.Transparent),
                            navController = navController,
                            route = Screen.SearchExperienceScreen.route,
                            imageId = R.drawable.icone_buscar,
                            text = stringResource(id = R.string.home_button_content_2),
                            color = Blue30,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ClickableImageButton(
                            modifier = Modifier
                                .width(125.dp)
                                .background(Color.Transparent),
                            navController = navController,
                            route = Screen.MethodologiesScreen.route,
                            imageId = R.drawable.icone_editar,
                            text = stringResource(id = R.string.home_button_content_3),
                            color = Blue30,
                        )
                        ClickableImageButton(
                            modifier = Modifier
                                .width(125.dp)
                                .background(Color.Transparent),
                            navController = navController,
                            route = Screen.ProfileScreen.route,
                            imageId = R.drawable.icone_perfil,
                            text = stringResource(id = R.string.home_button_content_4),
                            color = Blue30,
                        )
                    }
                    Spacer(modifier = Modifier.heightIn(100.dp))
                    CommonText(
                        text = stringResource(id = R.string.home_thanks).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = Typography.titleSmall,
                        color = Blue30
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}