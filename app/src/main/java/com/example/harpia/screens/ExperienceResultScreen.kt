package com.example.harpia.screens

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
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
import com.example.harpia.components.CommonButton
import com.example.harpia.components.CommonCard
import com.example.harpia.components.CommonText
import com.example.harpia.components.NavigatorIconButton
import com.example.harpia.components.commonToast
import com.example.harpia.domain.classes.ExperienceRepository
import com.example.harpia.domain.classes.ExperienceSearch
import com.example.harpia.navigation.Screen
import com.example.harpia.ui.theme.Blue20
import com.example.harpia.ui.theme.Blue20_o1
import com.example.harpia.ui.theme.Blue30
import com.example.harpia.ui.theme.Purple20
import com.example.harpia.ui.theme.Typography
import com.example.harpia.ui.theme.White
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

@Composable
fun ExperienceResultScreen(
    navController: NavController,
    database: FirebaseFirestore,
    experienceSearchKeyword: String,
    experienceSearchMethodology: String,
    experienceSearchSchoolClass: String
) {

    val repository = ExperienceRepository()
    val experiences = remember { mutableStateListOf(Experience()) }

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
            val context = LocalContext.current
            val experienceSearch = ExperienceSearch(
                experienceSearchKeyword,
                experienceSearchMethodology,
                experienceSearchSchoolClass,
            )
            repository.getExperienceList(experiences, experienceSearch, database)
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
                    for (experience in experiences) {
                        Spacer(modifier = Modifier.height(30.dp))
                        CommonCard(
                            borderColor = Blue20,
                            backgroundColor = Blue20_o1,
                            textColor = Blue30,
                            text = experience.description,
                            modifier = Modifier
                                .defaultMinSize(minHeight = 100.dp)
                                .fillMaxWidth()
                        )
                        CommonButton(
                            text = stringResource(id = R.string.see_details_text),
                            buttonColor = Blue30,
                            textColor = White,
                            onCLick = {
                                commonToast(
                                    context,
                                    Toast.LENGTH_LONG,
                                    "Essa funcionalidade ainda não está disponível :("
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

fun <T> SnapshotStateList<T>.updateExperienceList(newList: List<T>) {
    clear()
    addAll(newList)
}

@Preview
@Composable
fun ExperienceScreenPreview() {
    val database = Firebase.firestore
    val navController = rememberNavController()
    val experienceSearchKeyword = "Teste descrição"
    val experienceSearchMethodology = "Teste metodologia"
    val experienceSearchSchoolClass = "6° ano"
    ExperienceResultScreen(
        navController,
        database,
        experienceSearchKeyword,
        experienceSearchMethodology,
        experienceSearchSchoolClass
    )
}