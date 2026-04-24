package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.r3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1394r3 extends J1 implements InterfaceC1339g2 {
    private static final C1394r3 zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        C1394r3 c1394r3 = new C1394r3();
        zzb = c1394r3;
        J1.v(C1394r3.class, c1394r3);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", C1390q3.f15494a, "zzf"});
        }
        if (i9 == 3) {
            return new C1394r3();
        }
        AbstractC1399s3 abstractC1399s3 = null;
        if (i9 == 4) {
            return new C1385p3(abstractC1399s3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
