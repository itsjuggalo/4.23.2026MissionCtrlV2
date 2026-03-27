package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class G3 extends J1 implements InterfaceC1339g2 {
    private static final G3 zzb;
    private int zzd;
    private int zze;

    static {
        G3 g32 = new G3();
        zzb = g32;
        J1.v(G3.class, g32);
    }

    public static G3 z() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", E3.f15158a});
        }
        if (i9 == 3) {
            return new G3();
        }
        F3 f32 = null;
        if (i9 == 4) {
            return new D3(f32);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
