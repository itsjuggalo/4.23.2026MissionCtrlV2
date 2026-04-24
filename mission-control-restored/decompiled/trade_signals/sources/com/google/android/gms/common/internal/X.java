package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f14944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14945b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14946c;

    public X(AbstractC1283c abstractC1283c, Object obj) {
        this.f14946c = abstractC1283c;
        this.f14944a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f14944a;
                if (this.f14945b) {
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
            this.f14945b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f14944a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f14946c.zzt) {
            this.f14946c.zzt.remove(this);
        }
    }
}
