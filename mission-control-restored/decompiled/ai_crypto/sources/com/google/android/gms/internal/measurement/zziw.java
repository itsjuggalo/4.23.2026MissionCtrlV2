package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zziw extends zzme implements zznm {
    private static final zziw zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zziw zziwVar = new zziw();
        zzd = zziwVar;
        zzme.zzcp(zziw.class, zziwVar);
    }

    private zziw() {
    }

    public static zziw zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzme.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zziy.class});
        }
        if (i8 == 3) {
            return new zziw();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zziv(bArr);
        }
        if (i8 == 5) {
            return zzd;
        }
        throw null;
    }
}
