package com.example.quickmatch;

import com.example.quickmatch.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ProfileScreen extends Activity implements OnGestureListener{
	
	
	private GestureDetector gDetector;
	View.OnTouchListener gestureListener;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_profile_screen);
		
		
		//SWIPE GESTURE
		gDetector = new GestureDetector(this, (android.view.GestureDetector.OnGestureListener) this);
		gestureListener = new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
                return gDetector.onTouchEvent(event);
			}
		};

       final View profile1 = findViewById(R.id.profile1);
       profile1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
				goToWorldScreen(view);
           }});

	}
	
	
	private void goToWorldScreen(View view) {
		Intent intent = new Intent(this, WorldScreen.class);
 	   	startActivity(intent);
 	   	//take the data from profile1 and load this shit
	}


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onFling(MotionEvent start, MotionEvent finish, float velocityX,
			float velocityY) {
		if(start.getRawX() < finish.getRawX()) {
			//go to right menu
			Intent intent = new Intent(this, Home.class);
			startActivity(intent);
		}
		else {
			return false;
		}
		return true;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return gDetector.onTouchEvent(me);
	}
}
