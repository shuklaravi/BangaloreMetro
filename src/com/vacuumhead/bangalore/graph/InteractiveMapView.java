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
	List<Rect> stations = null;
	
	public InteractiveMapView(Context context) {
		super(context);
		scaleGestureDetector = new ScaleGestureDetector(getContext(),
				new ScaleListener());
		
		stations.add(new Rect(0, 0, 50, 100));
		stations.add(new Rect(80, 120, 100, 150));
	}
	
	public InteractiveMapView(Context context, AttributeSet attrs) {
		super( context, attrs );
		
		stations.add(new Rect(0, 0, 50, 100));
		stations.add(new Rect(80, 120, 100, 150));
	}
	
	public InteractiveMapView(Context context, AttributeSet attrs, int defStyle) {
		super( context, attrs, defStyle );
		
		stations.add(new Rect(0, 0, 50, 100));
		stations.add(new Rect(80, 120, 100, 150));
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
		Paint station = new Paint();
		station.setColor(Color.YELLOW);
		canvas.drawRect(stations.get(0), station);
		
	
		
		station.setColor(Color.BLUE);
		canvas.drawRect(stations.get(1), station);
		
		
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		int touchX = (int) event.getX();
		int touchY = (int) event.getY();
		
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				for (Rect station : stations) 
				{
	                if(station.contains(touchX,touchY)) 
	                {
	                	
	                }
				}
				break;
		}
		
		return true;
		
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
