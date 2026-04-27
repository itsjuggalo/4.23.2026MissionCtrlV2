package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class T2 extends J1 implements InterfaceC1339g2 {
    private static final T2 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private int zzi;
    private String zzf = "";
    private String zzh = "";

    static {
        T2 t22 = new T2();
        zzb = t22;
        J1.v(T2.class, t22);
    }

    public static /* synthetic */ void A(T2 t22, int i8) {
        t22.zzd |= 16;
        t22.zzi = i8;
    }

    public static /* synthetic */ void B(T2 t22, R2 r22) {
        t22.zzg = r22.zza();
        t22.zzd |= 4;
    }

    public static /* synthetic */ void C(T2 t22, int i8) {
        t22.zzd |= 1;
        t22.zze = i8;
    }

    public static P2 D() {
        return (P2) zzb.k();
    }

    public static /* synthetic */ void y(T2 t22, String str) {
        t22.zzd |= 8;
        t22.zzh = str;
    }

    public static /* synthetic */ void z(T2 t22, String str) {
        str.getClass();
        t22.zzd |= 2;
        t22.zzf = str;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003\u0007င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", Q2.f15208a, "zzh", "zzi"});
        }
        if (i9 == 3) {
            return new T2();
        }
        S2 s22 = null;
        if (i9 == 4) {
            return new P2(s22);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
