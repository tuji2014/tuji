package com.scut.tuji.Activity;

import java.util.LinkedList;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;



public class PictureList{
     private Context context;
     private LinkedList<PictureListNode> list;
     private LinearLayout layout;
     private int count;
     private static final int MAXCOUNT = 4;
	
	public PictureList(Context context){
		this.context = context;
		init();
	}
	
	//初始化变量
	private void init(){
		list = new LinkedList<PictureListNode>();
		layout = new LinearLayout(context);
		
		count = 0;
	}
	
	//添加图片
	public boolean addPicture(Uri photoUri){
		if(count>=MAXCOUNT)
			return false;
		PictureListNode node = new PictureListNode(this.context,this);
		node.addImage(photoUri);
		node.addButton();
		node.setId(count);
		list.addLast(node);
		layout.addView(node.getView());
		count+=1;
		return true;
	}
	
	//删除图片
	public boolean deletePicView(int id){
		if(id<0||id>count)
			return false;
		
		for(int i=id+1;i<list.size();i++)
		{
			list.get(i).setId(i-1);
		}
		layout.removeView(list.get(id).getView());
		list.remove(id);
		
		
		return true;
	}
	
	//获取最终布局
	public View getView(){
		return layout;
	}
}