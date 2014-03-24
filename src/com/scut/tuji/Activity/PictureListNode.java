package com.scut.tuji.Activity;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.scut.tuji.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class PictureListNode{
	private Context context;
	private FrameLayout layout;
	private Button delButton;
	private ImageView imageView;
	private PictureList picList;
	private int id;
	
	public PictureListNode(Context context,PictureList picList){
         this.context = context;
         this.picList = picList;
         init();
	}
	
	//初始化变量
	private void init(){
		layout = new FrameLayout(context);
		layout.setLayoutParams(new FrameLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		delButton = null;
		imageView = null;
		
		id = -1;
	}
	
	//添加删除按钮的监听器
	private void addDelButtonListener(){
		if(delButton!=null)
		{
			delButton.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					if(imageView!=null)
					{
						picList.deletePicView(id);
						BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
						if(bitmapDrawable !=null && !bitmapDrawable.getBitmap().isRecycled())
						   bitmapDrawable.getBitmap().recycle();
					}
				}				
			});
		}
	}
	
	/**
	 *添加图片的方法 
	 */
	public void addImage(Uri photoUri){
		Bitmap bitmap = null,newBitmap = null;
		try {
			bitmap = MediaStore.Images.Media.getBitmap(this.context.getContentResolver(), photoUri);
			newBitmap = Bitmap.createScaledBitmap(bitmap,50,50,true);
			bitmap.recycle();
			
			if(imageView == null)
			{
				imageView = new ImageView(this.context);
				imageView.setImageBitmap(newBitmap);
				layout.addView(imageView);
			}
			else
			{
				BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
				if(bitmapDrawable !=null && !bitmapDrawable.getBitmap().isRecycled())
					bitmapDrawable.getBitmap().recycle();
				imageView.setImageBitmap(newBitmap);
			}
						
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 为图片添加一个删除按钮
	 */
	public void addButton(){
		if(this.delButton==null)
		{
			delButton = new Button(this.context);
			FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(14,14);
			params.gravity = Gravity.RIGHT|Gravity.TOP;
			delButton.setLayoutParams(params);
			delButton.setBackground(this.context.getResources().getDrawable(R.drawable.btn_delete));
			layout.addView(delButton);
			addDelButtonListener();
		}
	}
	
	/**
	 * 返回单张图片节点的view
	 */
	public View getView(){
		return layout;
	}

	//获取图片id
	public int getId() {
		return id;
	}

	//设置图片id
	public void setId(int id) {
		this.id = id;
	}
}