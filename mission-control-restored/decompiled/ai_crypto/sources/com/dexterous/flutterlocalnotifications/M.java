package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class M implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f10731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10733c;

    public M(NotificationDetails notificationDetails, int i7, ArrayList arrayList) {
        this.f10731a = notificationDetails;
        this.f10732b = i7;
        this.f10733c = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f10731a + ", startMode=" + this.f10732b + ", foregroundServiceTypes=" + this.f10733c + '}';
    }
}
