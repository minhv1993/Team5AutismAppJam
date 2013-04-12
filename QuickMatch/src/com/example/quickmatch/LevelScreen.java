package com.example.quickmatch;

import com.example.quickmatch.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class LevelScreen extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		
		setContentView(R.layout.activity_level_screen);

		final View newLevel = findViewById(R.id.level1);

		
		// Set up the user interaction to manually show or hide the system UI.
		newLevel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//INSERT GO TO ACTIVITY!!!
				}
			}
		);
	}
}	

		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
	
