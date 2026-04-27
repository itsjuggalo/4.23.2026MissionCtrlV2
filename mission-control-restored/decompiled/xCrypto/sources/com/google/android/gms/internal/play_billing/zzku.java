package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzku extends zzhk implements zzin {
    private static final zzku zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private long zzh;

    static {
        zzku zzkuVar = new zzku();
        zzb = zzkuVar;
        zzhk.zzx(zzku.class, zzkuVar);
    }

    private zzku() {
    }

    public static /* synthetic */ void zzC(zzku zzkuVar, int i4) {
        zzkuVar.zzd |= 4;
        zzkuVar.zzg = i4;
    }

    public static /* synthetic */ void zzD(zzku zzkuVar, long j4) {
        zzkuVar.zzd |= 8;
        zzkuVar.zzh = j4;
    }

    public static /* synthetic */ void zzE(zzku zzkuVar, String str) {
        str.getClass();
        zzkuVar.zzd |= 2;
        zzkuVar.zzf = str;
    }

    public static /* synthetic */ void zzF(zzku zzkuVar, String str) {
        str.getClass();
        zzkuVar.zzd |= 1;
        zzkuVar.zze = str;
    }

    public static zzks zzc() {
        return (zzks) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i5 == 3) {
            return new zzku();
        }
        zzkt zzktVar = null;
        if (i5 == 4) {
            return new zzks(zzktVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
