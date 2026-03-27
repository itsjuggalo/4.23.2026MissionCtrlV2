package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzlu extends zzhk implements zzin {
    private static final zzlu zzb;
    private int zzd;
    private int zze;

    static {
        zzlu zzluVar = new zzlu();
        zzb = zzluVar;
        zzhk.zzx(zzlu.class, zzluVar);
    }

    private zzlu() {
    }

    public static zzlu zzB() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzls.zza});
        }
        if (i8 == 3) {
            return new zzlu();
        }
        zzlt zzltVar = null;
        if (i8 == 4) {
            return new zzlr(zzltVar);
        }
        if (i8 != 5) {
            return null;
        }
        return zzb;
    }
}
