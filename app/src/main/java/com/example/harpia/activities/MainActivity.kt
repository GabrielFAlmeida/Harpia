package com.example.harpia.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.harpia.navigation.HarpiaAppNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            HarpiaAppNavGraph(navController)
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
    val navController = rememberNavController()
    HarpiaAppNavGraph(navController)
}