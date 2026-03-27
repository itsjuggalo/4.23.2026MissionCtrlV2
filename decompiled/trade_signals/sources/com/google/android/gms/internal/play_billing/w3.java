package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class w3 extends J1 implements InterfaceC1339g2 {
    private static final w3 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private C1335f3 zzg;
    private C1350i3 zzh;

    static {
        w3 w3Var = new w3();
        zzb = w3Var;
        J1.v(w3.class, w3Var);
    }

    public static /* synthetic */ void A(w3 w3Var, W2 w22) {
        w22.getClass();
        w3Var.zzf = w22;
        w3Var.zze = 7;
    }

    public static /* synthetic */ void B(w3 w3Var, C1335f3 c1335f3) {
        c1335f3.getClass();
        w3Var.zzg = c1335f3;
        w3Var.zzd |= 1;
    }

    public static /* synthetic */ void C(w3 w3Var, C3 c32) {
        c32.getClass();
        w3Var.zzf = c32;
        w3Var.zze = 8;
    }

    public static /* synthetic */ void D(w3 w3Var, G3 g32) {
        w3Var.zzf = g32;
        w3Var.zze = 4;
    }

    public static C1409u3 E() {
        return (C1409u3) zzb.k();
    }

    public static /* synthetic */ void y(w3 w3Var, J2 j22) {
        w3Var.zzf = j22;
        w3Var.zze = 2;
    }

    public static /* synthetic */ void z(w3 w3Var, O2 o22) {
        w3Var.zzf = o22;
        w3Var.zze = 3;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", J2.class, O2.class, G3.class, C1320c3.class, "zzh", W2.class, C3.class});
        }
        if (i9 == 3) {
            return new w3();
        }
        v3 v3Var = null;
        if (i9 == 4) {
            return new C1409u3(v3Var);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
