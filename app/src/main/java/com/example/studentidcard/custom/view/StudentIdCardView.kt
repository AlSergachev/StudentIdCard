package com.example.studentidcard.custom.view

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.annotation.Px
import androidx.core.content.ContextCompat
import com.example.studentidcard.R
import com.example.studentidnumber.ui.custom.model.Student


class StudentIdCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    @ColorInt private var primaryColor: Int = 0
    @ColorInt private var imageBackgroundColor: Int = 0
    @ColorInt private var headerTextColor: Int = 0
    @ColorInt private var idTextColor: Int = 0
    @ColorInt private var dataTextColor: Int = 0
    @ColorInt private var labelTextColor: Int = 0

//    @Px private var padLeft: Int = 0
//    @Px private var padRight: Int = 0
//    @Px private var padTop: Int = 0
//    @Px private var padBottom: Int = 0
//    @Px private var padInner: Int = 0

    @Px private var textSizeIdNumber: Int = 0
    @Px private var textSizeStudentId: Int = 0
    @Px private var textSizeNameUniversity: Int = 0
    @Px private var textSizeLabelStudent_id: Int = 0
    @Px private var textSizeLabelData: Int = 0
    @Px private var textSizeData: Int = 0

    private val nameUniversity: TextView
    private val imageUniversity: ImageView
    private val imageProfile: ImageView
    private val idNumber: TextView
    private val studentIdNumber: TextView
    private val studentIdNumberLabel: TextView
    private val lastName: TextView
    private val lastNameLabel: TextView
    private val firstName: TextView
    private val firstNameLabel: TextView
    private val faculty: TextView
    private val facultyLabel: TextView
    private val formOfTraining: TextView
    private val formOfTrainingLabel: TextView
    private val dateOfIssue: TextView
    private val dateOfIssueLabel: TextView
    private val dateOfExpiry: TextView
    private val dateOfExpiryLabel: TextView

    init {
        clipChildren = false
        clipToPadding = false

//        inflate(context, R.layout.student_id_card, this)

        //Prepare colors
        primaryColor = ContextCompat.getColor(context, R.color.primary_color)
        imageBackgroundColor = ContextCompat.getColor(context, R.color.image_background_color)
        headerTextColor = ContextCompat.getColor(context, R.color.header_text_color)
        idTextColor = ContextCompat.getColor(context, R.color.id_text_color)
        dataTextColor = ContextCompat.getColor(context, R.color.data_text_color)
        labelTextColor = ContextCompat.getColor(context, R.color.label_text_color)

        //Prepare text size
        textSizeIdNumber = dpToPx(18)
        textSizeStudentId = dpToPx(13)
        textSizeNameUniversity = dpToPx(10)
        textSizeLabelStudent_id = dpToPx(12)
        textSizeLabelData = dpToPx(10)
        textSizeData = dpToPx(12)


        nameUniversity = TextView(context);
        nameUniversity.textSize = textSizeNameUniversity.toFloat()
        nameUniversity.setTextColor(labelTextColor)
        addView(nameUniversity)

        imageUniversity = ImageView(context)
        imageUniversity.setImageResource(R.drawable.image_university)
        addView(imageUniversity)

        imageProfile = ImageView(context)
        imageProfile.setImageResource(R.drawable.image_profile)
        addView(imageProfile)

        idNumber = VerticalTextView(context)
        idNumber.setTextSize(textSizeIdNumber.toFloat())
        idNumber.setTextColor(idTextColor)
        addView(idNumber)

        studentIdNumberLabel = TextView(context)
        studentIdNumberLabel.setTextSize(textSizeLabelData.toFloat())
        studentIdNumberLabel.setTextColor(labelTextColor)
        addView(studentIdNumberLabel)

        studentIdNumber = TextView(context)
        studentIdNumber.setTextSize(textSizeStudentId.toFloat())
        studentIdNumber.setTextColor(dataTextColor)
        addView(studentIdNumber)

        lastNameLabel = TextView(context)
        lastNameLabel.setTextSize(textSizeLabelData.toFloat())
        lastNameLabel.setTextColor(labelTextColor)
        addView(lastNameLabel)

        lastName = TextView(context)
        lastName.setTextSize(textSizeData.toFloat())
        lastName.setTextColor(dataTextColor)
        addView(lastName)

        firstNameLabel = TextView(context)
        firstNameLabel.setTextSize(textSizeLabelData.toFloat())
        firstNameLabel.setTextColor(labelTextColor)
        addView(firstNameLabel)

        firstName = TextView(context)
        firstName.setTextSize(textSizeData.toFloat())
        firstName.setTextColor(dataTextColor)
        addView(firstName)

        facultyLabel = TextView(context)
        facultyLabel.setTextSize(textSizeLabelData.toFloat())
        facultyLabel.setTextColor(labelTextColor)
        addView(facultyLabel)

        faculty = TextView(context)
        faculty.setTextSize(textSizeData.toFloat())
        faculty.setTextColor(dataTextColor)
        addView(faculty)

        formOfTrainingLabel = TextView(context)
        formOfTrainingLabel.setTextSize(textSizeLabelData.toFloat())
        formOfTrainingLabel.setTextColor(labelTextColor)
        addView(formOfTrainingLabel)

        formOfTraining = TextView(context)
        formOfTraining.setTextSize(textSizeData.toFloat())
        formOfTraining.setTextColor(dataTextColor)
        addView(formOfTraining)

        dateOfIssueLabel = TextView(context)
        dateOfIssueLabel.setTextSize(textSizeLabelData.toFloat())
        dateOfIssueLabel.setTextColor(labelTextColor)
        addView(dateOfIssueLabel)

        dateOfIssue = TextView(context)
        dateOfIssue.setTextSize(textSizeData.toFloat())
        dateOfIssue.setTextColor(dataTextColor)
        addView(dateOfIssue)

        dateOfExpiryLabel = TextView(context)
        dateOfExpiryLabel.setTextSize(textSizeLabelData.toFloat())
        dateOfExpiryLabel.setTextColor(labelTextColor)
        addView(dateOfExpiryLabel)

        dateOfExpiry = TextView(context)
        dateOfExpiry.setTextSize(textSizeData.toFloat())
        dateOfExpiry.setTextColor(dataTextColor)
        addView(dateOfExpiry)

//        nameUniversity = findViewById(R.id.name_university)
//        imageUniversity = findViewById(R.id.image_university) //fixme: maybe AppCompatImageView
//        imageProfile = findViewById(R.id.image_profile) //fixme: maybe AppCompatImageView
//        idNumber = findViewById(R.id.id_number)
//        studentIdNumber = findViewById(R.id.student_id_number)
//        lastName = findViewById(R.id.last_name)
//        firstName = findViewById(R.id.first_name)
//        faculty = findViewById(R.id.faculty)
//        formOfTraining = findViewById(R.id.form_of_training)
//        dateOfIssue = findViewById(R.id.date_of_issue)
//        dateOfExpiry = findViewById(R.id.date_of_expiry)
    }

    @Px
    private fun dpToPx(@Dimension(unit = Dimension.DP)dp: Int): Int {
        val resources: Resources = resources
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics).toInt()
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