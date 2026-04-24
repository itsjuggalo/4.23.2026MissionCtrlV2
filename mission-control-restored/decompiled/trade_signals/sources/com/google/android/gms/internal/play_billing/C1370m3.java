package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1370m3 extends J1 implements InterfaceC1339g2 {
    private static final C1370m3 zzb;
    private int zzd;
    private int zze;

    static {
        C1370m3 c1370m3 = new C1370m3();
        zzb = c1370m3;
        J1.v(C1370m3.class, c1370m3);
    }

    public static /* synthetic */ void y(C1370m3 c1370m3, int i8) {
        c1370m3.zze = i8 - 1;
        c1370m3.zzd |= 1;
    }

    public static C1355j3 z() {
        return (C1355j3) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", C1360k3.f15449a});
        }
        if (i9 == 3) {
            return new C1370m3();
        }
        AbstractC1365l3 abstractC1365l3 = null;
        if (i9 == 4) {
            return new C1355j3(abstractC1365l3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
