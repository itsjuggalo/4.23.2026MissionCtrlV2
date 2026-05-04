package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzjv extends zzfi implements zzgm {
    private static final zzjv zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzjv zzjvVar = new zzjv();
        zzb = zzjvVar;
        zzfi.zzw(zzjv.class, zzjvVar);
    }

    private zzjv() {
    }

    public static /* synthetic */ void zzA(zzjv zzjvVar, boolean z10) {
        zzjvVar.zzd |= 8;
        zzjvVar.zzh = z10;
    }

    public static /* synthetic */ void zzB(zzjv zzjvVar, int i10) {
        zzjvVar.zzd |= 16;
        zzjvVar.zzi = i10;
    }

    public static /* synthetic */ void zzC(zzjv zzjvVar, long j10) {
        zzjvVar.zzd |= 4;
        zzjvVar.zzg = j10;
    }

    public static /* synthetic */ void zzD(zzjv zzjvVar, boolean z10) {
        zzjvVar.zzd |= 2;
        zzjvVar.zzf = true;
    }

    public static zzjt zzc() {
        return (zzjt) zzb.zzl();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzfi.zzt(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zzjv();
        }
        zzju zzjuVar = null;
        if (i11 == 4) {
            return new zzjt(zzjuVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        throw null;
    }
}
