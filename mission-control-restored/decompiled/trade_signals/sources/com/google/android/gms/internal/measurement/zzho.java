package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzho extends zzmf implements zznn {
    private static final zzho zzd;
    private zzmo zzb = zzmf.zzcv();

    static {
        zzho zzhoVar = new zzho();
        zzd = zzhoVar;
        zzmf.zzcp(zzho.class, zzhoVar);
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
        zzmo zzmoVar = this.zzb;
        if (!zzmoVar.zza()) {
            this.zzb = zzmf.zzcw(zzmoVar);
        }
        zzks.zzce(iterable, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return zzmf.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
        }
        if (i9 == 3) {
            return new zzho();
        }
        byte[] bArr = null;
        if (i9 == 4) {
            return new zzhh(bArr);
        }
        if (i9 == 5) {
            return zzd;
        }
        throw null;
    }
}
