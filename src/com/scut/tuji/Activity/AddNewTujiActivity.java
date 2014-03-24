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
	//定义控件
	Button addPicBtn;   //添加图片的按钮
	LinearLayout addPicLayout;   //添加图片区域的布局
	TextView wordNumRemain;
	EditText contentInput;
	
	//定义常量
	private final static int SELECT_NONE = 0;
	private final static int SELECT_FROM_GALLERY = 1;
	private final static int SELECT_BY_TAKING_PHOTO = 2;
	
	//定义变量
	private int selectItem;
	private PictureList picList;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {    	   
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(R.layout.activity_addnewtuji);
        //初始化变量
        initVar();
      //初始化控件
        initView();
        //初始化监听器
        addListener();
	}
	
	/**
	 * 初始化变量
	 */
	private void initVar(){
		picList = new PictureList(this);
		
	}
	
	/**
	 * 初始化控件
	 */
	private void initView(){
		addPicBtn = (Button)findViewById(R.id.add_picture_btn);
		addPicLayout = (LinearLayout)findViewById(R.id.ll_add_picture);
		wordNumRemain = (TextView)findViewById(R.id.tv_word_num_remain);
		contentInput = (EditText)findViewById(R.id.et_content);
	}
	
	/**
	 * 初始化监听器
	 */
	private void addListener(){
		//编辑内容时编辑框的监听器
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
		
		
		//添加图片的监听器
		addPicBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
                //点击添加图片时弹出选择窗口
				showSelectDialog();
			}
			
		});
	}
	
	/**
	 * 显示选择对话框并返回选择值
	 * @return
	 */
	private void showSelectDialog(){
		setSelectItem(SELECT_FROM_GALLERY);
		String[] items = new String[]{"从相册选择","拍照"};
		AlertDialog.Builder builder = new AlertDialog.Builder(this)
		                .setTitle("选择源")
		                .setSingleChoiceItems(items,0,new DialogInterface.OnClickListener(){						
							@Override
							public void onClick(DialogInterface dialog, int which) {
								setSelectItem(which+1);
							}
						});
		builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {			
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
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				setSelectItem(SELECT_NONE);
			}
		});
		builder.create().show();
	}
	
	//重写该方法以回调方式处理Activity返回的结果
	@Override
	public void onActivityResult(int requestCode,int resultCode,Intent intent){
		//如果成功选择，则交给该函数处理
		if(resultCode == Activity.RESULT_OK)
		{
			processPhoto(requestCode,intent);
		}
	}
	
	
	//函数处理过程
	private void processPhoto(int requestCode,Intent data){
		Uri photoUri;
        if(requestCode == SELECT_FROM_GALLERY )  //从相册取图片
        {  
            if(data == null)  
            {  
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();  
                return;  
            }  
            photoUri = data.getData();
            if(photoUri == null )  
            {  
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();  
                return;  
            }  
            
            if(picList.addPicture(photoUri))
            	Toast.makeText(this, "上传图片超过最大限定数", Toast.LENGTH_LONG).show();
            else
            {
				addPicLayout.removeAllViews();
				addPicLayout.addView(picList.getView());
				addPicLayout.addView(addPicBtn);
			}
            
        }  
        
	}
	
	
	/**
	 * 设置selectItem的值
	 * @param item
	 */
	private void setSelectItem(int item){
		selectItem = item;
	}
	
	/**
	 * 获得selectItem的值
	 */
	private int getSelectItem(){
		return selectItem;
	}
}