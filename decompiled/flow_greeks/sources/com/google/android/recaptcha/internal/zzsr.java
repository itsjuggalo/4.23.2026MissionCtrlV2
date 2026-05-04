package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsr extends zznd implements zzoj {
    private static final zzsr zzb;
    private static volatile zzoq zzd;
    private int zze;
    private long zzg;
    private int zzh;
    private String zzf = "";
    private zznk zzi = zznd.zzB();
    private zzle zzj = zzle.zzb;
    private String zzk = "";
    private String zzl = "";

    static {
        zzsr zzsrVar = new zzsr();
        zzb = zzsrVar;
        zznd.zzI(zzsr.class, zzsrVar);
    }

    private zzsr() {
    }

    public static zzsr zzi() {
        return zzb;
    }

    public final zzle zzf() {
        return this.zzj;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0000\u0007\u0000\u0001\u0001\b\u0007\u0000\u0001\u0000\u0001ለ\u0000\u0002ဂ\u0001\u0004ဌ\u0002\u0005\u001b\u0006ည\u0003\u0007ለ\u0004\bለ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzst.class, "zzj", "zzk", "zzl"});
        }
        if (i11 == 3) {
            return new zzsr();
        }
        zzsu zzsuVar = null;
        if (i11 == 4) {
            return new zzsq(zzsuVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        if (i11 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzsr.class) {
            try {
                zzmyVar = zzd;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzb);
                    zzd = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zzi;
    }
}
