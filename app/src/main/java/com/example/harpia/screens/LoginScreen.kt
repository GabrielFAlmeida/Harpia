package com.example.harpia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.harpia.R
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonTextField
import com.example.harpia.components.NavigatorClickableText
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Purple20


@Composable
fun LoginScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple20)
            .paint(
                painter = painterResource(id = R.drawable.fundo_camada_de_formas),
                contentScale = ContentScale.FillBounds
            )
            .padding(start = 50.dp, top = 170.dp, end = 50.dp, bottom = 85.dp)
    ) {
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
                Image(
                    painter = painterResource(id = R.drawable.logo_harpia_colorizado_sem_fundo_1),
                    contentDescription = "Logo do Harpia",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                CommonTextField(
                    placeholder = stringResource(id = R.string.login_input_placeholder_1),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                CommonTextField(
                    placeholder = stringResource(id = R.string.login_input_placeholder_2),
                    modifier = Modifier
                        .fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Spacer(modifier = Modifier.height(40.dp))
                CommonButton(
                    text = stringResource(id = R.string.login_text),
                    onCLick = { navController.navigate(Screen.HomeScreen.route) }
                )
                NavigatorClickableText(
                    navController = navController,
                    route = Screen.PasswordScreen.route,
                    text = stringResource(id = R.string.login_redirect_text_1),
                )
                CommonButton(
                    text = stringResource(id = R.string.create_account_text),
                    onCLick = { navController.navigate(Screen.SignUpScreen.route) })
                NavigatorClickableText(
                    navController = navController,
                    route = Screen.AboutScreen.route,
                    text = stringResource(id = R.string.login_redirect_text_2),
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}