package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1404t3 extends J1 implements InterfaceC1339g2 {
    private static final C1404t3 zzb;
    private int zzd;
    private O1 zze = J1.q();
    private String zzf = "";
    private boolean zzg;

    static {
        C1404t3 c1404t3 = new C1404t3();
        zzb = c1404t3;
        J1.v(C1404t3.class, c1404t3);
    }

    public static C1404t3 A() {
        return zzb;
    }

    public static /* synthetic */ void y(C1404t3 c1404t3, boolean z7) {
        c1404t3.zzd |= 2;
        c1404t3.zzg = z7;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဇ\u0001", new Object[]{"zzd", "zze", C1394r3.class, "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new C1404t3();
        }
        AbstractC1399s3 abstractC1399s3 = null;
        if (i9 == 4) {
            return new C1380o3(abstractC1399s3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
