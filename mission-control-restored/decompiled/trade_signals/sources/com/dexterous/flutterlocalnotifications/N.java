package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class N implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f14878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14880c;

    public N(NotificationDetails notificationDetails, int i8, ArrayList arrayList) {
        this.f14878a = notificationDetails;
        this.f14879b = i8;
        this.f14880c = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f14878a + ", startMode=" + this.f14879b + ", foregroundServiceTypes=" + this.f14880c + '}';
    }
}
