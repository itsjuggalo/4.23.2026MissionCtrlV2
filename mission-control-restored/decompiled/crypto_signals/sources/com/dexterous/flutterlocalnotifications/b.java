package com.dexterous.flutterlocalnotifications;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ void A() {
    }

    public static /* synthetic */ NotificationChannel b(int i, CharSequence charSequence, String str) {
        return new NotificationChannel(str, charSequence, i);
    }

    public static /* bridge */ /* synthetic */ NotificationChannel e(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* synthetic */ NotificationChannel f(String str) {
        return new NotificationChannel("fcm_fallback_notification_channel", str, 3);
    }

    public static /* synthetic */ NotificationChannelGroup g(String str, String str2) {
        return new NotificationChannelGroup(str, str2);
    }

    public static /* bridge */ /* synthetic */ AutofillManager k(Object obj) {
        return (AutofillManager) obj;
    }

    public static /* bridge */ /* synthetic */ AutofillValue l(Object obj) {
        return (AutofillValue) obj;
    }

    public static /* bridge */ /* synthetic */ Class n() {
        return AutofillManager.class;
    }

    public static /* synthetic */ void p() {
    }

    public static /* bridge */ /* synthetic */ boolean x(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }
}
