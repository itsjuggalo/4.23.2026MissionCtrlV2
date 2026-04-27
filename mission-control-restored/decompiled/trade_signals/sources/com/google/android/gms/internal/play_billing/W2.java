package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class W2 extends J1 implements InterfaceC1339g2 {
    private static final W2 zzb;

    static {
        W2 w22 = new W2();
        zzb = w22;
        J1.v(W2.class, w22);
    }

    public static W2 z() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        V2 v22 = null;
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0000", null);
        }
        if (i9 == 3) {
            return new W2();
        }
        if (i9 == 4) {
            return new U2(v22);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
