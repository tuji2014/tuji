package com.scut.tuji.DB;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DataHelper {
	private Context context;
	private static DataHelper instance;
	private final String dbName = "tuji";

	//在SharedPreferences中判断是否保存有账号密码
	private DataHelper(Context context) {
		this.context = context;
	}

	// 创建一个实例
	public static DataHelper getInstance(Context context) {
		if (instance == null) {
			instance = new DataHelper(context);
		}
		return instance;
	}

	// 写入数据
	public void putString(String key, String value) {
		SharedPreferences preferences = context.getSharedPreferences(dbName,
				Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	// 获取数据
	public String getString(String key, String defValue) {
		SharedPreferences preferences = context.getSharedPreferences(dbName,
				Context.MODE_PRIVATE);
		return preferences.getString(key, defValue);
	}

	public void putBoolean(String key, boolean value) {
		SharedPreferences preferences = context.getSharedPreferences(dbName,
				Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public boolean getBoolean(String key, boolean defValue) {
		SharedPreferences preferences = context.getSharedPreferences(dbName,
				Context.MODE_PRIVATE);
		
		return preferences.getBoolean(key, defValue);
	}

}
