package com.example.harpia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.harpia.R
import com.example.harpia.classes.SelectOption
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonSelect
import com.example.harpia.components.CommonText
import com.example.harpia.components.CommonTextField
import com.example.harpia.components.NavigatorClickableText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White


@Composable
fun NewExperienceScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple20)
            .paint(
                painter = painterResource(id = R.drawable.fundo_camada_de_formas_destaque),
                contentScale = ContentScale.FillBounds
            )
            .padding(start = 45.dp, top = 70.dp, end = 50.dp, bottom = 85.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple20)
        ) {
            NavigatorIconButton(
                destinationScreen = Screen.HomeScreen,
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
                        text = stringResource(id = R.string.new_experience_title).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = Typography.titleMedium,
                        color = Blue30
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_1),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_2),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonSelect(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_3),
                        options = listOf(
                            SelectOption(stringResource(id = R.string.class_option_1), "6_EF"),
                            SelectOption(stringResource(id = R.string.class_option_2), "7_EF"),
                            SelectOption(stringResource(id = R.string.class_option_3), "8_EF"),
                            SelectOption(stringResource(id = R.string.class_option_4), "9_EF"),
                            SelectOption(stringResource(id = R.string.class_option_5), "1_EM"),
                            SelectOption(stringResource(id = R.string.class_option_6), "2_EM"),
                            SelectOption(stringResource(id = R.string.class_option_7), "3_EM"),
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonSelect(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_4),
                        options = listOf(
                            SelectOption(stringResource(id = R.string.methodology_option_1), "INV_CLASS"),
                            SelectOption(stringResource(id = R.string.methodology_option_2), "GAME"),
                            SelectOption(stringResource(id = R.string.methodology_option_3), "PROJ"),
                            SelectOption(stringResource(id = R.string.methodology_option_4), "DESIGN_THNK"),
                            SelectOption(stringResource(id = R.string.methodology_option_5), "OTHER")
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CommonButton(text = stringResource(id = R.string.save_info_text))
                }
            }
        }
    }
}

@Preview
@Composable
fun NewExperienceScreenPreview() {
    NewExperienceScreen()
}