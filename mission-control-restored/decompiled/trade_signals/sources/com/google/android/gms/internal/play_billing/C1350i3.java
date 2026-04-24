package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.i3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1350i3 extends J1 implements InterfaceC1339g2 {
    private static final C1350i3 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        C1350i3 c1350i3 = new C1350i3();
        zzb = c1350i3;
        J1.v(C1350i3.class, c1350i3);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new C1350i3();
        }
        AbstractC1345h3 abstractC1345h3 = null;
        if (i9 == 4) {
            return new C1340g3(abstractC1345h3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
