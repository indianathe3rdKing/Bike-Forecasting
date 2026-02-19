package com.example.bikeforecast.presentation.util

import androidx.compose.ui.graphics.Color

fun getScoreColor(score: Int): Color {
    return when {
        score >= 80 -> Color(0xFF22C55E)// Green - Excellent
        score >= 60 -> Color(0xFF4ADE80) // Light Green - Good
        score >= 40 -> Color(0xFFFACC15) // Yellow - Moderate
        score >= 20 -> Color(0XFFF87171) // Light Red - Poor
        else -> Color(0xFFDC2626)// Red - Dangerous
    }
}

fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
