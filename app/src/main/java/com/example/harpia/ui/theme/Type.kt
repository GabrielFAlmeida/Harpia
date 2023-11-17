package com.example.harpia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.harpia.R

private val Lato = FontFamily(
    Font(R.font.lato_light, FontWeight.Light),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 30.sp,
        lineHeight = 30.sp,
        letterSpacing = 1.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 1.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 30.sp,
        lineHeight = 30.sp,
        letterSpacing = 1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 1.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 1.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 2.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        letterSpacing = 1.sp
    ),
)