package com.google.android.gms.common.internal;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1295o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C1295o f15043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1296p f15044c = new C1296p(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1296p f15045a;

    public static synchronized C1295o b() {
        try {
            if (f15043b == null) {
                f15043b = new C1295o();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15043b;
    }

    public C1296p a() {
        return this.f15045a;
    }

    public final synchronized void c(C1296p c1296p) {
        if (c1296p == null) {
            this.f15045a = f15044c;
            return;
        }
        C1296p c1296p2 = this.f15045a;
        if (c1296p2 == null || c1296p2.h() < c1296p.h()) {
            this.f15045a = c1296p;
        }
    }
}
