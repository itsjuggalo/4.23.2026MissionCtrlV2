package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzho extends zzme implements zznm {
    private static final zzho zzd;
    private zzmn zzb = zzme.zzcv();

    static {
        zzho zzhoVar = new zzho();
        zzd = zzhoVar;
        zzme.zzcp(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    public static zzhh zzb() {
        return (zzhh) zzd.zzck();
    }

    public static zzho zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final /* synthetic */ void zzd(Iterable iterable) {
        zzmn zzmnVar = this.zzb;
        if (!zzmnVar.zza()) {
            this.zzb = zzme.zzcw(zzmnVar);
        }
        zzkr.zzce(iterable, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
        }
        if (i5 == 3) {
            return new zzho();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzhh(bArr);
        }
        if (i5 == 5) {
            return zzd;
        }
        throw null;
    }
}
