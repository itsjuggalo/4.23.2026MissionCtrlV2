package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.c3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1320c3 extends J1 implements InterfaceC1339g2 {
    private static final C1320c3 zzb;
    private int zzd;
    private int zzf;
    private T2 zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private N1 zzg = J1.p();
    private O1 zzh = J1.q();

    static {
        C1320c3 c1320c3 = new C1320c3();
        zzb = c1320c3;
        J1.v(C1320c3.class, c1320c3);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", C1310a3.f15394a, "zzg", X2.f15374a, "zzh", z3.class, "zzi", "zzj", "zzk"});
        }
        if (i9 == 3) {
            return new C1320c3();
        }
        AbstractC1315b3 abstractC1315b3 = null;
        if (i9 == 4) {
            return new Z2(abstractC1315b3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
