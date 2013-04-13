package com.example.quickmatch;

import com.example.quickmatch.util.SystemUiHider;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class Home extends Activity {

	private static final boolean TOGGLE_ON_CLICK = true;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_home);

		final View contentView = findViewById(R.id.fullscreen_content);

		contentView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (TOGGLE_ON_CLICK) {
					goToProfileScreen(view);
				}
			}
		});
	}

	public void goToProfileScreen(View view) {
		Intent intent = new Intent(this, ProfileScreen.class);
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.exitdialog);
		dialog.setTitle("Exit");

		Log.i(getLocalClassName(), "Click Registered!");
		Button close_button = (Button) dialog.findViewById(R.id.close_b);
		// if button is clicked, close the custom dialog
		close_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				finish();
			}
	});
		Button cancel_button = (Button) dialog.findViewById(R.id.cancel_b);
		cancel_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
	});
	dialog.show();	
		
		
	}

}
