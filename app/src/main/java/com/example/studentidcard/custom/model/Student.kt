package com.example.studentidnumber.ui.custom.model

import android.media.Image

class Student(
    val lastName: String,
    val firstName: String,
    val faculty: String,
    val formOfTraining: String,
    val startDate: String,
    val endDate: String,
    val idNumber: String,
    val studentIdNumber: String,
    val image: Image,   //fixme
    val university: University
)