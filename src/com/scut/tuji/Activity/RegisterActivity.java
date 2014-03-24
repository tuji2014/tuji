package com.scut.tuji.Activity;


import com.scut.tuji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity{
	//�û��˺š����롢�ٴ�ȷ������
	private EditText userAccount,userPwd,userPwdConfirm;
	//ȷ��ע�ᰴť��ȡ��ע�ᰴť
	private Button btnRegisterConfirm,btnRegisterCancel;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //��ʼ������ؼ�
        initView();
        //��Ӽ�����Ӧ�¼�
        addListener();
    }
	
	//��ʼ���ؼ�
	private void initView()
	{
		userAccount = (EditText)findViewById(R.id.et_register_account);
		userPwd = (EditText)findViewById(R.id.et_register_password);
		userPwdConfirm = (EditText)findViewById(R.id.et_register_password_confirm);
		btnRegisterConfirm = (Button)findViewById(R.id.btn_register_confirm);
		btnRegisterCancel = (Button)findViewById(R.id.btn_register_cancel);
	}
	
	//��Ӽ�����
	private void addListener()
	{
		//ע�ᰴť������
		btnRegisterConfirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//�д�ʵ��				
			}			
		});
		
		//ȡ����ť������
		btnRegisterCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//��ת�ص���½ҳ��
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
	            //newһ��Bundle���󣬲���Ҫ���ݵ����ݴ���
	            Bundle bundle = new Bundle();
	            //��bundle����assign��Intent
	            intent.putExtras(bundle);
	            //������ת
	            startActivity(intent);
			}			
		});
	}
	
	/**
	 * �����������
	 */
	private RegisterActivity getThis(){
		return this;
	}
}