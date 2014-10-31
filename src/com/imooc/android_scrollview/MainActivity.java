package com.imooc.android_scrollview;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener{

	private TextView tv;
	private ScrollView scroll;
	private Button up_btn;
	private Button down_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		tv = (TextView) findViewById(R.id.content);
		up_btn=(Button) findViewById(R.id.up);
		down_btn=(Button) findViewById(R.id.down);
		up_btn.setOnClickListener(this);
		down_btn.setOnClickListener(this);
		tv.setText(getResources().getString(R.string.content));
		scroll = (ScrollView) findViewById(R.id.scroll);
		scroll.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE: {
					/**
					 * (1)getScrollY()————滚动条滑动的距离 (2)getMeasuredHeight()
					 * (3)getHeight()
					 */

					// 顶部状态
					if (scroll.getScrollY() <= 0) {
						Log.i("Main", "滑动到顶部");
					}

					// 底部状态
					// TextView的总高度<=一屏幕的高度+滚动条的滚动距离
					if (scroll.getChildAt(0).getMeasuredHeight() <= scroll
							.getHeight() + scroll.getScrollY()) {

						Log.i("Main", "滑动到底部");
						Log.i("Main",
								"scroll.getChildAt(0).getMeasuredHeight()="
										+ scroll.getChildAt(0)
												.getMeasuredHeight()
										+ "scroll,getHeight()="
										+ scroll.getHeight()
										+ "scroll.getScrollY()="
										+ scroll.getScrollY());
						tv.append(getResources().getString(R.string.content));

					}
					break;
				}
				}

				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		//scrollTo：以滚动视图起始位置开始计算的
		//scrollBy：相对前一次的位置，去滚动对应的距离
		
		case R.id.up:
		{	
			scroll.scrollBy(0, -30);
			break;
		}
		
		case R.id.down:
		{
			
			scroll.scrollBy(0, 30);
			break;
		}
		}
	}
}
