package com.example.harpia.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.harpia.R
import com.example.harpia.domain.classes.Experience
import com.example.harpia.domain.classes.SelectOption
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonSelect
import com.example.harpia.components.CommonText
import com.example.harpia.components.CommonTextField
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.components.commonToast
import com.example.harpia.domain.classes.ExperienceRepository
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

@Composable
fun NewExperienceScreen(navController: NavController, database: FirebaseFirestore) {

    val repository = ExperienceRepository()

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
            val context = LocalContext.current
            NavigatorIconButton(
                navController = navController,
                route = Screen.HomeScreen.route,
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
                    val experienceTitle = CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_1),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    val experienceTheme = CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_2),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    val experienceSchoolClass = CommonSelect(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_3),
                        options = listOf(
                            SelectOption(stringResource(id = R.string.class_option_1), "6° ano"),
                            SelectOption(stringResource(id = R.string.class_option_2), "7° ano"),
                            SelectOption(stringResource(id = R.string.class_option_3), "8° ano"),
                            SelectOption(stringResource(id = R.string.class_option_4), "9° ano"),
                            SelectOption(
                                stringResource(id = R.string.class_option_5),
                                "1° ano do E.M."
                            ),
                            SelectOption(
                                stringResource(id = R.string.class_option_6),
                                "2° ano do E.M."
                            ),
                            SelectOption(
                                stringResource(id = R.string.class_option_7),
                                "3° ano do E.M."
                            ),
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    val experienceMethodology = CommonSelect(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_4),
                        options = listOf(
                            SelectOption(
                                stringResource(id = R.string.methodology_option_1),
                                "Sala de aula invertida"
                            ),
                            SelectOption(
                                stringResource(id = R.string.methodology_option_2),
                                "Gameficação"
                            ),
                            SelectOption(
                                stringResource(id = R.string.methodology_option_3),
                                "Aprendizagem por projeto"
                            ),
                            SelectOption(
                                stringResource(id = R.string.methodology_option_4),
                                "Design Thinking"
                            ),
                            SelectOption(
                                stringResource(id = R.string.methodology_option_5),
                                "Outra"
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    val experienceDescription = CommonTextField(
                        placeholder = stringResource(id = R.string.new_experience_input_placeholder_5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CommonButton(text = stringResource(id = R.string.save_info_text), onCLick = {
                        val experience = Experience(
                            experienceTitle,
                            experienceTheme,
                            experienceSchoolClass,
                            experienceMethodology,
                            experienceDescription
                        )

                        if(repository.validateExperience(experience)) {
                                commonToast(
                                    context,
                                    Toast.LENGTH_SHORT,
                                    "Experiência criada com sucesso."
                                )
                                repository.postExperience(experience, database)
                                navController.navigate(Screen.HomeScreen.route)
                        }else{
                            commonToast(
                                context,
                                Toast.LENGTH_LONG,
                                "Preencha todos os campos para criar uma experiência."
                            )
                        }
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun NewExperienceScreenPreview() {
    val database = Firebase.firestore
    val navController = rememberNavController()
    NewExperienceScreen(navController, database)
}