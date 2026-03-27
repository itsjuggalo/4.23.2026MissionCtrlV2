package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f4986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4988c;

    public h(NotificationDetails notificationDetails, int i, ArrayList arrayList) {
        this.f4986a = notificationDetails;
        this.f4987b = i;
        this.f4988c = arrayList;
    }

    public final String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f4986a + ", startMode=" + this.f4987b + ", foregroundServiceTypes=" + this.f4988c + '}';
    }
}
