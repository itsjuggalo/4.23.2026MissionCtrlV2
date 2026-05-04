package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzth extends zznd implements zzoj {
    private static final zzth zzb;
    private static volatile zzoq zzd;
    private int zze = 0;
    private Object zzf;

    static {
        zzth zzthVar = new zzth();
        zzb = zzthVar;
        zznd.zzI(zzth.class, zzthVar);
    }

    private zzth() {
    }

    public static /* synthetic */ void zzM(zzth zzthVar, float f10) {
        zzthVar.zze = 9;
        zzthVar.zzf = Float.valueOf(f10);
    }

    public static /* synthetic */ void zzN(zzth zzthVar, int i10) {
        zzthVar.zze = 4;
        zzthVar.zzf = Integer.valueOf(i10);
    }

    public static /* synthetic */ void zzO(zzth zzthVar, int i10) {
        zzthVar.zze = 5;
        zzthVar.zzf = Integer.valueOf(i10);
    }

    public static /* synthetic */ void zzP(zzth zzthVar, long j10) {
        zzthVar.zze = 7;
        zzthVar.zzf = Long.valueOf(j10);
    }

    public static /* synthetic */ void zzQ(zzth zzthVar, String str) {
        str.getClass();
        zzthVar.zze = 11;
        zzthVar.zzf = str;
    }

    public static zztg zzf() {
        return (zztg) zzb.zzq();
    }

    public static /* synthetic */ void zzi(zzth zzthVar, boolean z10) {
        zzthVar.zze = 1;
        zzthVar.zzf = Boolean.valueOf(z10);
    }

    public static /* synthetic */ void zzj(zzth zzthVar, zzle zzleVar) {
        zzthVar.zze = 2;
        zzthVar.zzf = zzleVar;
    }

    public static /* synthetic */ void zzk(zzth zzthVar, String str) {
        str.getClass();
        zzthVar.zze = 3;
        zzthVar.zzf = str;
    }

    public static /* synthetic */ void zzl(zzth zzthVar, double d10) {
        zzthVar.zze = 10;
        zzthVar.zzf = Double.valueOf(d10);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    public final Object zzh(int i10, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zznd.zzF(zzb, "\u0000\u000b\u0001\u0000\u0001\u000b\u000b\u0000\u0000\u0000\u0001:\u0000\u0002=\u0000\u0003Ȼ\u0000\u0004B\u0000\u0005B\u0000\u0006>\u0000\u0007C\u0000\b6\u0000\t4\u0000\n3\u0000\u000bȻ\u0000", new Object[]{"zzf", "zze"});
        }
        if (i11 == 3) {
            return new zzth();
        }
        zztj zztjVar = null;
        if (i11 == 4) {
            return new zztg(zztjVar);
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
        synchronized (zzth.class) {
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
