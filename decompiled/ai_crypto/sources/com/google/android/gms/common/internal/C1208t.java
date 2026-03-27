package com.google.android.gms.common.internal;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1208t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C1208t f11151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1209u f11152c = new C1209u(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1209u f11153a;

    public static synchronized C1208t b() {
        try {
            if (f11151b == null) {
                f11151b = new C1208t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f11151b;
    }

    public C1209u a() {
        return this.f11153a;
    }

    public final synchronized void c(C1209u c1209u) {
        if (c1209u == null) {
            this.f11153a = f11152c;
            return;
        }
        C1209u c1209u2 = this.f11153a;
        if (c1209u2 == null || c1209u2.E() < c1209u.E()) {
            this.f11153a = c1209u;
        }
    }
}
