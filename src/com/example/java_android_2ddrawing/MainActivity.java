package com.example.java_android_2ddrawing;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnReset = (Button)findViewById(R.id.button1);
		btnReset.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				MyDrawView m = (MyDrawView)findViewById(R.id.drawView);
				m.clearAllPoints();
			}
		});
		
		Button btnUndo = (Button)findViewById(R.id.button2);
		btnUndo.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				MyDrawView m = (MyDrawView)findViewById(R.id.drawView);
				m.undo();
			}
		});
	}
}
