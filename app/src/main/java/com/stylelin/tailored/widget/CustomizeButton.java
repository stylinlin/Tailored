package com.stylelin.tailored.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Jonlin on 2017/3/17.
 * Description:
 */

public class CustomizeButton extends AppCompatTextView {
    public CustomizeButton(Context context) {
        this(context, null);
    }

    public CustomizeButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomizeButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
    }

}
