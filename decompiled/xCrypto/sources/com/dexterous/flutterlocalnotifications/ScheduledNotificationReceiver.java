package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import com.dexterous.flutterlocalnotifications.utils.StringUtils;
import x2.C1925a;

/* JADX INFO: loaded from: classes.dex */
public class ScheduledNotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "ScheduledNotifReceiver";

    public class a extends C1925a<NotificationDetails> {
        public a() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(FlutterLocalNotificationsPlugin.NOTIFICATION_DETAILS);
        if (!StringUtils.isNullOrEmpty(stringExtra).booleanValue()) {
            NotificationDetails notificationDetails = (NotificationDetails) FlutterLocalNotificationsPlugin.buildGson().h(stringExtra, new a().d());
            FlutterLocalNotificationsPlugin.showNotification(context, notificationDetails);
            FlutterLocalNotificationsPlugin.scheduleNextNotification(context, notificationDetails);
            return;
        }
        int intExtra = intent.getIntExtra("notification_id", 0);
        Notification notification = Build.VERSION.SDK_INT >= 33 ? (Notification) intent.getParcelableExtra("notification", Notification.class) : (Notification) intent.getParcelableExtra("notification");
        if (notification == null) {
            FlutterLocalNotificationsPlugin.removeNotificationFromCache(context, Integer.valueOf(intExtra));
            Log.e(TAG, "Failed to parse a notification from  Intent. ID: " + intExtra);
            return;
        }
        notification.when = System.currentTimeMillis();
        w.p.e(context).h(intExtra, notification);
        if (intent.getBooleanExtra("repeat", false)) {
            return;
        }
        FlutterLocalNotificationsPlugin.removeNotificationFromCache(context, Integer.valueOf(intExtra));
    }
}
