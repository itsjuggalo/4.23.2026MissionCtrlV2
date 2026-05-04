package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f5337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5339c;

    public g(NotificationDetails notificationDetails, int i10, ArrayList arrayList) {
        this.f5337a = notificationDetails;
        this.f5338b = i10;
        this.f5339c = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f5337a + ", startMode=" + this.f5338b + ", foregroundServiceTypes=" + this.f5339c + '}';
    }
}
