package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class zzkl extends zzhk implements zzin {
    private static final zzkl zzb;

    static {
        zzkl zzklVar = new zzkl();
        zzb = zzklVar;
        zzhk.zzx(zzkl.class, zzklVar);
    }

    private zzkl() {
    }

    public static zzkl zzB() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhk
    public final Object zzd(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        zzkk zzkkVar = null;
        if (i5 == 2) {
            return zzhk.zzu(zzb, "\u0004\u0000", null);
        }
        if (i5 == 3) {
            return new zzkl();
        }
        if (i5 == 4) {
            return new zzkj(zzkkVar);
        }
        if (i5 != 5) {
            return null;
        }
        return zzb;
    }
}
