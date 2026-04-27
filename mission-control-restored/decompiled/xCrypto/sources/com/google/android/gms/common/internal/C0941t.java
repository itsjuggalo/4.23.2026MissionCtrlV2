package com.google.android.gms.common.internal;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0941t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0941t f9968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0942u f9969c = new C0942u(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0942u f9970a;

    public static synchronized C0941t b() {
        try {
            if (f9968b == null) {
                f9968b = new C0941t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9968b;
    }

    public C0942u a() {
        return this.f9970a;
    }

    public final synchronized void c(C0942u c0942u) {
        if (c0942u == null) {
            this.f9970a = f9969c;
            return;
        }
        C0942u c0942u2 = this.f9970a;
        if (c0942u2 == null || c0942u2.n() < c0942u.n()) {
            this.f9970a = c0942u;
        }
    }
}
