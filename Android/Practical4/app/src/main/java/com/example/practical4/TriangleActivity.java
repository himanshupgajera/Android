package com.example.practical4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TriangleView(this));
    }

    private static class TriangleView extends View {
        private Paint paint;

        public TriangleView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.GREEN);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();

            Path path = new Path();
            path.moveTo(width / 2, 100); // Top
            path.lineTo(100, height - 100); // Bottom left
            path.lineTo(width - 100, height - 100); // Bottom right
            path.close();

            canvas.drawPath(path, paint);
        }
    }
}
