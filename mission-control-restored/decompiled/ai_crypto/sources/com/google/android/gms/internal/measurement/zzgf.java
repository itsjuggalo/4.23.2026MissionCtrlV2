package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgf extends zzme implements zznm {
    private static final zzgf zzi;
    private int zzb;
    private boolean zzg;
    private zzmn zzd = zzme.zzcv();
    private zzmn zze = zzme.zzcv();
    private zzmn zzf = zzme.zzcv();
    private zzmn zzh = zzme.zzcv();

    static {
        zzgf zzgfVar = new zzgf();
        zzi = zzgfVar;
        zzme.zzcp(zzgf.class, zzgfVar);
    }

    private zzgf() {
    }

    public static zzgf zzg() {
        return zzi;
    }

    public final List zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", zzfu.class, "zze", zzfw.class, "zzf", zzgc.class, "zzg", "zzh", zzfu.class});
        }
        if (i8 == 3) {
            return new zzgf();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzfs(bArr);
        }
        if (i8 == 5) {
            return zzi;
        }
        throw null;
    }
}
