package com.example.harpia.domain.classes

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.harpia.domain.constants.METHODOLOGIES_COLLECTION
import com.example.harpia.domain.interfaces.MethodologiesRepositoryInterface
import com.example.harpia.screens.updateMethodologyList
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Singleton

@Singleton
class MethodologiesRepository() : MethodologiesRepositoryInterface {
    override fun getMethodologyList(
        methodologyList: SnapshotStateList<Methodology>,
        database: FirebaseFirestore
    ) {
        val databaseCollection = database.collection(METHODOLOGIES_COLLECTION)

        databaseCollection.get().addOnSuccessListener {
            methodologyList.updateMethodologyList(it.toObjects(Methodology::class.java))
        }.addOnFailureListener {
            methodologyList.updateMethodologyList(emptyList())
        }
    }

}
