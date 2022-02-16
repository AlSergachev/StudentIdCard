package com.example.studentidcard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.studentidcard.custom.view.StudentIdCardView
import com.example.studentidnumber.ui.custom.model.Student
import com.example.studentidnumber.ui.custom.model.University

class MainActivity : AppCompatActivity() {

    private val testStudent = Student(
        university = University(
            name = "Белорусский национальный технический университет",
            image = R.drawable.image_university
        ),
        imageProfile = R.drawable.image_profile,
        idNumber = "0513980",
        studentIdNumber = "1140511818",
        lastName = "Иванов",
        firstName = "Александр Александрович",
        faculty = "ФИТР",
        formOfTraining = "ДНЕВНАЯ",
        dateOfIssue = "27.08.2018",
        dateOfExpiry = "30.06.2022"
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title: TextView = findViewById(R.id.title)
        val xmlStudentIdCard: View = findViewById(R.id.xml_student_id_card)

        val nameUniversity: TextView = xmlStudentIdCard.findViewById(R.id.name_university)
        val imageUniversity: ImageView = xmlStudentIdCard.findViewById(R.id.image_university) //fixme: maybe AppCompatImageView
        val imageProfile: ImageView = xmlStudentIdCard.findViewById(R.id.image_profile) //fixme: maybe AppCompatImageView
        val idNumber: TextView = xmlStudentIdCard.findViewById(R.id.id_number)
        val studentIdNumber: TextView = xmlStudentIdCard.findViewById(R.id.student_id_number)
        val lastName: TextView = xmlStudentIdCard.findViewById(R.id.last_name)
        val firstName: TextView = xmlStudentIdCard.findViewById(R.id.first_name)
        val faculty: TextView = xmlStudentIdCard.findViewById(R.id.faculty)
        val formOfTraining: TextView = xmlStudentIdCard.findViewById(R.id.form_of_training)
        val dateOfIssue: TextView = xmlStudentIdCard.findViewById(R.id.date_of_issue)
        val dateOfExpiry: TextView = xmlStudentIdCard.findViewById(R.id.date_of_expiry)


        title.text = "Custom View StudentIdCard"
        nameUniversity.text = testStudent.university.name
        imageUniversity.setImageResource(testStudent.university.image)
        imageProfile.setImageResource(testStudent.imageProfile)
        idNumber.text = testStudent.idNumber
        studentIdNumber.text = testStudent.studentIdNumber
        lastName.text = testStudent.lastName
        firstName.text = testStudent.firstName
        faculty.text = testStudent.faculty
        formOfTraining.text = testStudent.formOfTraining
        dateOfIssue.text = testStudent.dateOfIssue
        dateOfExpiry.text = testStudent.dateOfExpiry


        val customStudentIdCard: StudentIdCardView = findViewById(R.id.custom_student_id_card)
        customStudentIdCard.bindStudentIdCard(testStudent)


    }
}