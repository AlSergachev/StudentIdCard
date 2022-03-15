package com.example.studentidcard.custom.view

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import com.example.studentidcard.R
import com.example.studentidcard.custom.model.Student


@Suppress("DEPRECATION")
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
    private var heightTextDataLabel: Int = 0

    @Px
    private var textSizeIdNumber: Float = 0.0F

    @Px
    private var textSizeStudentId: Float = 0.0F

    @Px
    private var textSizeNameUniversity: Float = 0.0F

    @Px
    private var textSizeLabelStudentId: Float = 0.0F

    @Px
    private var textSizeLabelData: Float = 0.0F

    @Px
    private var textSizeData: Float = 0.0F

    @Px
    private var cornerRadius: Float = 0.0F

    private val nameUniversity: TextView
    private val imageUniversity: ImageView
    private val imageProfile: ImageView
    private val idNumber: VerticalTextView
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

    private lateinit var nameUniversityStr: String
    private lateinit var idNumberStr: String
    private lateinit var studentIdNumberStr: String
    private lateinit var lastNameStr: String
    private lateinit var firstNameStr: String
    private lateinit var facultyStr: String
    private lateinit var formOfTrainingStr: String
    private lateinit var dateOfIssueStr: String
    private lateinit var dateOfExpiryStr: String

    private var paint: Paint
    private var rect: RectF

    private lateinit var imageUniversityBitmap: Bitmap
    private lateinit var imageProfileBitmap: Bitmap

    init {
        clipChildren = false
        clipToPadding = false

        //Prepare text size
        textSizeIdNumber = setDp(18)
        textSizeStudentId = setDp(13)
        textSizeNameUniversity = setDp(11)
        textSizeLabelStudentId = setDp(13)
        textSizeLabelData = setDp(9)
        textSizeData = setDp(12)

        //Prepare paddings
        mainHorizontalPadding = dpToPx(30)
        innerSmallPadding = dpToPx(5)
        innerLargePadding = dpToPx(15)
        innerVerticalPadding = dpToPx(10)
        cornerRadius = dpToPx(16).toFloat()

        //Prepare image sizes
        imageUniversitySize = dpToPx(30)
        widthImageProfile = dpToPx(80)
        heightImageProfile = dpToPx(110)
        heightTextDataLabel = dpToPx(11)

        initialize(context, attrs, defStyleAttr)

        nameUniversity = TextView(context)
        nameUniversity.textSize = textSizeNameUniversity
        nameUniversity.setTextColor(labelTextColor)
        nameUniversity.gravity = Gravity.CENTER_HORIZONTAL
        nameUniversity.text = nameUniversityStr
        addView(nameUniversity)

        imageUniversity = ImageView(context)
        setImageUniversity(R.drawable.image_university)
        imageUniversity.setBackgroundResource(R.drawable.shape_image_university)
        imageUniversity.clipToOutline = true
        addView(imageUniversity)

        imageProfile = ImageView(context)
        setImageProfile(R.drawable.image_profile)
        imageProfile.setBackgroundResource(R.drawable.shape_image_profile)
        imageProfile.clipToOutline = true
        addView(imageProfile)

        idNumber = VerticalTextView(context)
        idNumber.textSize = textSizeIdNumber
        idNumber.setTextColor(idTextColor)
        idNumber.gravity = Gravity.CENTER
        idNumber.setDirection(VerticalTextView.ORIENTATION_DOWN_TO_UP)
        idNumber.fontFeatureSettings = "tnum, onum"
        idNumber.letterSpacing = 0.15F
        idNumber.text = idNumberStr
        addView(idNumber)

        studentIdNumberLabel = TextView(context)
        studentIdNumberLabel.textSize = textSizeLabelStudentId
        studentIdNumberLabel.setTextColor(headerTextColor)
        studentIdNumberLabel.setTypeface(null, Typeface.BOLD)
        studentIdNumberLabel.gravity = Gravity.CENTER
        studentIdNumberLabel.isAllCaps = true
        studentIdNumberLabel.text = "Студенческий билет №"
        addView(studentIdNumberLabel)

        studentIdNumber = TextView(context)
        studentIdNumber.textSize = textSizeStudentId
        studentIdNumber.setTextColor(dataTextColor)
        studentIdNumber.setTypeface(null, Typeface.BOLD)
        studentIdNumber.gravity = Gravity.CENTER
        studentIdNumber.text = studentIdNumberStr
        addView(studentIdNumber)

        lastNameLabel = TextView(context)
        lastNameLabel.textSize = textSizeLabelData
        lastNameLabel.setTextColor(labelTextColor)
        lastNameLabel.gravity = Gravity.TOP
        lastNameLabel.text = "Фамилия"
        addView(lastNameLabel)

        lastName = TextView(context)
        lastName.textSize = textSizeData
        lastName.setTextColor(dataTextColor)
        lastName.setTypeface(null, Typeface.BOLD)
        lastName.text = lastNameStr
        addView(lastName)

        firstNameLabel = TextView(context)
        firstNameLabel.textSize = textSizeLabelData
        firstNameLabel.setTextColor(labelTextColor)
        firstNameLabel.gravity = Gravity.TOP
        firstNameLabel.text = "Имя и отчетсво"
        addView(firstNameLabel)

        firstName = TextView(context)
        firstName.textSize = textSizeData
        firstName.setTextColor(dataTextColor)
        firstName.setTypeface(null, Typeface.BOLD)
        firstName.text = firstNameStr
        addView(firstName)

        facultyLabel = TextView(context)
        facultyLabel.textSize = textSizeLabelData
        facultyLabel.setTextColor(labelTextColor)
        facultyLabel.gravity = Gravity.TOP
        facultyLabel.text = "Факультет"
        addView(facultyLabel)

        faculty = TextView(context)
        faculty.textSize = textSizeData
        faculty.setTextColor(dataTextColor)
        faculty.setTypeface(null, Typeface.BOLD)
        faculty.text = facultyStr
        addView(faculty)

        formOfTrainingLabel = TextView(context)
        formOfTrainingLabel.textSize = textSizeLabelData
        formOfTrainingLabel.setTextColor(labelTextColor)
        formOfTrainingLabel.gravity = Gravity.TOP
        formOfTrainingLabel.text = "Форма обучения"
        addView(formOfTrainingLabel)

        formOfTraining = TextView(context)
        formOfTraining.textSize = textSizeData
        formOfTraining.setTextColor(dataTextColor)
        formOfTraining.setTypeface(null, Typeface.BOLD)
        formOfTraining.text = formOfTrainingStr
        addView(formOfTraining)

        dateOfIssueLabel = TextView(context)
        dateOfIssueLabel.textSize = textSizeLabelData
        dateOfIssueLabel.setTextColor(labelTextColor)
        dateOfIssueLabel.gravity = Gravity.TOP
        dateOfIssueLabel.text = "Дата выдачи"
        addView(dateOfIssueLabel)

        dateOfIssue = TextView(context)
        dateOfIssue.textSize = textSizeData
        dateOfIssue.setTextColor(dataTextColor)
        dateOfIssue.setTypeface(null, Typeface.BOLD)
        dateOfIssue.text = dateOfIssueStr
        addView(dateOfIssue)

        dateOfExpiryLabel = TextView(context)
        dateOfExpiryLabel.textSize = textSizeLabelData
        dateOfExpiryLabel.setTextColor(labelTextColor)
        dateOfExpiryLabel.gravity = Gravity.TOP
        dateOfExpiryLabel.text = "Действителен до"
        addView(dateOfExpiryLabel)

        dateOfExpiry = TextView(context)
        dateOfExpiry.textSize = textSizeData
        dateOfExpiry.setTextColor(dataTextColor)
        dateOfExpiry.setTypeface(null, Typeface.BOLD)
        dateOfExpiry.text = dateOfExpiryStr
        addView(dateOfExpiry)

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        rect = RectF()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthView: Int = dpToPx(340)
        val heightView: Int = dpToPx(220)

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

        studentIdNumberLabel.maxWidth = widthTextStudentIdNumberLabel
        studentIdNumberLabel.maxHeight = imageUniversitySize
        studentIdNumberLabel.minimumWidth = widthTextStudentIdNumberLabel
        studentIdNumberLabel.minimumHeight = imageUniversitySize

        studentIdNumber.maxWidth = widthTextStudentIdNumber
        studentIdNumber.minimumWidth = widthTextStudentIdNumber
        studentIdNumber.maxHeight = imageUniversitySize
        studentIdNumber.minimumHeight = imageUniversitySize

        lastNameLabel.maxWidth = widthTextDataLabel
        lastNameLabel.maxHeight = heightTextDataLabel
        lastNameLabel.minimumHeight = heightTextDataLabel
        firstNameLabel.maxWidth = widthTextDataLabel
        firstNameLabel.maxHeight = heightTextDataLabel
        firstNameLabel.minimumHeight = heightTextDataLabel
        facultyLabel.maxWidth = widthTextDataLabel
        facultyLabel.maxHeight = heightTextDataLabel
        facultyLabel.minimumHeight = heightTextDataLabel
        formOfTrainingLabel.maxWidth = widthTextDataLabel
        formOfTrainingLabel.maxHeight = heightTextDataLabel
        formOfTrainingLabel.minimumHeight = heightTextDataLabel
        lastName.maxWidth = widthTextData
        firstName.maxWidth = widthTextData
        faculty.maxWidth = widthTextData
        formOfTraining.maxWidth = widthTextData
        dateOfIssueLabel.maxWidth = widthTextDateLabel
        dateOfIssueLabel.maxHeight = heightTextDataLabel
        dateOfIssueLabel.minimumHeight = heightTextDataLabel
        dateOfIssue.maxWidth = widthTextDate
        dateOfExpiryLabel.maxWidth = widthTextDateLabel
        dateOfExpiryLabel.maxHeight = heightTextDataLabel
        dateOfExpiryLabel.minimumHeight = heightTextDataLabel
        dateOfExpiry.maxWidth = widthTextDate

        idNumber.maxHeight = heightMeasureSpec
        idNumber.minimumHeight = heightMeasureSpec
        idNumber.maxWidth = heightMeasureSpec
        idNumber.minimumWidth = mainHorizontalPadding

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
        measureChild(idNumber, heightView, mainHorizontalPadding)

        setMeasuredDimension(widthView, heightView)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {

        val padding = paddingLeft
        val sRight = right - padding
        val sLeft = left - padding

        val leftBorder = sLeft + mainHorizontalPadding
        val rightBorder = sRight - mainHorizontalPadding
        val leftBorderDataLabel = leftBorder + widthImageProfile + innerLargePadding
        val leftBorderData = leftBorderDataLabel + innerSmallPadding
        val rightBorderDateOfIssue: Int =
            leftBorderDataLabel + (rightBorder - leftBorderDataLabel) / 2

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
        heightUsed += imageUniversity.measuredHeight
        val imageProfileCenterVert: Int = ((heightUsed + bottom) / 2)

        imageProfile.layout(
            leftBorder,
            imageProfileCenterVert - imageProfile.measuredHeight / 2,
            leftBorder + imageProfile.measuredWidth,
            imageProfileCenterVert + imageProfile.measuredHeight / 2 + 1
        )
        heightUsed += innerVerticalPadding

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
            bottom
        )
    }

    override fun dispatchDraw(canvas: Canvas?) {
        val width: Float = canvas!!.width.toFloat()
        val height: Float = canvas.height.toFloat()

        paint.color = primaryColor
        rect.set(0.0F, 0.0F, width, height)
        canvas.save()
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)

        super.dispatchDraw(canvas)
    }

    private fun resizeImage(idRes: Int, resWidth: Int, resHeight: Int): Bitmap {
        val image: Bitmap = BitmapFactory.decodeResource(resources, idRes)
        val matrix = Matrix()
        val src = RectF(0.0F, 0.0F, image.width.toFloat(), image.height.toFloat())
        val dst = RectF(0.0F, 0.0F, resWidth.toFloat(), resHeight.toFloat())
        matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER)
        return Bitmap.createBitmap(image, 0, 0, image.width, image.height, matrix, true)
    }

    private fun View.addViewObserver(function: () -> Unit) {
        val view = this
        view.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                function.invoke()
            }
        })
    }

    private fun dpToPx(@Dimension(unit = Dimension.DP) dp: Int): Int {
        val resources: Resources = resources
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), displayMetrics)
            .toInt()
    }

    private fun setDp(value: Int): Float {
        val resources: Resources = resources
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        return (value * displayMetrics.density) / (displayMetrics.scaledDensity)
    }

    private fun initialize(context: Context, attrs: AttributeSet?, defStyle: Int) {
        val styledAttributes =
            context.obtainStyledAttributes(attrs, R.styleable.StudentIdCardView, defStyle, 0)
        try {
            primaryColor = styledAttributes.getColor(
                R.styleable.StudentIdCardView_primary_color,
                resources.getColor(R.color.primary_color)
            )
            headerTextColor = styledAttributes.getColor(
                R.styleable.StudentIdCardView_header_text_color,
                resources.getColor(R.color.header_text_color)
            )
            idTextColor = styledAttributes.getColor(
                R.styleable.StudentIdCardView_id_text_color,
                resources.getColor(R.color.id_text_color)
            )
            dataTextColor = styledAttributes.getColor(
                R.styleable.StudentIdCardView_data_text_color,
                resources.getColor(R.color.data_text_color)
            )
            labelTextColor = styledAttributes.getColor(
                R.styleable.StudentIdCardView_label_text_color,
                resources.getColor(R.color.label_text_color)
            )
            nameUniversityStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_name_university
            ).toString()
            idNumberStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_id_number
            ).toString()
            studentIdNumberStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_student_id_number
            ).toString()
            lastNameStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_last_name
            ).toString()
            firstNameStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_first_name
            ).toString()

            facultyStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_faculty
            ).toString()
            formOfTrainingStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_form_of_training
            ).toString()
            dateOfIssueStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_date_of_issue
            ).toString()
            dateOfExpiryStr = styledAttributes.getString(
                R.styleable.StudentIdCardView_date_of_expiry
            ).toString()

        } finally {
            styledAttributes.recycle()
        }
    }

    private fun setImageUniversity(@DrawableRes resId: Int) {
        imageUniversity.addViewObserver {
            imageUniversityBitmap = resizeImage(
                resId,
                imageUniversitySize,
                imageUniversitySize
            )
            imageUniversity.setImageBitmap(imageUniversityBitmap)
        }
    }

    private fun setImageProfile(@DrawableRes resId: Int) {
        imageProfile.addViewObserver {
            imageProfileBitmap = resizeImage(
                resId,
                widthImageProfile,
                heightImageProfile
            )
            imageProfile.setImageBitmap(imageProfileBitmap)
        }
    }

    fun bindStudentIdCard(student: Student) {
        nameUniversity.text = student.university.name
        idNumber.text = student.idNumber
        studentIdNumber.text = student.studentIdNumber
        lastName.text = student.lastName
        firstName.text = student.firstName
        faculty.text = student.faculty
        formOfTraining.text = student.formOfTraining
        dateOfIssue.text = student.dateOfIssue
        dateOfExpiry.text = student.dateOfExpiry
        setImageUniversity(student.university.image)
        setImageProfile(student.imageProfile)
    }

}