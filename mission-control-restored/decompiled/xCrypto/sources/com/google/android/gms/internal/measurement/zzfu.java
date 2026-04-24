package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzfu extends zzme implements zznm {
    private static final zzfu zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzfu zzfuVar = new zzfu();
        zzg = zzfuVar;
        zzme.zzcp(zzfu.class, zzfuVar);
    }

    private zzfu() {
    }

    public final int zzb() {
        int iZza = zzga.zza(this.zzd);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzc() {
        int iZza = zzfy.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzd() {
        int iZza = zzge.zza(this.zzf);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", zzfz.zza, "zze", zzfx.zza, "zzf", zzgd.zza});
        }
        if (i5 == 3) {
            return new zzfu();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzft(bArr);
        }
        if (i5 == 5) {
            return zzg;
        }
        throw null;
    }
}
