package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class X extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f9743b;

    public X(W w4) {
        this.f9743b = w4;
    }

    public final void a(Context context) {
        this.f9742a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f9742a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f9742a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f9743b.a();
            b();
        }
    }
}
