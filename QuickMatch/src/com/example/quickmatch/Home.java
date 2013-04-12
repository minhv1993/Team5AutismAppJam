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
public class Home extends Activity {
    
    private static final boolean TOGGLE_ON_CLICK = true;

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

}
