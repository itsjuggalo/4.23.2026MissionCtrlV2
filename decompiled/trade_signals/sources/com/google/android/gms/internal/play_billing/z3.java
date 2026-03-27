package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class z3 extends J1 implements InterfaceC1339g2 {
    private static final z3 zzb;
    private int zzd;
    private int zzf;
    private O1 zze = J1.q();
    private String zzg = "";

    static {
        z3 z3Var = new z3();
        zzb = z3Var;
        J1.v(z3.class, z3Var);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new z3();
        }
        y3 y3Var = null;
        if (i9 == 4) {
            return new x3(y3Var);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
