package com.example.basketballscore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Score(val localScore: String, val visitorScore: String) : Parcelable
