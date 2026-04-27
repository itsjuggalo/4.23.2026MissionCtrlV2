package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zziy extends zzme implements zznm {
    private static final zziy zzf;
    private int zzb;
    private String zzd = "";
    private zzmn zze = zzme.zzcv();

    static {
        zziy zziyVar = new zziy();
        zzf = zziyVar;
        zzme.zzcp(zziy.class, zziyVar);
    }

    private zziy() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", zzje.class});
        }
        if (i5 == 3) {
            return new zziy();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzix(bArr);
        }
        if (i5 == 5) {
            return zzf;
        }
        throw null;
    }
}
