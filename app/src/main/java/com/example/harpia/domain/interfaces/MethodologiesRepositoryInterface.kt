package com.example.harpia.domain.interfaces

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.harpia.domain.classes.Methodology
import com.google.firebase.firestore.FirebaseFirestore

interface MethodologiesRepositoryInterface {
    fun getMethodologyList(
        methodologyList: SnapshotStateList<Methodology>,
        database: FirebaseFirestore
    )
}
