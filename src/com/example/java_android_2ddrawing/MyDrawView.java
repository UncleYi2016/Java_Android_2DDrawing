package com.example.java_android_2ddrawing;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyDrawView extends View{
	private Paint p;
	ArrayList<PointF> points = new ArrayList<PointF>();
	
	public MyDrawView(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		p.setColor(Color.RED);
		p.setStyle(Paint.Style.STROKE);
	
		this.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					float x=event.getX();
					float y=event.getY();
					PointF point = new PointF(x,y);
					points.add(point);
					invalidate();
				}
				return true;
			}
		});
	}
	
	public void clearAllPoints(){
		points.clear();
		invalidate();
	}
	
	public void undo(){
		points.remove(points.size()-1);
		invalidate();
	}
	
	protected void onDraw(Canvas c){
		//draw the circle
		if(points.size() == 1){
			c.drawPoint(points.get(0).x, points.get(0).y, p);
		}else if(points.size() > 1){
			for(int i = 0; i < points.size() - 1; i++){
				PointF prev = points.get(i);
				PointF next = points.get(i+1);
				c.drawLine(prev.x, prev.y, next.x, next.y, p);
			}
		}
		//draw a cube
//		c.drawLine(100, 100, 200, 100, p);
//		c.drawLine(200, 100, 200, 200, p);
//		c.drawLine(100, 100, 100, 200, p);
//		c.drawLine(100, 200, 200, 200, p);
//		c.drawLine(100, 100, 125, 75, p);
//		c.drawLine(125, 75, 225, 75, p);
//		c.drawLine(200, 100, 225, 75, p);
//		c.drawLine(125, 75, 125, 175, p);
//		c.drawLine(125, 175, 225, 175, p);
//		c.drawLine(100, 200, 125, 175, p);
//		c.drawLine(200, 200, 225, 175, p);
//		c.drawLine(225, 75, 225, 175, p);
//		
//		//draw a cylinder
//		c.drawOval(100, 300, 200, 350, p);
//		c.drawLine(100, 325, 100, 400, p);
//		c.drawLine(200, 325, 200, 400, p);
//		c.drawOval(100, 375, 200, 425, p);
	}
}

