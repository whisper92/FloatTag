package com.wxp.floattag;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class FloatTag extends LinearLayout {

	private ScrollView mScrollView;
	private View mFloatTagView;

	private FloatTagStateListener mFloatTagStateListener;

	boolean mScrollUp=true;
	public FloatTag(Context context){
		this(context, null);
	}
	public FloatTag(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
	}

	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		super.computeScroll();
	    if(mScrollView!=null && mFloatTagView!=null && mFloatTagStateListener!=null){
	    	int scrollViewY=mScrollView.getScrollY();
	    	int floatTagTopY=mFloatTagView.getTop();
	    	Log.e("wxp", scrollViewY+" , "+floatTagTopY);
	    	if(mScrollUp){
	    		if(scrollViewY>=floatTagTopY){
	    			mFloatTagStateListener.onFloatTagShow();

	    			mScrollUp=false;
	    		}
	    	} else {
	    		if(scrollViewY<=floatTagTopY){
	    			mFloatTagStateListener.onFloatTagHide();

	    			mScrollUp=true;
	    		}
	    	}
	    }

	}

	public void init(ScrollView scrollView,View floatTagView,FloatTagStateListener listener){
		this.mScrollView=scrollView;
		this.mFloatTagView=floatTagView;
		this.mFloatTagStateListener=listener;

	}

	public void setFloatTagStateListener(FloatTagStateListener listener){
		this.mFloatTagStateListener=listener;
	}
	public interface FloatTagStateListener{
        public void onFloatTagShow();
        public void onFloatTagHide();
	}
}
