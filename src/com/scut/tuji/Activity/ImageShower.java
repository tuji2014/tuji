package com.scut.tuji.Activity;

	
	import android.app.Activity;
	import android.os.Bundle;
	import android.os.Handler;
	import android.view.MotionEvent;


	public class ImageShower extends Activity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.imageshower);

	        final ImageLoadingDialog dialog = new ImageLoadingDialog(this);
	        dialog.show();
	        // �����رպ�dialog
	        new Handler().postDelayed(new Runnable() {
	            @Override
	            public void run() {
	                dialog.dismiss();
	            }
	        }, 1000 * 2);
	    }

	    @Override
		public boolean onTouchEvent(MotionEvent event){
			finish();
			return true;
	}
	    }


