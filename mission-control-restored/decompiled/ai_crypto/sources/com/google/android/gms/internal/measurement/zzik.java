package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzik extends zzme implements zznm {
    private static final zzik zzf;
    private int zzb;
    private int zzd;
    private zzmm zze = zzme.zzct();

    static {
        zzik zzikVar = new zzik();
        zzf = zzikVar;
        zzme.zzcp(zzik.class, zzikVar);
    }

    private zzik() {
    }

    public static zzij zzf() {
        return (zzij) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final long zze(int i7) {
        return this.zze.zzc(i7);
    }

    public final /* synthetic */ void zzg(int i7) {
        this.zzb |= 1;
        this.zzd = i7;
    }

    public final /* synthetic */ void zzh(Iterable iterable) {
        zzmm zzmmVar = this.zze;
        if (!zzmmVar.zza()) {
            this.zze = zzme.zzcu(zzmmVar);
        }
        zzkr.zzce(iterable, this.zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i7, Object obj, Object obj2) {
        int i8 = i7 - 1;
        if (i8 == 0) {
            return (byte) 1;
        }
        if (i8 == 2) {
            return zzme.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i8 == 3) {
            return new zzik();
        }
        byte[] bArr = null;
        if (i8 == 4) {
            return new zzij(bArr);
        }
        if (i8 == 5) {
            return zzf;
        }
        throw null;
    }
}
