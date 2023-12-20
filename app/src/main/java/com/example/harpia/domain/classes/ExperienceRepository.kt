package com.example.harpia.domain.classes

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.harpia.domain.constants.EXPERIENCE_COLLECTION
import com.example.harpia.domain.interfaces.ExperienceRepositoryInterface
import com.example.harpia.screens.updateExperienceList
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Singleton

@Singleton
class ExperienceRepository() : ExperienceRepositoryInterface {
    override fun validateExperience(experience: Experience): Boolean {
        if (experience.title.isBlank() || experience.title.isEmpty()) {
            return false
        } else if (experience.theme.isBlank() || experience.theme.isEmpty()) {
            return false
        } else if (experience.schoolClass.isBlank() || experience.schoolClass.isEmpty()) {
            return false
        } else if (experience.methodology.isBlank() || experience.methodology.isEmpty()) {
            return false
        } else if (experience.description.isBlank() || experience.description.isEmpty()) {
            return false
        } else {
            return true
        }
    }

    override fun postExperience(
        experience: Experience,
        database: FirebaseFirestore
    ) {
        database.collection(EXPERIENCE_COLLECTION).add(experience)
    }

    override fun getExperienceList(
        experienceList: SnapshotStateList<Experience>,
        experienceSearch: ExperienceSearch,
        database: FirebaseFirestore
    ) {
        val databaseCollection = database.collection(EXPERIENCE_COLLECTION)
        databaseCollection.whereEqualTo("title", experienceSearch.experienceSearchKeyword /*"Teste"*/)
            .whereEqualTo("methodology", experienceSearch.experienceSearchMethodology /*"Design Thinking"*/)
            .whereEqualTo("schoolClass", experienceSearch.experienceSearchSchoolClass /*"3° ano do E.M."*/)
            .get()
            .addOnSuccessListener {
                //Log.i("DTO result", "${it.toObjects(Experience::class.java)}")
                experienceList.updateExperienceList(it.toObjects(Experience::class.java))
            }.addOnFailureListener {
            experienceList.updateExperienceList(emptyList())
        }
    }

}
