package com.scut.tuji.Util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class DialogUtil {

	public static void showDialog(final Context ctx, String msg,
			boolean closeSelf) {
		// 创建一个AlertDialog.Builder对象
		Builder builder = new Builder(ctx).setMessage(msg).setCancelable(false);

		if (closeSelf) {
			builder.setPositiveButton("确定", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// 结束当前Acitivity
					((Activity) ctx).finish();
				}
			});

		} else {
			builder.setPositiveButton("确定", null);
		}

	}

	//定义显示指定组件的对话框
	public static void showDialog(Context ctx, View view) {
		Builder builder = new Builder(ctx).setView(view).setCancelable(false)
				.setPositiveButton("确定", null);
		builder.create().show();
	}

}
