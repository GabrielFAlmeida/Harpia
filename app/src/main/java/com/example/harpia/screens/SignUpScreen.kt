package com.example.harpia.screens

import android.util.Log
import android.widget.Toast
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
import com.example.harpia.MainActivity
import com.example.harpia.R
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonText
import com.example.harpia.components.CommonTextField
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.components.createUserWithEmailAndPassword
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Composable
fun SignUpScreen() {

    lateinit var firebaseAuth: FirebaseAuth

    firebaseAuth = Firebase.auth

    //Log.d("Firebase", firebaseAuth.toString())

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
                destinationScreen = Screen.LoginScreen,
                text = stringResource(id = R.string.back_text),
                color = White
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
                        text = stringResource(id = R.string.signup_title).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = Typography.titleMedium,
                        color = Blue30
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.signup_input_placeholder_1),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.signup_input_placeholder_2),
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.signup_input_placeholder_3),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.signup_input_placeholder_4),
                        modifier = Modifier
                            .fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Spacer(modifier = Modifier.height(70.dp))
                    CommonButton(text = stringResource(id = R.string.create_account_text), onCLick = {
                        createUserWithEmailAndPassword(firebaseAuth, "g200013@hotmai.com", "12345678")
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun SingUpScreenPreview() {
    SignUpScreen()
}

