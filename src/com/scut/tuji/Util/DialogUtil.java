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
		// ����һ��AlertDialog.Builder����
		Builder builder = new Builder(ctx).setMessage(msg).setCancelable(false);

		if (closeSelf) {
			builder.setPositiveButton("ȷ��", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// ������ǰAcitivity
					((Activity) ctx).finish();
				}
			});

		} else {
			builder.setPositiveButton("ȷ��", null);
		}

	}

	//������ʾָ������ĶԻ���
	public static void showDialog(Context ctx, View view) {
		Builder builder = new Builder(ctx).setView(view).setCancelable(false)
				.setPositiveButton("ȷ��", null);
		builder.create().show();
	}

}
