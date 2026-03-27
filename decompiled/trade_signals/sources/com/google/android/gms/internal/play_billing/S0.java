package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class S0 extends J1 implements InterfaceC1339g2 {
    private static final S0 zzb;
    private O1 zzd = J1.q();

    static {
        S0 s02 = new S0();
        zzb = s02;
        J1.v(S0.class, s02);
    }

    public static /* synthetic */ void A(S0 s02, Iterable iterable) {
        O1 o12 = s02.zzd;
        if (!o12.zzc()) {
            int size = o12.size();
            s02.zzd = o12.zzd(size + size);
        }
        AbstractC1308a1.d(iterable, s02.zzd);
    }

    public static R0 y() {
        return (R0) zzb.k();
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", Q0.class});
        }
        if (i9 == 3) {
            return new S0();
        }
        T0 t02 = null;
        if (i9 == 4) {
            return new R0(t02);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
