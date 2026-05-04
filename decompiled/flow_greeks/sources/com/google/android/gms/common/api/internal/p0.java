package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f5613b;

    public p0(o0 o0Var) {
        this.f5613b = o0Var;
    }

    public final void a(Context context) {
        this.f5612a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f5612a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f5612a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f5613b.a();
            b();
        }
    }
}
