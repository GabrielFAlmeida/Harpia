package com.example.harpia.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.harpia.app.HarpiaApp
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val database = Firebase.database //Caminho para encontrar o banco na nuvem.
            val databaseReference = database.getReference("experiences")
            HarpiaApp(databaseReference)
        }
    }

    /*private fun signInWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "signInWithEmailAndPassword: Success")
                firebaseAuth.currentUser
            } else {
                Log.d(TAG, "signInWithEmailAndPassword: Failure", task.exception)
                Toast.makeText(baseContext, "Firebase Authetication Failure", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun HarpiaAppPreview() {
    val database = Firebase.database //Caminho para encontrar o banco na nuvem.
    val databaseReference = database.getReference("experiences")
    HarpiaApp(databaseReference)
}