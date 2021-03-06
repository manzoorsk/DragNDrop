package com.delaroystudios.dragndrop;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.skholingua.android.dragndrop_relativelayout.R;

public class MainActivity extends Activity {

	private ImageView img;
	private ViewGroup rootLayout;
	private int Delta;
	private int Delta1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rootLayout = (ViewGroup) findViewById(R.id.view_root);
		img = (ImageView) rootLayout.findViewById(R.id.imageView);

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
		img.setLayoutParams(layoutParams);
		img.setOnTouchListener(new ChoiceTouchListener());
	}

	
	
	private final class ChoiceTouchListener implements OnTouchListener {
		public boolean onTouch(View view, MotionEvent event) {
			final int X = (int) event.getRawX();
			final int Y = (int) event.getRawY();
			switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) view.getLayoutParams();
				Delta = X - Params.leftMargin;
				Delta1 = Y - Params.topMargin;
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				break;
			case MotionEvent.ACTION_POINTER_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
						.getLayoutParams();
				layoutParams.leftMargin = X - Delta;
				layoutParams.topMargin = Y - Delta1;
				layoutParams.rightMargin = -250;
				layoutParams.bottomMargin = -250;
				view.setLayoutParams(layoutParams);
				break;
			}
			rootLayout.invalidate();
			return true;
		}
	}

}



