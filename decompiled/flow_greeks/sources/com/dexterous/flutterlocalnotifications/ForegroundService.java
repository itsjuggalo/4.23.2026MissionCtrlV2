package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ForegroundService extends Service {
    public static int a(ArrayList arrayList) {
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        for (int i10 = 1; i10 < arrayList.size(); i10++) {
            iIntValue |= ((Integer) arrayList.get(i10)).intValue();
        }
        return iIntValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        g gVar = i12 >= 33 ? (g) intent.getSerializableExtra("com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter", g.class) : (g) intent.getSerializableExtra("com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter");
        Notification notificationCreateNotification = FlutterLocalNotificationsPlugin.createNotification(this, gVar.f5337a);
        if (gVar.f5339c == null || i12 < 29) {
            startForeground(gVar.f5337a.f5347id.intValue(), notificationCreateNotification);
        } else {
            startForeground(gVar.f5337a.f5347id.intValue(), notificationCreateNotification, a(gVar.f5339c));
        }
        return gVar.f5338b;
    }
}
