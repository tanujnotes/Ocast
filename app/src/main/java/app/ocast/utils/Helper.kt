package app.ocast.utils

import android.graphics.Color

// Generating random colors for genre cards.
// Eventually will be replaced by hardcoded color for each genre by id
fun getRandomColor(): Int {
    val start = 50
    val end = 200
    return Color.argb(255, (start..end).random(), (start..end).random(), (start..end).random())
}