package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice06SkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private RectF rectF;
    private Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice06SkewView(Context context) {
        super(context);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setColor(Color.RED);
        rectPaint.setStrokeWidth(10);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.save();
        canvas.skew(0, 0.5f);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        rectF = new RectF(point1.x, point1.y, point1.x + bitmap.getWidth() * 3 / 2, point1.y + bitmap.getHeight() * 3 / 2);

        canvas.drawRect(rectF, rectPaint);

        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    }
}
