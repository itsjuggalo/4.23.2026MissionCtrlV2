package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1372n0 extends AbstractC1362l0 {
    public /* synthetic */ C1372n0(AbstractC1411v0 abstractC1411v0) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1347i0 a(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0) {
        C1347i0 c1347i02;
        synchronized (abstractC1387q0) {
            try {
                c1347i02 = abstractC1387q0.f15492b;
                if (c1347i02 != c1347i0) {
                    abstractC1387q0.f15492b = c1347i0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1347i02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final C1382p0 b(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0) {
        C1382p0 c1382p02;
        synchronized (abstractC1387q0) {
            try {
                c1382p02 = abstractC1387q0.f15493c;
                if (c1382p02 != c1382p0) {
                    abstractC1387q0.f15493c = c1382p0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1382p02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void c(C1382p0 c1382p0, C1382p0 c1382p02) {
        c1382p0.f15483b = c1382p02;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final void d(C1382p0 c1382p0, Thread thread) {
        c1382p0.f15482a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean e(AbstractC1387q0 abstractC1387q0, C1347i0 c1347i0, C1347i0 c1347i02) {
        synchronized (abstractC1387q0) {
            try {
                if (abstractC1387q0.f15492b != c1347i0) {
                    return false;
                }
                abstractC1387q0.f15492b = c1347i02;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean f(AbstractC1387q0 abstractC1387q0, Object obj, Object obj2) {
        synchronized (abstractC1387q0) {
            try {
                if (abstractC1387q0.f15491a != obj) {
                    return false;
                }
                abstractC1387q0.f15491a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1362l0
    public final boolean g(AbstractC1387q0 abstractC1387q0, C1382p0 c1382p0, C1382p0 c1382p02) {
        synchronized (abstractC1387q0) {
            try {
                if (abstractC1387q0.f15493c != c1382p0) {
                    return false;
                }
                abstractC1387q0.f15493c = c1382p02;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
