package com.wxp.floattag;

import com.wxp.floattag.FloatTag.FloatTagStateListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	ScrollView mScrollView;

	FloatTag mFloatTag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFloatTag=(FloatTag)findViewById(R.id.id_ft_floattag);
	   mScrollView=(ScrollView)findViewById(R.id.id_sv_mainscrolleview);

	   /*
	    * 注意：这里的第二个参数是初始化就就现实出来的，而下面控制隐藏和显示的是另一个View
	    */
	   mFloatTag.init(mScrollView, findViewById(R.id.id_btn_tag), new FloatTagStateListener() {
		
		@Override
		public void onFloatTagShow() {
			findViewById(R.id.id_btn_float_tag).setVisibility(View.VISIBLE);			
		}
		
		@Override
		public void onFloatTagHide() {
			findViewById(R.id.id_btn_float_tag).setVisibility(View.GONE);		
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
