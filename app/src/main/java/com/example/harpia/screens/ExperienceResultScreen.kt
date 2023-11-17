package com.example.harpia.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.harpia.R
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonCard
import com.example.harpia.components.CommonText
import com.example.harpia.components.CommonTextField
import com.example.harpia.components.NavigatorClickableText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue20
import com.example.harpia.ui.theme.Blue20_o1
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Grey10_o4
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White


@Composable
fun ExperienceResultScreen() {
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
                destinationScreen = Screen.SearchExperienceScreen,
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
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                        .verticalScroll(state = ScrollState(0))
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    CommonText(
                        text = stringResource(id = R.string.experience_result_title).uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textStyle = Typography.titleMedium,
                        color = Blue30
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    CommonCard(
                        borderColor = Blue20,
                        backgroundColor = Blue20_o1,
                        textColor = Blue30,
                        text = stringResource(id = R.string.experience_result_content_1),
                        modifier = Modifier
                            .defaultMinSize(minHeight = 100.dp)
                            .fillMaxWidth()
                    )
                    CommonButton(
                        text = stringResource(id = R.string.see_details_text),
                        buttonColor = Blue30,
                        textColor = White
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    CommonCard(
                        borderColor = Blue20,
                        backgroundColor = Blue20_o1,
                        textColor = Blue30,
                        text = stringResource(id = R.string.experience_result_content_2),
                        modifier = Modifier
                            .defaultMinSize(minHeight = 100.dp)
                            .fillMaxWidth()
                    )
                    CommonButton(
                        text = stringResource(id = R.string.see_details_text),
                        buttonColor = Blue30,
                        textColor = White
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    CommonCard(
                        borderColor = Blue20,
                        backgroundColor = Blue20_o1,
                        textColor = Blue30,
                        text = stringResource(id = R.string.experience_result_content_2),
                        modifier = Modifier
                            .defaultMinSize(minHeight = 100.dp)
                            .fillMaxWidth()
                    )
                    CommonButton(
                        text = stringResource(id = R.string.see_details_text),
                        buttonColor = Blue30,
                        textColor = White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ExperienceScreenPreview() {
    ExperienceResultScreen()
}