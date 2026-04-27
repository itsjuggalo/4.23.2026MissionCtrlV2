package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public final class zzhg extends zzme implements zznm {
    private static final zzhg zzh;
    private int zzb;
    private int zzd;
    private zzii zze;
    private zzii zzf;
    private boolean zzg;

    static {
        zzhg zzhgVar = new zzhg();
        zzh = zzhgVar;
        zzme.zzcp(zzhg.class, zzhgVar);
    }

    private zzhg() {
    }

    public static zzhf zzh() {
        return (zzhf) zzh.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzii zzc() {
        zzii zziiVar = this.zze;
        return zziiVar == null ? zzii.zzj() : zziiVar;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final zzii zze() {
        zzii zziiVar = this.zzf;
        return zziiVar == null ? zzii.zzj() : zziiVar;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final /* synthetic */ void zzi(int i4) {
        this.zzb |= 1;
        this.zzd = i4;
    }

    public final /* synthetic */ void zzj(zzii zziiVar) {
        zziiVar.getClass();
        this.zze = zziiVar;
        this.zzb |= 2;
    }

    public final /* synthetic */ void zzk(zzii zziiVar) {
        this.zzf = zziiVar;
        this.zzb |= 4;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i5 == 3) {
            return new zzhg();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzhf(bArr);
        }
        if (i5 == 5) {
            return zzh;
        }
        throw null;
    }

    public final /* synthetic */ void zzm(boolean z4) {
        this.zzb |= 8;
        this.zzg = z4;
    }
}
