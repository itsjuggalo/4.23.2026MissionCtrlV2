package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class S extends com.google.android.gms.common.api.v implements com.google.android.gms.common.api.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f5122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5123b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f5124c;

    public S(WeakReference weakReference) {
        com.google.android.gms.common.internal.I.h(weakReference, "GoogleApiClient reference must not be null");
        this.f5124c = weakReference;
        com.google.android.gms.common.api.o oVar = (com.google.android.gms.common.api.o) weakReference.get();
        new Q(this, oVar != null ? ((H) oVar).f5099b.getLooper() : Looper.getMainLooper());
    }

    public final void a(Status status) {
        synchronized (this.f5123b) {
            synchronized (this.f5123b) {
            }
        }
    }
}
