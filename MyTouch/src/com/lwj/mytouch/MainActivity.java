package com.lwj.mytouch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {

	//坐标
	float x1=0;
	float y1=0;
	float x2=0;
	float y2=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	//滑动事件监听
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//手指按下
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			x1=event.getX();
			y1=event.getY();
		}
		//手指按下、滑动、离开屏幕
		if(event.getAction()==MotionEvent.ACTION_UP)
		{
			x2=event.getX();
			y2=event.getY();
			if(y1 - y2 > 50) {
		        Toast.makeText(MainActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
		      } else if(y2 - y1 > 10) {
		        Toast.makeText(MainActivity.this, "向下滑", Toast.LENGTH_SHORT).show();
		      } else if(x1 - x2 > 10) {
		        Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
		      } else if(x2 - x1 > 10) {
		        Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
		      }
		}
		return super.onTouchEvent(event);
	}
	
}
