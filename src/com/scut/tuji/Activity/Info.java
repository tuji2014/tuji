package com.scut.tuji.Activity;

import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Info extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);              
    }

   public void btn_back(View v) {     //������ ���ذ�ť
      	this.finish();
      } 
public void info_amend(View v){     //�޸ĸ�����Ϣ��ť
	
	Intent intent = new Intent();
	intent.setClass(Info.this,AmendInfo.class );
	startActivity(intent);
}
   public void head(View v) {     //ͷ��ť
	   Intent intent = new Intent();
		intent.setClass(Info.this,ImageShower.class);
		startActivity(intent);
    } 
   
    
}