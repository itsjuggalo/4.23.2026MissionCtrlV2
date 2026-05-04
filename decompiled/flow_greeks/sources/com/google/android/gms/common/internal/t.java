package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static t f5792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f5793c = new u(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f5794a;

    public static synchronized t b() {
        try {
            if (f5792b == null) {
                f5792b = new t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5792b;
    }

    public u a() {
        return this.f5794a;
    }

    public final synchronized void c(u uVar) {
        if (uVar == null) {
            this.f5794a = f5793c;
            return;
        }
        u uVar2 = this.f5794a;
        if (uVar2 == null || uVar2.V() < uVar.V()) {
            this.f5794a = uVar;
        }
    }
}
