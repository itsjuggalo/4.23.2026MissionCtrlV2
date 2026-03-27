package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzlb extends zzhk implements zzin {
    private static final zzlb zzb;
    private int zzd;
    private int zze;

    static {
        zzlb zzlbVar = new zzlb();
        zzb = zzlbVar;
        zzhk.zzx(zzlb.class, zzlbVar);
    }

    private zzlb() {
    }

    public static /* synthetic */ void zzC(zzlb zzlbVar, int i4) {
        zzlbVar.zze = i4 - 1;
        zzlbVar.zzd |= 1;
    }

    public static zzky zzc() {
        return (zzky) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkz.zza});
        }
        if (i5 == 3) {
            return new zzlb();
        }
        zzla zzlaVar = null;
        if (i5 == 4) {
            return new zzky(zzlaVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
