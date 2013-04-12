package com.example.quickmatch;

import com.example.quickmatch.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class ProfileScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_profile_screen);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);
        
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
}
