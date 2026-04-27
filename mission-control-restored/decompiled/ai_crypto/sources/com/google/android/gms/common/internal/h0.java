package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11101b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11102c;

    public h0(AbstractC1192c abstractC1192c, Object obj) {
        this.f11102c = abstractC1192c;
        this.f11100a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f11100a;
                if (this.f11101b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f11101b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f11100a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f11102c.zzt) {
            this.f11102c.zzt.remove(this);
        }
    }
}
