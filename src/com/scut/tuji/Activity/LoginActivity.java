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
	// �û���ͷ��
    private ImageButton userHead;
    // �û��˺š�����
    private EditText userAccount,userPwd;
    // ��½��ť��ע�ᰴť
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //��ʼ������ؼ�
        initView();
        //��Ӽ�����Ӧ�¼�
        addListener();
    }

    /**
     * ��ʼ�����пؼ�
     */
    private void initView() {
        userHead = (ImageButton) findViewById(R.id.login_head);
        userAccount = (AutoCompleteTextView) findViewById(R.id.et_login_account);
        userPwd = (EditText) findViewById(R.id.btn_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

    private void addListener() {
        //��ӵ�½��ť�����¼�
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //��ȡ�û�������˺�
                int account = Integer
                        .parseInt(userAccount.getText().toString());
                //��ȡ�û����������
                String password = userPwd.getText().toString();
                
                //���õ�¼����
                login(account, password);
            }
        });

        //���ע�ᰴť�����¼�
        btnRegister.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//��ת��ע��ҳ��
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
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
     * ��ȡ�������
     */
    private LoginActivity getThis(){
    	return this;
    }
    
    /**
     * ��¼����
     * �÷������ڽ��û�������˺ź����뷢�͵�����ˣ����Է���˷��ص����ݽ��д���
     * @param account �˺�
     * @param password ����
     */
    protected void login(int account, String password) { 	
        //�д�ʵ��
    }
}
