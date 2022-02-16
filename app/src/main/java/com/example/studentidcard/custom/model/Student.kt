package com.example.studentidnumber.ui.custom.model

import android.media.Image

class Student(
    val lastName: String,
    val firstName: String,
    val faculty: String,
    val formOfTraining: String,
    val dateOfIssue: String,
    val dateOfExpiry: String,
    val idNumber: String,
    val studentIdNumber: String,
    val imageProfile: Int,
    val university: University
)