package com.example.harpia.domain.interfaces

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.harpia.domain.classes.Experience
import com.example.harpia.domain.classes.ExperienceSearch
import com.google.firebase.firestore.FirebaseFirestore

interface ExperienceRepositoryInterface {
    fun getExperienceList(
        experiences: SnapshotStateList<Experience>,
        experienceSearch: ExperienceSearch,
        database: FirebaseFirestore
    )
    fun postExperience(experience: Experience, firebaseFirestore: FirebaseFirestore)
    fun validateExperience(experience: Experience): Boolean
}
