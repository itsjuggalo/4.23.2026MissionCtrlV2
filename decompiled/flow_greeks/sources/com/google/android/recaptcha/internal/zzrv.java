package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrv extends zznd implements zzoj {
    private static final zzrv zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzrt zzf;
    private zzrt zzg;

    static {
        zzrv zzrvVar = new zzrv();
        zzb = zzrvVar;
        zznd.zzI(zzrv.class, zzrvVar);
    }

    private zzrv() {
    }

    public static zzrv zzj(byte[] bArr) {
        return (zzrv) zznd.zzx(zzb, bArr);
    }

    public final zzrt zzf() {
        zzrt zzrtVar = this.zzf;
        return zzrtVar == null ? zzrt.zzg() : zzrtVar;
    }

    public final zzrt zzg() {
        zzrt zzrtVar = this.zzg;
        return zzrtVar == null ? zzrt.zzg() : zzrtVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzrv();
        }
        zzrw zzrwVar = null;
        if (i11 == 4) {
            return new zzru(zzrwVar);
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
        synchronized (zzrv.class) {
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
