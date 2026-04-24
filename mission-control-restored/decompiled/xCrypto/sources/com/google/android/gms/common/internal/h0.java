package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9918b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9919c;

    public h0(AbstractC0925c abstractC0925c, Object obj) {
        this.f9919c = abstractC0925c;
        this.f9917a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f9917a;
                if (this.f9918b) {
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
            this.f9918b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f9917a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f9919c.zzt) {
            this.f9919c.zzt.remove(this);
        }
    }
}
