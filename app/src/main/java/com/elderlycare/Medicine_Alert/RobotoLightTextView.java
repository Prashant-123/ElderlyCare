package com.elderlycare.Medicine_Alert;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;



public class RobotoLightTextView extends AppCompatTextView {

    public RobotoLightTextView(Context context) {
        super(context);
        applyCustomFont();
    }

    public RobotoLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont();
    }

    public RobotoLightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont();
    }

    private void applyCustomFont() {
        Typeface customFont = FontUtil.getTypeface(FontUtil.ROBOTO_LIGHT);
        setTypeface(customFont);
    }
}