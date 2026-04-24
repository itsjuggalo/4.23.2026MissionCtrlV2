package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class J3 extends J1 implements InterfaceC1339g2 {
    private static final J3 zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;

    static {
        J3 j32 = new J3();
        zzb = j32;
        J1.v(J3.class, j32);
    }

    public static /* synthetic */ void A(J3 j32, long j8) {
        j32.zzd |= 4;
        j32.zzg = j8;
    }

    public static /* synthetic */ void B(J3 j32, boolean z7) {
        j32.zzd |= 2;
        j32.zzf = true;
    }

    public static H3 C() {
        return (H3) zzb.k();
    }

    public static /* synthetic */ void y(J3 j32, boolean z7) {
        j32.zzd |= 8;
        j32.zzh = z7;
    }

    public static /* synthetic */ void z(J3 j32, int i8) {
        j32.zzd |= 16;
        j32.zzi = i8;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i9 == 3) {
            return new J3();
        }
        I3 i32 = null;
        if (i9 == 4) {
            return new H3(i32);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
