package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zztz extends zznd implements zzoj {
    private static final zztz zzb;
    private static volatile zzoq zzd;
    private zznk zze = zznd.zzB();

    static {
        zztz zztzVar = new zztz();
        zzb = zztzVar;
        zznd.zzI(zztz.class, zztzVar);
    }

    private zztz() {
    }

    public static zztz zzg(byte[] bArr) {
        return (zztz) zznd.zzx(zzb, bArr);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zznd.zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzuf.class});
        }
        if (i6 == 3) {
            return new zztz();
        }
        zzug zzugVar = null;
        if (i6 == 4) {
            return new zzty(zzugVar);
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
        synchronized (zztz.class) {
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

    public final List zzi() {
        return this.zze;
    }
}
