package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzgr extends zzme implements zznm {
    private static final zzgr zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgr zzgrVar = new zzgr();
        zzf = zzgrVar;
        zzme.zzcp(zzgr.class, zzgrVar);
    }

    private zzgr() {
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i5 == 3) {
            return new zzgr();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzgq(bArr);
        }
        if (i5 == 5) {
            return zzf;
        }
        throw null;
    }
}
