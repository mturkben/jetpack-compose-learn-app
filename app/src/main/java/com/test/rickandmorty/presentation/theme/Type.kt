package com.test.rickandmorty.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.test.rickandmorty.R

private val Montserrat = FontFamily(
    Font(R.font.montserrat_light, weight = FontWeight.Light),
    Font(R.font.montserrat_thin, weight = FontWeight.ExtraLight),
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(R.font.montserrat_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(R.font.montserrat_black, weight = FontWeight.Black),
)

// Set of Material typography styles to start with
val MediumType = Typography(
    h1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 6.sp
    ),
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    overline = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )
)

val NormalType = Typography(
    h1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 6.sp
    ),
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    overline = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)


val LightType = Typography(
    h1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 36.sp
    ),
    h2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 24.sp
    ),
    h4 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 6.sp
    ),
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    overline = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp
    )
)