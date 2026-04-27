package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzkd extends zzhk implements zzin {
    private static final zzkd zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzkd zzkdVar = new zzkd();
        zzb = zzkdVar;
        zzhk.zzx(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static /* synthetic */ void zzC(zzkd zzkdVar, zzlb zzlbVar) {
        zzlbVar.getClass();
        zzkdVar.zzf = zzlbVar;
        zzkdVar.zze = 2;
    }

    public static /* synthetic */ void zzD(zzkd zzkdVar, zzlx zzlxVar) {
        zzlxVar.getClass();
        zzkdVar.zzf = zzlxVar;
        zzkdVar.zze = 3;
    }

    public static /* synthetic */ void zzE(zzkd zzkdVar, int i4) {
        zzkdVar.zzg = i4 - 1;
        zzkdVar.zzd |= 1;
    }

    public static zzkb zzc() {
        return (zzkb) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzka.zza, zzlb.class, zzlx.class, zzlh.class});
        }
        if (i5 == 3) {
            return new zzkd();
        }
        zzkc zzkcVar = null;
        if (i5 == 4) {
            return new zzkb(zzkcVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
