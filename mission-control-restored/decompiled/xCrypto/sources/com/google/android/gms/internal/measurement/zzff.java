package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzff extends zzme implements zznm {
    private static final zzff zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private zzmn zzf = zzme.zzcv();
    private boolean zzg;
    private zzfl zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzff zzffVar = new zzff();
        zzl = zzffVar;
        zzme.zzcp(zzff.class, zzffVar);
    }

    private zzff() {
    }

    public static zzfe zzn() {
        return (zzfe) zzl.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final List zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzf.size();
    }

    public final zzfh zzf(int i4) {
        return (zzfh) this.zzf.get(i4);
    }

    public final boolean zzg() {
        return (this.zzb & 8) != 0;
    }

    public final zzfl zzh() {
        zzfl zzflVar = this.zzh;
        return zzflVar == null ? zzfl.zzj() : zzflVar;
    }

    public final boolean zzi() {
        return this.zzi;
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zzb & 64) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", zzfh.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i5 == 3) {
            return new zzff();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzfe(bArr);
        }
        if (i5 == 5) {
            return zzl;
        }
        throw null;
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final /* synthetic */ void zzo(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void zzp(int i4, zzfh zzfhVar) {
        zzfhVar.getClass();
        zzmn zzmnVar = this.zzf;
        if (!zzmnVar.zza()) {
            this.zzf = zzme.zzcw(zzmnVar);
        }
        this.zzf.set(i4, zzfhVar);
    }
}
