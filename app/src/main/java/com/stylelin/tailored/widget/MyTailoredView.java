package com.stylelin.tailored.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.stylelin.tailored.R;

/**
 * Created by Jonlin on 2017/3/17.
 * Description:学习自定义view
 */

public class MyTailoredView extends View {

    /**
     * 文本
     */
    private String mTitleText;

    /**
     * 自定义颜色
     */
    private int tailoredColor;

    /**
     * 自定义文字大小
     */
    private int mTextSize;

    private Paint mPaint; // 画笔

    private Rect rect;


    /**
     * 构造方法相互调用，减少代码量
     */
    public MyTailoredView(Context context) {
        this(context, null);
    }

    public MyTailoredView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 统一调用此构造方法
     */
    public MyTailoredView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 获取所有自定义控件样式属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTailoredView, defStyleAttr, 0);

        // 遍历属性，并初始化默认值
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.MyTailoredView_mTitleText: // 文本
                    mTitleText = typedArray.getString(attr);
                    break;
                case R.styleable.MyTailoredView_tailoredColor: // 颜色
                    tailoredColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.MyTailoredView_mTextSize: // 文字大小
                    // 默认设置为16sp，TypeValue也可以把sp转化为px; mTextSize为像素px
                    mTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }

        typedArray.recycle(); // 回收TypedArray，以便后面重用。

        mPaint = new Paint();
        mPaint.setColor(tailoredColor);

        rect = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), rect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        int modeHight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHight = MeasureSpec.getSize(heightMeasureSpec);

        int width, hight;

        if (modeWidth == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else { // 不是精确值便测量其尺寸
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), rect);
            float textWidth = rect.width();
            width = (int) (getPaddingLeft() + textWidth + getPaddingRight());
        }

        if (modeHight == MeasureSpec.EXACTLY) {
            hight = sizeHight;
        } else { // 不是精确值便测量其尺寸
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), rect);
            float textHeight = rect.height();
            hight = (int) (getPaddingTop() + textHeight + getPaddingBottom());
        }

        setMeasuredDimension(width, hight); // 不调用此方法会导致测量异常
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(tailoredColor);
        canvas.drawText(mTitleText, getWidth() / 2 - rect.width() / 2, getHeight() / 2 + rect.height() / 2, mPaint);
    }

}
