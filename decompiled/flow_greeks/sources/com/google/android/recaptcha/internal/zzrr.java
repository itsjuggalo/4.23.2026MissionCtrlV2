package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzrr extends zznd implements zzoj {
    private static final zzrr zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private zzml zzj;
    private zzpj zzk;
    private int zzl;
    private zzqz zzm;
    private String zzh = "";
    private String zzi = "";
    private zznk zzn = zznd.zzB();

    static {
        zzrr zzrrVar = new zzrr();
        zzb = zzrrVar;
        zznd.zzI(zzrr.class, zzrrVar);
    }

    private zzrr() {
    }

    public static zzrr zzg() {
        return zzb;
    }

    public static zzrr zzi(byte[] bArr) {
        return (zzrr) zznd.zzx(zzb, bArr);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0000\t\u0000\u0001\u0001\u000b\t\u0000\u0001\u0000\u0001\u0004\u0003ဉ\u0000\u0004ဉ\u0001\u0005\f\u0007\u001b\b\f\tȈ\nȈ\u000bဉ\u0002", new Object[]{"zze", "zzf", "zzj", "zzk", "zzl", "zzn", zzri.class, "zzg", "zzh", "zzi", "zzm"});
        }
        if (i11 == 3) {
            return new zzrr();
        }
        zzrq zzrqVar = null;
        if (i11 == 4) {
            return new zzrp(zzrqVar);
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
        synchronized (zzrr.class) {
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
