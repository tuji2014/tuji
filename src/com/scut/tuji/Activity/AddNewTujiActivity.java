package com.scut.tuji.Activity;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scut.tuji.R;

public class AddNewTujiActivity extends Activity{
	//����ؼ�
	Button addPicBtn;   //���ͼƬ�İ�ť
	LinearLayout addPicLayout;   //���ͼƬ����Ĳ���
	TextView wordNumRemain;
	EditText contentInput;
	
	//���峣��
	private final static int SELECT_NONE = 0;
	private final static int SELECT_FROM_GALLERY = 1;
	private final static int SELECT_BY_TAKING_PHOTO = 2;
	
	//�������
	private int selectItem;
	private PictureList picList;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        //���ò���
        setContentView(R.layout.activity_addnewtuji);
        //��ʼ������
        initVar();
      //��ʼ���ؼ�
        initView();
        //��ʼ��������
        addListener();
	}
	
	/**
	 * ��ʼ������
	 */
	private void initVar(){
		picList = new PictureList(this);
		
	}
	
	/**
	 * ��ʼ���ؼ�
	 */
	private void initView(){
		addPicBtn = (Button)findViewById(R.id.add_picture_btn);
		addPicLayout = (LinearLayout)findViewById(R.id.ll_add_picture);
		wordNumRemain = (TextView)findViewById(R.id.tv_word_num_remain);
		contentInput = (EditText)findViewById(R.id.et_content);
	}
	
	/**
	 * ��ʼ��������
	 */
	private void addListener(){
		//�༭����ʱ�༭��ļ�����
		contentInput.addTextChangedListener(new TextWatcher(){
			
			@Override
			public void afterTextChanged(Editable s) {
					wordNumRemain.setText((140-s.toString().length())+"x");
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {	
			}			
		});
		
		
		//���ͼƬ�ļ�����
		addPicBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
                //������ͼƬʱ����ѡ�񴰿�
				showSelectDialog();
			}
			
		});
	}
	
	/**
	 * ��ʾѡ��Ի��򲢷���ѡ��ֵ
	 * @return
	 */
	private void showSelectDialog(){
		setSelectItem(SELECT_FROM_GALLERY);
		String[] items = new String[]{"�����ѡ��","����"};
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		                .setTitle("ѡ��Դ")
		                .setSingleChoiceItems(items,0,new DialogInterface.OnClickListener(){						
							@Override
							public void onClick(DialogInterface dialog, int which) {
								setSelectItem(which+1);
							}
						});
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				int choice = getSelectItem();
				if(choice == SELECT_FROM_GALLERY){
					Intent intent = new Intent();  
			        intent.setType("image/*");  
			        intent.setAction(Intent.ACTION_PICK);  
			        startActivityForResult(intent, SELECT_FROM_GALLERY);
				}
				else if(choice == SELECT_BY_TAKING_PHOTO){
					
				}
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				setSelectItem(SELECT_NONE);
			}
		});
		builder.create().show();
	}
	
	//��д�÷����Իص���ʽ����Activity���صĽ��
	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent intent){
		//����ɹ�ѡ���򽻸��ú�������
		if(resultCode == Activity.RESULT_OK)
		{
			processPhoto(requestCode,intent);
		}
	}
	
	
	//�����������
	private void processPhoto(int requestCode,Intent data){
		Uri photoUri;
        if(requestCode == SELECT_FROM_GALLERY )  //�����ȡͼƬ
        {  
            if(data == null)  
            {  
                Toast.makeText(this, "ѡ��ͼƬ�ļ�����", Toast.LENGTH_LONG).show();  
                return;  
            }  
            photoUri = data.getData();
            if(photoUri == null )  
            {  
                Toast.makeText(this, "ѡ��ͼƬ�ļ�����", Toast.LENGTH_LONG).show();  
                return;  
            }  
            
            if(picList.addPicture(photoUri))
            	Toast.makeText(this, "�ϴ�ͼƬ��������޶���", Toast.LENGTH_LONG).show();
            else
            {
				addPicLayout.removeAllViews();
				addPicLayout.addView(picList.getView());
				addPicLayout.addView(addPicBtn);
			}
            
        }  
        
	}
	
	
	/**
	 * ����selectItem��ֵ
	 * @param item
	 */
	private void setSelectItem(int item){
		selectItem = item;
	}
	
	/**
	 * ���selectItem��ֵ
	 */
	private int getSelectItem(){
		return selectItem;
	}
}