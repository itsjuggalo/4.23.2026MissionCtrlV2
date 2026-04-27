package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class K3 extends H0 {
    public K3() {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final void a(L3 l32, L3 l33) {
        l32.f15179b = l33;
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final void b(L3 l32, Thread thread) {
        l32.f15178a = thread;
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean c(N3 n32, C1398s2 c1398s2, C1398s2 c1398s22) {
        synchronized (n32) {
            try {
                if (n32.f15191b != c1398s2) {
                    return false;
                }
                n32.f15191b = c1398s22;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean d(N3 n32, Object obj, Object obj2) {
        synchronized (n32) {
            try {
                if (n32.f15190a != obj) {
                    return false;
                }
                n32.f15190a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.H0
    public final boolean e(N3 n32, L3 l32, L3 l33) {
        synchronized (n32) {
            try {
                if (n32.f15192c != l32) {
                    return false;
                }
                n32.f15192c = l33;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
