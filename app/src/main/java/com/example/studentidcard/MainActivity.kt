package com.example.studentidcard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentidcard.custom.view.StudentIdCardView
import com.example.studentidcard.custom.model.Student
import com.example.studentidcard.custom.model.University

class MainActivity : AppCompatActivity() {

    private val testStudent = Student(
        university = University(
            name = "Белорусский национальный технический университет",
            image = R.drawable.image_university
        ),
        imageProfile = R.drawable.image_profile,
        studentIdNumber = "1140511818",
        lastName = "Иванова",
        firstName = "Александра Александровна",
        faculty = "ФИТР",
        formOfTraining = "ДНЕВНАЯ",
        dateOfIssue = "27.08.2018",
        dateOfExpiry = "30.06.2022",
        idNumber = "0514980"
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customStudentIdCard: StudentIdCardView = findViewById(R.id.custom_student_id_card)
        customStudentIdCard.bindStudentIdCard(testStudent)

    }
}