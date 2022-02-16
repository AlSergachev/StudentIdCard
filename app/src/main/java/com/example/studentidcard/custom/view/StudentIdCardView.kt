package com.example.studentidcard.custom.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.studentidcard.R
import com.example.studentidnumber.ui.custom.model.Student


class StudentIdCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val nameUniversity: TextView
    private val imageUniversity: ImageView
    private val imageProfile: ImageView
    private val idNumber: TextView
    private val studentIdNumber: TextView
    private val lastName: TextView
    private val firstName: TextView
    private val faculty: TextView
    private val formOfTraining: TextView
    private val dateOfIssue: TextView
    private val dateOfExpiry: TextView

    init {
        clipChildren = false
        clipToPadding = false

        inflate(context, R.layout.student_id_card, this)

        nameUniversity = findViewById(R.id.name_university)
        imageUniversity = findViewById(R.id.image_university) //fixme: maybe AppCompatImageView
        imageProfile = findViewById(R.id.image_profile) //fixme: maybe AppCompatImageView
        idNumber = findViewById(R.id.id_number)
        studentIdNumber = findViewById(R.id.student_id_number)
        lastName = findViewById(R.id.last_name)
        firstName = findViewById(R.id.first_name)
        faculty = findViewById(R.id.faculty)
        formOfTraining = findViewById(R.id.form_of_training)
        dateOfIssue = findViewById(R.id.date_of_issue)
        dateOfExpiry = findViewById(R.id.date_of_expiry)
    }

    fun bindStudentIdCard(student: Student){
        nameUniversity.text = student.university.name
        imageUniversity.setImageResource(student.university.image)
        imageProfile.setImageResource(student.imageProfile)
        idNumber.text = student.idNumber
        studentIdNumber.text = student.studentIdNumber
        lastName.text = student.lastName
        firstName.text = student.firstName
        faculty.text = student.faculty
        formOfTraining.text = student.formOfTraining
        dateOfIssue.text = student.dateOfIssue
        dateOfExpiry.text = student.dateOfExpiry
    }



}