package io.flutter.plugin.editing;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ NotificationChannel c(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ JobWorkItem e(Intent intent) {
        return new JobWorkItem(intent);
    }
}
