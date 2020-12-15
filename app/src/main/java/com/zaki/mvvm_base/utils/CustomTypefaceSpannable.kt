package com.zaki.mvvm_base.utils

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.MetricAffectingSpan
import androidx.collection.LruCache
import androidx.core.content.res.ResourcesCompat

/**
 * Load the [Typeface]
 */
class CustomTypefaceSpannable (context: Context, typefaceResourceId: Int) : MetricAffectingSpan() {

    private var mTypeface: Typeface? = null

    init {
        mTypeface = sTypefaceCache.get(typefaceResourceId)

        if (mTypeface == null) {
            mTypeface = ResourcesCompat.getFont(context, typefaceResourceId)

            // Cache the loaded Typeface
            sTypefaceCache.put(typefaceResourceId, mTypeface!!)
        }
    }

    companion object {
        /** An `LruCache` for previously loaded typefaces.  */
        private val sTypefaceCache = LruCache<Int, Typeface>(12)
    }

    override fun updateMeasureState(p: TextPaint) {
        p.typeface = mTypeface

        // Note: This flag is required for proper typeface rendering
        p.flags = p.flags or Paint.SUBPIXEL_TEXT_FLAG
    }

    override fun updateDrawState(tp: TextPaint) {
        tp.typeface = mTypeface

        // Note: This flag is required for proper typeface rendering
        tp.flags = tp.flags or Paint.SUBPIXEL_TEXT_FLAG
    }
}