package com.scut.tuji.Activity;

import com.scut.tuji.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class LoginActivity extends Activity{
	// 用户的头像
    private ImageButton userHead;
    // 用户账号、密码
    private EditText userAccount,userPwd;
    // 登陆按钮、注册按钮
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化界面控件
        initView();
        //添加监听响应事件
        addListener();
    }

    /**
     * 初始化所有控件
     */
    private void initView() {
        userHead = (ImageButton) findViewById(R.id.login_head);
        userAccount = (AutoCompleteTextView) findViewById(R.id.et_login_account);
        userPwd = (EditText) findViewById(R.id.btn_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

    private void addListener() {
        //添加登陆按钮监听事件
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的账号
                int account = Integer
                        .parseInt(userAccount.getText().toString());
                //获取用户输入的密码
                String password = userPwd.getText().toString();
                
                //调用登录方法
                login(account, password);
            }
        });

        //添加注册按钮监听事件
        btnRegister.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//跳转到注册页面
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
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
     * 获取自身对象
     */
    private LoginActivity getThis(){
    	return this;
    }
    
    /**
     * 登录方法
     * 该方法用于将用户输入的账号和密码发送到服务端，并对服务端返回的数据进行处理
     * @param account 账号
     * @param password 密码
     */
    protected void login(int account, String password) { 	
        //有待实现
    }
}
