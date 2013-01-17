package com.vacuumhead.bangalore.graph;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

@SuppressLint({ "DrawAllocation", "DrawAllocation", "DrawAllocation" })
public class InteractiveMapView extends View {

	private ScaleGestureDetector scaleGestureDetector;
	private static float MIN_ZOOM = 1f;
	private static float MAX_ZOOM = 5f;
	private float scaleFactor = 1.f;
	
	public InteractiveMapView(Context context) {
		super(context);
		scaleGestureDetector = new ScaleGestureDetector(getContext(),
				new ScaleListener());
		
	}
	
	public InteractiveMapView(Context context, AttributeSet attrs) {
		super( context, attrs );
		scaleGestureDetector = new ScaleGestureDetector(getContext(),
				new ScaleListener());
	}
	
	public InteractiveMapView(Context context, AttributeSet attrs, int defStyle) {
		super( context, attrs, defStyle );
		scaleGestureDetector = new ScaleGestureDetector(getContext(),
				new ScaleListener());
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		scaleGestureDetector.onTouchEvent(event);
        return true;
    }
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		canvas.save();
        canvas.scale(scaleFactor, scaleFactor);
        
		Paint station = new Paint();
		station.setColor(Color.YELLOW);
		canvas.drawRect(0, 0, 50, 100, station);
		
		
		canvas.restore();
	}

	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			scaleFactor *= detector.getScaleFactor();
			scaleFactor = Math.max(MIN_ZOOM, Math.min(scaleFactor, MAX_ZOOM));
			invalidate();
			return true;
		}
	}
}
