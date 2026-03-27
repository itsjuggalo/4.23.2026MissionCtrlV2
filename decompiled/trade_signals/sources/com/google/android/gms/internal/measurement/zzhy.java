package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzhy extends zzmf implements zznn {
    private static final zzhy zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private zzhc zzf;

    static {
        zzhy zzhyVar = new zzhy();
        zzg = zzhyVar;
        zzmf.zzcp(zzhy.class, zzhyVar);
    }

    private zzhy() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return zzmf.zzcq(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new zzhy();
        }
        byte[] bArr = null;
        if (i9 == 4) {
            return new zzhx(bArr);
        }
        if (i9 == 5) {
            return zzg;
        }
        throw null;
    }
}
