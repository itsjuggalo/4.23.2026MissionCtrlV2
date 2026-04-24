package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzja extends zzme implements zznm {
    private static final zzja zzf;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private zziw zze;

    static {
        zzja zzjaVar = new zzja();
        zzf = zzjaVar;
        zzme.zzcp(zzja.class, zzjaVar);
    }

    private zzja() {
    }

    public final List zza() {
        return this.zzd;
    }

    public final zziw zzb() {
        zziw zziwVar = this.zze;
        return zziwVar == null ? zziw.zzc() : zziwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
        }
        if (i5 == 3) {
            return new zzja();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zziz(bArr);
        }
        if (i5 == 5) {
            return zzf;
        }
        throw null;
    }
}
