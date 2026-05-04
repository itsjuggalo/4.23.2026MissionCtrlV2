package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zziy extends zzmf implements zznn {
    private static final zziy zzf;
    private int zzb;
    private String zzd = "";
    private zzmo zze = zzmf.zzcv();

    static {
        zziy zziyVar = new zziy();
        zzf = zziyVar;
        zzmf.zzcp(zziy.class, zziyVar);
    }

    private zziy() {
    }

    public final String zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", zzje.class});
        }
        if (i11 == 3) {
            return new zziy();
        }
        byte[] bArr = null;
        if (i11 == 4) {
            return new zzix(bArr);
        }
        if (i11 == 5) {
            return zzf;
        }
        throw null;
    }
}
