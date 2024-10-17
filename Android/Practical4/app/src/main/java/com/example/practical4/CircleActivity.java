package com.example.practical4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CircleView(this));
    }

    private static class CircleView extends View {
        private Paint paint;

        public CircleView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 4, paint);
        }
    }
}

