package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.f3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1335f3 extends J1 implements InterfaceC1339g2 {
    private static final C1335f3 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;

    static {
        C1335f3 c1335f3 = new C1335f3();
        zzb = c1335f3;
        J1.v(C1335f3.class, c1335f3);
    }

    public static /* synthetic */ void A(C1335f3 c1335f3, int i8) {
        c1335f3.zzd |= 8;
        c1335f3.zzh = i8;
    }

    public static /* synthetic */ void B(C1335f3 c1335f3, long j8) {
        c1335f3.zzd |= 16;
        c1335f3.zzi = j8;
    }

    public static /* synthetic */ void C(C1335f3 c1335f3, long j8) {
        c1335f3.zzd |= 32;
        c1335f3.zzj = j8;
    }

    public static /* synthetic */ void D(C1335f3 c1335f3, long j8) {
        c1335f3.zzd |= 512;
        c1335f3.zzn = 772604006L;
    }

    public static /* synthetic */ void E(C1335f3 c1335f3, String str) {
        str.getClass();
        c1335f3.zzd |= 4;
        c1335f3.zzg = str;
    }

    public static /* synthetic */ void F(C1335f3 c1335f3, boolean z7) {
        c1335f3.zzd |= 64;
        c1335f3.zzk = z7;
    }

    public static /* synthetic */ void G(C1335f3 c1335f3, String str) {
        str.getClass();
        c1335f3.zzd |= 1;
        c1335f3.zze = str;
    }

    public static /* synthetic */ void H(C1335f3 c1335f3, String str) {
        c1335f3.zzd |= 2;
        c1335f3.zzf = str;
    }

    public static C1325d3 I() {
        return (C1325d3) zzb.k();
    }

    public static /* synthetic */ void y(C1335f3 c1335f3, int i8) {
        c1335f3.zzd |= 128;
        c1335f3.zzl = i8;
    }

    public static /* synthetic */ void z(C1335f3 c1335f3, int i8) {
        c1335f3.zzd |= 256;
        c1335f3.zzm = i8;
    }

    @Override // com.google.android.gms.internal.play_billing.J1
    public final Object f(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return J1.s(zzb, "\u0004\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003င\u0003\u0004ဂ\u0004\u0005ဈ\u0001\u0006ဂ\u0005\u0007ဇ\u0006\bင\u0007\tင\b\nဂ\t", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzf", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i9 == 3) {
            return new C1335f3();
        }
        AbstractC1330e3 abstractC1330e3 = null;
        if (i9 == 4) {
            return new C1325d3(abstractC1330e3);
        }
        if (i9 == 5) {
            return zzb;
        }
        throw null;
    }
}
