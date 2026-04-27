package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class L implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f9546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9548c;

    public L(NotificationDetails notificationDetails, int i4, ArrayList arrayList) {
        this.f9546a = notificationDetails;
        this.f9547b = i4;
        this.f9548c = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f9546a + ", startMode=" + this.f9547b + ", foregroundServiceTypes=" + this.f9548c + '}';
    }
}
