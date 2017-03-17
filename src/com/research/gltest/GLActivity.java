package com.research.gltest;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

public class GLActivity extends Activity {
	GLSurfaceView mView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);   
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       
        mView = new GLSurfaceView(this);
        mView.setEGLContextClientVersion(2);
        mView.setRenderer(new GLLayer(this));
        
        setContentView(mView);
		GLLayer.shader_selection = GLLayer.WARP;
		

    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event){ 	
    	
    	GLLayer.shader_selection ++;
    	if(GLLayer.shader_selection > GLLayer.WARP)
    		GLLayer.shader_selection =0;
    	

    	
    	return true;
    
    }

    /** Called when the activity is first created. */
    @Override
    public void onResume() {
        super.onResume();
        mView.onResume();
       
    }
    protected void onPause() {
    	super.onPause(); 
    	mView.onPause();
    }
    
}
