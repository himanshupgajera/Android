package com.example.practical4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new RectangleView(this));
    }

    private static class RectangleView extends View {
        private Paint paint;

        public RectangleView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            canvas.drawRect(50, 50, width - 50, height - 50, paint);
        }
    }
}

