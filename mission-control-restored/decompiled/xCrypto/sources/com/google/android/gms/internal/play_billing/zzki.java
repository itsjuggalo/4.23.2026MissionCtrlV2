package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzki extends zzhk implements zzin {
    private static final zzki zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        zzki zzkiVar = new zzki();
        zzb = zzkiVar;
        zzhk.zzx(zzki.class, zzkiVar);
    }

    private zzki() {
    }

    public static /* synthetic */ void zzC(zzki zzkiVar, String str) {
        zzkiVar.zzd |= 8;
        zzkiVar.zzh = str;
    }

    public static /* synthetic */ void zzD(zzki zzkiVar, String str) {
        str.getClass();
        zzkiVar.zzd |= 2;
        zzkiVar.zzf = str;
    }

    public static /* synthetic */ void zzE(zzki zzkiVar, int i4) {
        zzkiVar.zzd |= 1;
        zzkiVar.zze = i4;
    }

    public static /* synthetic */ void zzF(zzki zzkiVar, int i4) {
        zzkiVar.zzg = i4 - 1;
        zzkiVar.zzd |= 4;
    }

    public static zzke zzc() {
        return (zzke) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzkf.zza, "zzh"});
        }
        if (i5 == 3) {
            return new zzki();
        }
        zzkh zzkhVar = null;
        if (i5 == 4) {
            return new zzke(zzkhVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
