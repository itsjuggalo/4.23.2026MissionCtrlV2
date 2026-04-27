package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class C3 extends J1 implements InterfaceC1339g2 {
    private static final C3 zzb;
    private int zzd;
    private T2 zze;
    private long zzf;

    static {
        C3 c32 = new C3();
        zzb = c32;
        J1.v(C3.class, c32);
    }

    public static A3 A() {
        return (A3) zzb.k();
    }

    public static /* synthetic */ void y(C3 c32, T2 t22) {
        t22.getClass();
        c32.zze = t22;
        c32.zzd |= 1;
    }

    public static /* synthetic */ void z(C3 c32, long j8) {
        c32.zzd |= 2;
        c32.zzf = j8;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new C3();
        }
        B3 b32 = null;
        if (i9 == 4) {
            return new A3(b32);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
