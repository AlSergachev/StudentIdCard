package com.example.studentidcard.custom.model

import com.example.studentidcard.custom.model.University

class Student(
    val lastName: String = "",
    val firstName: String = "",
    val faculty: String = "",
    val formOfTraining: String = "",
    val dateOfIssue: String = "",
    val dateOfExpiry: String = "",
    val idNumber: String = "",
    val studentIdNumber: String = "",
    val imageProfile: Int,
    val university: University
)