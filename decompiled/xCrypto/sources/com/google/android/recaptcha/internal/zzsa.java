package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzsa extends zznd implements zzoj {
    private static final zzsa zzb;
    private static volatile zzoq zzd;
    private zzle zze = zzle.zzb;

    static {
        zzsa zzsaVar = new zzsa();
        zzb = zzsaVar;
        zznd.zzI(zzsa.class, zzsaVar);
    }

    private zzsa() {
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i4, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zznd.zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"zze"});
        }
        if (i5 == 3) {
            return new zzsa();
        }
        zzsn zzsnVar = null;
        if (i5 == 4) {
            return new zzrz(zzsnVar);
        }
        if (i5 == 5) {
            return zzb;
        }
        if (i5 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzsa.class) {
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
