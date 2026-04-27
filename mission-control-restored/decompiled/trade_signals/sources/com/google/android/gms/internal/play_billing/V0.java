package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class V0 extends J1 implements InterfaceC1339g2 {
    private static final V0 zzb;
    private int zzd;
    private String zze = "";

    static {
        V0 v02 = new V0();
        zzb = v02;
        J1.v(V0.class, v02);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i9 == 3) {
            return new V0();
        }
        W0 w02 = null;
        if (i9 == 4) {
            return new U0(w02);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
