package com.neowang.shadowlinearlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by cd14 on 2017/4/10.
 */

public class LinearlayoutShadow extends LinearLayout{
    private Context context;
    private int shadowColor; //阴影颜色
    private int bgColor; //背景颜色
    private int shadowRadius; //阴影半径
    private int offset_x; //阴影x轴偏移量
    private int offset_y; //阴影y轴偏移量
    private int radius_x; //圆角半径x
    private int radius_y; //圆角半径y
    private int width;
    private int height;

    public LinearlayoutShadow(Context context) {
        super(context);
        this.context = context;
        setWillNotDraw(false);
    }

    public LinearlayoutShadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setAttributeSet(context,attrs);
        setWillNotDraw(false);
    }

    public LinearlayoutShadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setAttributeSet(context,attrs);
        setWillNotDraw(false);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LinearlayoutShadow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        setAttributeSet(context,attrs);
        setWillNotDraw(false);
    }
    private void setAttributeSet(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.shadowlayout);
        shadowColor = a.getColor(R.styleable.shadowlayout_shadowColor,Color.BLUE);
        bgColor = a.getColor(R.styleable.shadowlayout_bgColor,Color.BLACK);
        shadowRadius = a.getDimensionPixelSize(R.styleable.shadowlayout_shadowRadius,3);
        offset_x = a.getDimensionPixelSize(R.styleable.shadowlayout_offset_x,0);
        offset_y = a.getDimensionPixelSize(R.styleable.shadowlayout_offset_y,0);
        radius_x = a.getDimensionPixelSize(R.styleable.shadowlayout_radius_x,3);
        radius_y = a.getDimensionPixelSize(R.styleable.shadowlayout_radius_y,3);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = measureWidth(widthMeasureSpec);
        height = measureHeight(heightMeasureSpec);
        //设置宽高
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setLayerType(LAYER_TYPE_SOFTWARE, null);//必须硬件不加速
        Paint paint = new Paint();
        paint.setColor(bgColor);
        paint.setShadowLayer(shadowRadius,offset_x,offset_y,shadowColor);
        canvas.drawRoundRect(new RectF(shadowRadius+offset_x,shadowRadius+offset_y, width-shadowRadius+offset_x,height-shadowRadius+offset_y),radius_x,radius_y,paint);
        super.onDraw(canvas);
    }
    //根据xml的设定获取宽度
    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST){

        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY){

        }
        return specSize;
    }

    //根据xml的设定获取高度
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST){

        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY){

        }
        return specSize;
    }
}
