package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private Camera camera;
    private Matrix matrix;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        camera = new Camera();
        matrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center1X = point1.x + bitmap.getWidth() / 2;
        float center1Y = point1.y + bitmap.getHeight() / 2;
        float center2X = point2.x + bitmap.getWidth() / 2;
        float center2Y = point2.y + bitmap.getHeight() / 2;
        //重点注意 要提早获取center1X
        camera.save();
        matrix.reset();//
        camera.rotateX(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-center1X, -center1Y);
        matrix.postTranslate(center1X, center1Y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-center2X, -center2Y);
        matrix.postTranslate(center2X, center2Y);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
