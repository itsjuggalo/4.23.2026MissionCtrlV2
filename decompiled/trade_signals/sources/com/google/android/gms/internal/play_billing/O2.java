package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class O2 extends J1 implements InterfaceC1339g2 {
    private static final O2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private int zzh;

    static {
        O2 o22 = new O2();
        zzb = o22;
        J1.v(O2.class, o22);
    }

    public static /* synthetic */ void A(O2 o22, C1370m3 c1370m3) {
        c1370m3.getClass();
        o22.zzf = c1370m3;
        o22.zze = 2;
    }

    public static /* synthetic */ void B(O2 o22, C1404t3 c1404t3) {
        c1404t3.getClass();
        o22.zzf = c1404t3;
        o22.zze = 4;
    }

    public static /* synthetic */ void C(O2 o22, J3 j32) {
        j32.getClass();
        o22.zzf = j32;
        o22.zze = 3;
    }

    public static /* synthetic */ void D(O2 o22, int i8) {
        o22.zzg = i8 - 1;
        o22.zzd |= 1;
    }

    public static L2 E() {
        return (L2) zzb.k();
    }

    public static /* synthetic */ void z(O2 o22, Y2 y22) {
        o22.zzh = y22.zza();
        o22.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005᠌\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", K2.f15175a, C1370m3.class, J3.class, C1404t3.class, "zzh", X2.f15374a});
        }
        if (i9 == 3) {
            return new O2();
        }
        N2 n22 = null;
        if (i9 == 4) {
            return new L2(n22);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }

    public final C1404t3 y() {
        return this.zze == 4 ? (C1404t3) this.zzf : C1404t3.A();
    }
}
