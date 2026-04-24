package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class Q0 extends J1 implements InterfaceC1339g2 {
    private static final Q0 zzb;
    private int zzd;
    private V0 zze;
    private V0 zzf;
    private int zzg;

    static {
        Q0 q02 = new Q0();
        zzb = q02;
        J1.v(Q0.class, q02);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", Y0.a()});
        }
        if (i9 == 3) {
            return new Q0();
        }
        T0 t02 = null;
        if (i9 == 4) {
            return new P0(t02);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
