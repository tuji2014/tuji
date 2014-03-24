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
	//用户账号、密码、再次确认密码
	private EditText userAccount,userPwd,userPwdConfirm;
	//确认注册按钮和取消注册按钮
	private Button btnRegisterConfirm,btnRegisterCancel;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化界面控件
        initView();
        //添加监听响应事件
        addListener();
    }
	
	//初始化控件
	private void initView()
	{
		userAccount = (EditText)findViewById(R.id.et_register_account);
		userPwd = (EditText)findViewById(R.id.et_register_password);
		userPwdConfirm = (EditText)findViewById(R.id.et_register_password_confirm);
		btnRegisterConfirm = (Button)findViewById(R.id.btn_register_confirm);
		btnRegisterCancel = (Button)findViewById(R.id.btn_register_cancel);
	}
	
	//添加监听器
	private void addListener()
	{
		//注册按钮监听器
		btnRegisterConfirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//有待实现				
			}			
		});
		
		//取消按钮监听器
		btnRegisterCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//跳转回到登陆页面
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
	            //new一个Bundle对象，并将要传递的数据传入
	            Bundle bundle = new Bundle();
	            //将bundle对象assign给Intent
	            intent.putExtras(bundle);
	            //开启跳转
	            startActivity(intent);
			}			
		});
	}
	
	/**
	 * 返回自身对象
	 */
	private RegisterActivity getThis(){
		return this;
	}
}