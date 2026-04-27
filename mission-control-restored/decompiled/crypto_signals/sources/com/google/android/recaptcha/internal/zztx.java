package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zztx extends zznd implements zzoj {
    private static final zztx zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zztx zztxVar = new zztx();
        zzb = zztxVar;
        zznd.zzI(zztx.class, zztxVar);
    }

    private zztx() {
    }

    public static /* synthetic */ void zzM(zztx zztxVar, zzrr zzrrVar) {
        zzrrVar.getClass();
        zztxVar.zzf = zzrrVar;
        zztxVar.zze = 2;
    }

    public static zztw zzi() {
        return (zztw) zzb.zzq();
    }

    public static zztx zzk(byte[] bArr) {
        return (zztx) zznd.zzx(zzb, bArr);
    }

    public static /* synthetic */ void zzl(zztx zztxVar, zzrc zzrcVar) {
        zzrcVar.getClass();
        zztxVar.zzf = zzrcVar;
        zztxVar.zze = 1;
    }

    public final int zzN() {
        int i = this.zze;
        if (i == 0) {
            return 3;
        }
        int i6 = 1;
        if (i != 1) {
            i6 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i6;
    }

    public final zzrc zzf() {
        return this.zze == 1 ? (zzrc) this.zzf : zzrc.zzk();
    }

    public final zzrr zzg() {
        return this.zze == 2 ? (zzrr) this.zzf : zzrr.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zzf", "zze", zzrc.class, zzrr.class});
        }
        if (i6 == 3) {
            return new zztx();
        }
        zzug zzugVar = null;
        if (i6 == 4) {
            return new zztw(zzugVar);
        }
        if (i6 == 5) {
            return zzb;
        }
        if (i6 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zztx.class) {
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
