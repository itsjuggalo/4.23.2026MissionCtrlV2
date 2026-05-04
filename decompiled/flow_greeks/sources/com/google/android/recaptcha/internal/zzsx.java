package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsx extends zznd implements zzoj {
    private static final zzsx zzb;
    private static volatile zzoq zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzni zzh = zznd.zzy();
    private int zzi;
    private int zzj;

    static {
        zzsx zzsxVar = new zzsx();
        zzb = zzsxVar;
        zznd.zzI(zzsx.class, zzsxVar);
    }

    private zzsx() {
    }

    public static zzsv zzf() {
        return (zzsv) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzsx zzsxVar, String str) {
        str.getClass();
        zzsxVar.zze |= 2;
        zzsxVar.zzg = str;
    }

    public static /* synthetic */ void zzj(zzsx zzsxVar, String str) {
        str.getClass();
        zzsxVar.zze |= 1;
        zzsxVar.zzf = str;
    }

    public static /* synthetic */ void zzk(zzsx zzsxVar, int i10) {
        zzsxVar.zzi = 2;
        zzsxVar.zze |= 4;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003'\u0004᠌\u0002\u0005င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzsw.zza, "zzj"});
        }
        if (i11 == 3) {
            return new zzsx();
        }
        zzta zztaVar = null;
        if (i11 == 4) {
            return new zzsv(zztaVar);
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
        synchronized (zzsx.class) {
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
}
