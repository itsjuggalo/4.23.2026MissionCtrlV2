package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzkr extends zzhk implements zzin {
    private static final zzkr zzb;
    private int zzd;
    private int zzf;
    private zzki zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzhn zzg = zzhk.zzr();
    private zzho zzh = zzhk.zzs();

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzhk.zzx(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", zzkp.zza, "zzg", zzkm.zza, "zzh", zzln.class, "zzi", "zzj", "zzk"});
        }
        if (i5 == 3) {
            return new zzkr();
        }
        zzkq zzkqVar = null;
        if (i5 == 4) {
            return new zzko(zzkqVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
