package com.scut.tuji.Activity;

import com.scut.tuji.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class AmendInfo extends Activity {
	
	 public void btn_back(View v) {     //标题栏 返回按钮
	      	this.finish();
	      } 
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.info_amend);              
	    }

}
