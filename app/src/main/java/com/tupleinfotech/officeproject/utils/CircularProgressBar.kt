package com.tupleinfotech.officeproject.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.tupleinfotech.officeproject.R

class CircularProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var progress = 0

    init {
        progressPaint.style = Paint.Style.STROKE
        progressPaint.strokeWidth = 20f // Adjust the stroke width as needed
        progressPaint.strokeCap = Paint.Cap.ROUND // Round cap for a circular shape
    }

    @SuppressLint("ResourceAsColor")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(centerX, centerY) - progressPaint.strokeWidth / 2
        val angle = (progress / 100f) * 360f

        // Draw the background circle
        progressPaint.color = resources.getColor(android.R.color.darker_gray) // Set the background color
        canvas.drawCircle(centerX, centerY, radius, progressPaint)

        // Draw the progress arc
        progressPaint.color = resources.getColor(R.color.office_main) // Set the progress color from colors.xml
        canvas.drawArc(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius,
            -90f,
            angle,
            false,
            progressPaint
        )
    }

    fun setProgress(progress: Int) {
        this.progress = progress
        invalidate()
    }
}