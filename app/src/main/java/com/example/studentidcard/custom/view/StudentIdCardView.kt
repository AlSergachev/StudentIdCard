package com.example.studentidcard.custom.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
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

    @ColorInt
    private var primaryColor: Int = 0

    @ColorInt
    private var imageBackgroundColor: Int = 0

    @ColorInt
    private var headerTextColor: Int = 0

    @ColorInt
    private var idTextColor: Int = 0

    @ColorInt
    private var dataTextColor: Int = 0

    @ColorInt
    private var labelTextColor: Int = 0

    @Px
    private var mainHorizontalPadding: Int = 0

    @Px
    private var innerSmallPadding: Int = 0

    @Px
    private var innerLargePadding: Int = 0

    @Px
    private var innerVerticalPadding: Int = 0

    @Px
    private var imageUniversitySize: Int = 0

    @Px
    private var widthImageProfile: Int = 0

    @Px
    private var heightImageProfile: Int = 0

    @Px
    private var textSizeIdNumber: Int = 0

    @Px
    private var textSizeStudentId: Int = 0

    @Px
    private var textSizeNameUniversity: Int = 0

    @Px
    private var textSizeLabelStudentId: Int = 0

    @Px
    private var textSizeLabelData: Int = 0

    @Px
    private var textSizeData: Int = 0

    @Px
    private var cornerRadius: Int = 0

    private val nameUniversity: TextView

    //    private val imageUniversity: ImageView    fixme
    private val imageUniversity: TextView

    //    private val imageProfile: ImageView   fixme
    private val imageProfile: TextView
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

    private var paint: Paint
    private var rect: RectF


    init {
//        clipChildren = false
//        clipToPadding = false

//        inflate(context, R.layout.student_id_card, this)

        //Prepare colors
        primaryColor = ContextCompat.getColor(context, R.color.primary_color)
        imageBackgroundColor = ContextCompat.getColor(context, R.color.image_background_color)
        headerTextColor = ContextCompat.getColor(context, R.color.header_text_color)
        idTextColor = ContextCompat.getColor(context, R.color.id_text_color)
        dataTextColor = ContextCompat.getColor(context, R.color.data_text_color)
        labelTextColor = ContextCompat.getColor(context, R.color.label_text_color)

        //Prepare text size
        textSizeIdNumber = 18       //dpToPx(18)
        textSizeStudentId = 13       //dpToPx(13)
        textSizeNameUniversity = 13       //dpToPx(10)
        textSizeLabelStudentId = 16       //dpToPx(12)
        textSizeLabelData = 10       //dpToPx(10)
        textSizeData = 12       //dpToPx(12)

        //Prepare paddings
        mainHorizontalPadding = dpToPx(30)
        innerSmallPadding = dpToPx(5)
        innerLargePadding = dpToPx(15)
        innerVerticalPadding = dpToPx(10)
        cornerRadius = dpToPx(16)

        //Prepare image sizes
        imageUniversitySize = dpToPx(30)
        widthImageProfile = dpToPx(80)
        heightImageProfile = dpToPx(110)


        nameUniversity = TextView(context)
        nameUniversity.textSize = textSizeNameUniversity.toFloat()
        nameUniversity.setTextColor(labelTextColor)
        nameUniversity.gravity = Gravity.CENTER_HORIZONTAL
        addView(nameUniversity)

//        imageUniversity = ImageView(context)
//        imageUniversity.setImageResource(R.drawable.image_university)
//        addView(imageUniversity)
        imageUniversity = TextView(context)
        imageUniversity.textSize = textSizeIdNumber.toFloat()
        imageUniversity.setTextColor(idTextColor)
        imageUniversity.gravity = Gravity.CENTER
        addView(imageUniversity)

        // fixme
//        imageProfile = ImageView(context)
//        imageProfile.setImageResource(R.drawable.image_profile)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            imageProfile.foregroundGravity = Gravity.CENTER
//        }
//        addView(imageProfile)
        imageProfile = TextView(context)
        imageProfile.textSize = textSizeIdNumber.toFloat()
        imageProfile.setTextColor(idTextColor)
        imageProfile.gravity = Gravity.CENTER
        addView(imageProfile)

        idNumber = TextView(context)
//        idNumber = VerticalTextView(context)
        idNumber.textSize = textSizeIdNumber.toFloat()
        idNumber.setTextColor(idTextColor)
        idNumber.gravity = Gravity.CENTER
        addView(idNumber)

        studentIdNumberLabel = TextView(context)
        studentIdNumberLabel.textSize = textSizeLabelStudentId.toFloat()
        studentIdNumberLabel.setTextColor(headerTextColor)
        studentIdNumberLabel.gravity = Gravity.CENTER
        addView(studentIdNumberLabel)

        studentIdNumber = TextView(context)
        studentIdNumber.textSize = textSizeStudentId.toFloat()
        studentIdNumber.setTextColor(dataTextColor)
        studentIdNumber.gravity = Gravity.CENTER
        addView(studentIdNumber)

        lastNameLabel = TextView(context)
        lastNameLabel.textSize = textSizeLabelData.toFloat()
        lastNameLabel.setTextColor(labelTextColor)
        addView(lastNameLabel)

        lastName = TextView(context)
        lastName.textSize = textSizeData.toFloat()
        lastName.setTextColor(dataTextColor)
        addView(lastName)

        firstNameLabel = TextView(context)
        firstNameLabel.textSize = textSizeLabelData.toFloat()
        firstNameLabel.setTextColor(labelTextColor)
        addView(firstNameLabel)

        firstName = TextView(context)
        firstName.textSize = textSizeData.toFloat()
        firstName.setTextColor(dataTextColor)
        addView(firstName)

        facultyLabel = TextView(context)
        facultyLabel.textSize = textSizeLabelData.toFloat()
        facultyLabel.setTextColor(labelTextColor)
        addView(facultyLabel)

        faculty = TextView(context)
        faculty.textSize = textSizeData.toFloat()
        faculty.setTextColor(dataTextColor)
        addView(faculty)

        formOfTrainingLabel = TextView(context)
        formOfTrainingLabel.textSize = textSizeLabelData.toFloat()
        formOfTrainingLabel.setTextColor(labelTextColor)
        addView(formOfTrainingLabel)

        formOfTraining = TextView(context)
        formOfTraining.textSize = textSizeData.toFloat()
        formOfTraining.setTextColor(dataTextColor)
        addView(formOfTraining)

        dateOfIssueLabel = TextView(context)
        dateOfIssueLabel.textSize = textSizeLabelData.toFloat()
        dateOfIssueLabel.setTextColor(labelTextColor)
        addView(dateOfIssueLabel)

        dateOfIssue = TextView(context)
        dateOfIssue.textSize = textSizeData.toFloat()
        dateOfIssue.setTextColor(dataTextColor)
        addView(dateOfIssue)

        dateOfExpiryLabel = TextView(context)
        dateOfExpiryLabel.textSize = textSizeLabelData.toFloat()
        dateOfExpiryLabel.setTextColor(labelTextColor)
        addView(dateOfExpiryLabel)

        dateOfExpiry = TextView(context)
        dateOfExpiry.textSize = textSizeData.toFloat()
        dateOfExpiry.setTextColor(dataTextColor)
        addView(dateOfExpiry)

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        rect = RectF()

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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val widthView = dpToPx(340)
//        val heightView = dpToPx(220)
        val widthView: Int = dpToPx(340)
        val heightView: Int = dpToPx(220)
//        widthView = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
//        heightView = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)

        val widthTextNameUniversity: Int = widthView - 2 * mainHorizontalPadding
        val widthTextDataLabel: Int =
            widthTextNameUniversity - widthImageProfile - innerLargePadding
        val widthTextData: Int = widthTextDataLabel - innerSmallPadding
        val widthTextDateLabel: Int = (widthTextDataLabel + innerSmallPadding) / 2
        val widthTextDate: Int = widthTextDateLabel - innerSmallPadding
        val widthTextStudentIdNumber: Int =
            (widthTextNameUniversity - imageUniversitySize - innerSmallPadding) / 3
        val widthTextStudentIdNumberLabel: Int =
            widthTextNameUniversity - imageUniversitySize - innerSmallPadding - widthTextStudentIdNumber

        nameUniversity.maxWidth = widthTextNameUniversity
        nameUniversity.minimumWidth = widthTextNameUniversity

        imageUniversity.minimumHeight = imageUniversitySize
        imageUniversity.minimumWidth = imageUniversitySize
        imageUniversity.maxWidth = imageUniversitySize
        imageUniversity.maxHeight = imageUniversitySize

        studentIdNumberLabel.maxWidth = widthTextStudentIdNumberLabel
        studentIdNumberLabel.maxHeight = imageUniversitySize
        studentIdNumberLabel.minimumWidth = widthTextStudentIdNumberLabel
        studentIdNumberLabel.minimumHeight = imageUniversitySize

        studentIdNumber.maxWidth = widthTextStudentIdNumber
        studentIdNumber.minimumWidth = widthTextStudentIdNumber
        studentIdNumber.maxHeight = imageUniversitySize
        studentIdNumber.minimumHeight = imageUniversitySize

        imageProfile.maxWidth = widthImageProfile
        imageProfile.maxHeight = heightImageProfile
        imageProfile.minimumWidth = widthImageProfile
        imageProfile.minimumHeight = heightImageProfile

        lastNameLabel.maxWidth = widthTextDataLabel
        firstNameLabel.maxWidth = widthTextDataLabel
        facultyLabel.maxWidth = widthTextDataLabel
        formOfTrainingLabel.maxWidth = widthTextDataLabel
        lastName.maxWidth = widthTextData
        firstName.maxWidth = widthTextData
        faculty.maxWidth = widthTextData
        formOfTraining.maxWidth = widthTextData
        dateOfIssueLabel.maxWidth = widthTextDateLabel
        dateOfIssue.maxWidth = widthTextDate
        dateOfExpiryLabel.maxWidth = widthTextDateLabel
        dateOfExpiry.maxWidth = widthTextDate

        idNumber.maxHeight = heightMeasureSpec
        idNumber.minimumHeight = heightMeasureSpec
//        idNumber.maxWidth = mainHorizontalPadding   //fixme: idNumber.maxWidth = heightView
        idNumber.maxWidth = mainHorizontalPadding   //fixme: idNumber.maxWidth = mainHorizontalPadding
        idNumber.minimumWidth = mainHorizontalPadding   //fixme: idNumber.minimumWidth = mainHorizontalPadding

        measureChild(nameUniversity, widthTextNameUniversity, innerVerticalPadding)
        measureChild(imageUniversity, imageUniversitySize, imageUniversitySize)
        measureChild(studentIdNumberLabel, widthTextStudentIdNumberLabel, imageUniversitySize)
        measureChild(studentIdNumber, widthTextStudentIdNumber, imageUniversitySize)
        measureChild(imageProfile, widthImageProfile, heightImageProfile)
        measureChild(lastNameLabel, widthTextDataLabel, innerVerticalPadding)
        measureChild(firstNameLabel, widthTextDataLabel, innerVerticalPadding)
        measureChild(facultyLabel, widthTextDataLabel, innerVerticalPadding)
        measureChild(formOfTrainingLabel, widthTextDataLabel, innerVerticalPadding)
        measureChild(lastName, widthTextData, innerVerticalPadding)
        measureChild(firstName, widthTextData, innerVerticalPadding)
        measureChild(faculty, widthTextData, innerVerticalPadding)
        measureChild(formOfTraining, widthTextData, innerVerticalPadding)
        measureChild(dateOfIssueLabel, widthTextDateLabel, innerVerticalPadding)
        measureChild(dateOfIssue, widthTextDate, innerVerticalPadding)
        measureChild(dateOfExpiryLabel, widthTextDateLabel, innerVerticalPadding)
        measureChild(dateOfExpiry, widthTextDate, innerVerticalPadding)
        measureChild(
            idNumber,
            mainHorizontalPadding,
            heightView
        ) //fixme:measureChild(idNumber, heightView, mainHorizontalPadding)

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
//        setMeasuredDimension(widthView, heightView)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {

//        val padding = 72
        val padding = paddingLeft
        val sRight = right - padding
        val sLeft = left - padding


        val leftBorder = sLeft + mainHorizontalPadding
        val rightBorder = sRight - mainHorizontalPadding
        val leftBorderDataLabel = leftBorder + widthImageProfile + innerLargePadding
        val leftBorderData = leftBorderDataLabel + innerSmallPadding
        val rightBorderDateOfIssue: Int = leftBorderDataLabel + (rightBorder - leftBorderDataLabel) / 2

        var heightUsed = innerVerticalPadding
        var widthUsed = leftBorder

        nameUniversity.layout(
            leftBorder,
            heightUsed,
            rightBorder,
            heightUsed + nameUniversity.measuredHeight
        )

        heightUsed += nameUniversity.measuredHeight + innerVerticalPadding

        imageUniversity.layout(
            widthUsed,
            heightUsed,
            leftBorder + imageUniversity.measuredWidth,
            heightUsed + imageUniversity.measuredHeight
        )

        widthUsed += imageUniversity.width + innerSmallPadding

        studentIdNumber.layout(
            rightBorder - studentIdNumber.measuredWidth,
            heightUsed,
            rightBorder,
            heightUsed + imageUniversity.measuredHeight
        )
        studentIdNumberLabel.layout(
            widthUsed,
            heightUsed,
            rightBorder - studentIdNumber.measuredWidth,
            heightUsed + imageUniversity.measuredHeight
        )
        imageProfile.layout(
            leftBorder,
            heightUsed + imageUniversity.measuredHeight,
            leftBorder + imageProfile.measuredWidth,
            bottom
        )

        heightUsed += imageUniversity.measuredHeight + innerVerticalPadding

        lastNameLabel.layout(
            leftBorderDataLabel,
            heightUsed,
            rightBorder,
            heightUsed + lastNameLabel.measuredHeight
        )
        heightUsed += lastNameLabel.measuredHeight

        lastName.layout(
            leftBorderData,
            heightUsed,
            rightBorder,
            heightUsed + lastName.measuredHeight
        )
        heightUsed += lastName.measuredHeight

        firstNameLabel.layout(
            leftBorderDataLabel,
            heightUsed,
            rightBorder,
            heightUsed + firstNameLabel.measuredHeight
        )
        heightUsed += firstNameLabel.measuredHeight

        firstName.layout(
            leftBorderData,
            heightUsed,
            rightBorder,
            heightUsed + firstName.measuredHeight
        )
        heightUsed += firstName.measuredHeight

        facultyLabel.layout(
            leftBorderDataLabel,
            heightUsed,
            rightBorder,
            heightUsed + facultyLabel.measuredHeight
        )
        heightUsed += facultyLabel.measuredHeight

        faculty.layout(
            leftBorderData,
            heightUsed,
            rightBorder,
            heightUsed + faculty.measuredHeight
        )
        heightUsed += faculty.measuredHeight

        formOfTrainingLabel.layout(
            leftBorderDataLabel,
            heightUsed,
            rightBorder,
            heightUsed + formOfTrainingLabel.measuredHeight
        )
        heightUsed += formOfTrainingLabel.measuredHeight

        formOfTraining.layout(
            leftBorderData,
            heightUsed,
            rightBorder,
            heightUsed + formOfTraining.measuredHeight
        )
        heightUsed += formOfTraining.measuredHeight

        dateOfIssueLabel.layout(
            leftBorderDataLabel,
            heightUsed,
            rightBorderDateOfIssue,
            heightUsed + dateOfIssueLabel.measuredHeight
        )
        dateOfExpiryLabel.layout(
            rightBorderDateOfIssue + innerSmallPadding,
            heightUsed,
            rightBorder,
            heightUsed + dateOfExpiryLabel.measuredHeight
        )
        heightUsed += dateOfExpiryLabel.measuredHeight.coerceAtLeast(dateOfIssueLabel.measuredHeight)

        dateOfIssue.layout(
            leftBorderData,
            heightUsed,
            rightBorderDateOfIssue,
            heightUsed + dateOfIssue.measuredHeight
        )
        dateOfExpiry.layout(
            rightBorderDateOfIssue + innerSmallPadding + innerSmallPadding,
            heightUsed,
            rightBorder,
            heightUsed + dateOfExpiry.measuredHeight
        )

        idNumber.layout(
            sRight - mainHorizontalPadding,
            0,
            sRight,
            bottom)
    }


    override fun dispatchDraw(canvas: Canvas?) {
        val width: Float = canvas!!.width.toFloat()
        val height: Float = canvas.height.toFloat()
        paint.color = primaryColor
        rect.set(0.0F, 0.0F, width, height)
        canvas.drawRoundRect(rect, cornerRadius.toFloat(), cornerRadius.toFloat(),paint)
        super.dispatchDraw(canvas)
    }


    private fun dpToPx(@Dimension(unit = Dimension.DP) dp: Int): Int {
        val resources: Resources = resources
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics)
            .toInt()
    }

//    private fun dpToPx(dp: Int): Int {
//        val displayMetrics = context.resources.displayMetrics
//        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
//    }

//    private fun dpToPx(dp: Int) =
//        (dp * context.resources.displayMetrics.density).toInt()

    fun bindStudentIdCard(student: Student) {
        nameUniversity.text = student.university.name
//        imageUniversity.setImageResource(student.university.image)
        imageUniversity.text = "IU"
//        imageProfile.setImageResource(student.imageProfile)
        imageProfile.text = "ImPr"
        studentIdNumberLabel.text = "Студенческий билет №"
//        idNumber.text = "10"
        idNumber.text = student.idNumber
        studentIdNumber.text = student.studentIdNumber
        lastNameLabel.text = "Фамилия"
        lastName.text = student.lastName
        firstNameLabel.text = "Имя и отчетсво"
        firstName.text = student.firstName
        facultyLabel.text = "Факультет"
        faculty.text = student.faculty
        formOfTrainingLabel.text = "Форма обучения"
        formOfTraining.text = student.formOfTraining
        dateOfIssueLabel.text = "Дата выдачи билета"
        dateOfIssue.text = student.dateOfIssue
        dateOfExpiryLabel.text = "Действителен до"
        dateOfExpiry.text = student.dateOfExpiry
    }


}