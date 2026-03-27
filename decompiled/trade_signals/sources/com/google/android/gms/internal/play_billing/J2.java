package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class J2 extends J1 implements InterfaceC1339g2 {
    private static final J2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private T2 zzh;
    private int zzi;

    static {
        J2 j22 = new J2();
        zzb = j22;
        J1.v(J2.class, j22);
    }

    public static /* synthetic */ void A(J2 j22, Y2 y22) {
        j22.zzi = y22.zza();
        j22.zzd |= 4;
    }

    public static /* synthetic */ void B(J2 j22, T2 t22) {
        t22.getClass();
        j22.zzh = t22;
        j22.zzd |= 2;
    }

    public static /* synthetic */ void C(J2 j22, C1370m3 c1370m3) {
        c1370m3.getClass();
        j22.zzf = c1370m3;
        j22.zze = 4;
    }

    public static /* synthetic */ void D(J2 j22, C1404t3 c1404t3) {
        c1404t3.getClass();
        j22.zzf = c1404t3;
        j22.zze = 7;
    }

    public static /* synthetic */ void E(J2 j22, J3 j32) {
        j32.getClass();
        j22.zzf = j32;
        j22.zze = 6;
    }

    public static /* synthetic */ void F(J2 j22, int i8) {
        j22.zzg = i8 - 1;
        j22.zzd |= 1;
    }

    public static H2 G() {
        return (H2) zzb.k();
    }

    public static J2 y(byte[] bArr, C1428z1 c1428z1) {
        return (J2) J1.o(zzb, bArr, c1428z1);
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000\u0005᠌\u0002\u0006<\u0000\u0007<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", K2.f15175a, "zzh", C1370m3.class, "zzi", X2.f15374a, J3.class, C1404t3.class});
        }
        if (i9 == 3) {
            return new J2();
        }
        I2 i22 = null;
        if (i9 == 4) {
            return new H2(i22);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }

    public final C1404t3 z() {
        return this.zze == 7 ? (C1404t3) this.zzf : C1404t3.A();
    }
}
