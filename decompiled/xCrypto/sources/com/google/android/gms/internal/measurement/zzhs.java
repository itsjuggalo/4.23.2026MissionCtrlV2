package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhs extends zzme implements zznm {
    private static final zzhs zzi;
    private int zzb;
    private zzmn zzd = zzme.zzcv();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    static {
        zzhs zzhsVar = new zzhs();
        zzi = zzhsVar;
        zzme.zzcp(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    public static zzhr zzk() {
        return (zzhr) zzi.zzck();
    }

    private final void zzv() {
        zzmn zzmnVar = this.zzd;
        if (zzmnVar.zza()) {
            return;
        }
        this.zzd = zzme.zzcw(zzmnVar);
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int i4) {
        return (zzhw) this.zzd.get(i4);
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 2) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 4) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 8) != 0;
    }

    public final int zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 == 0) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return zzme.zzcq(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh"});
        }
        if (i5 == 3) {
            return new zzhs();
        }
        byte[] bArr = null;
        if (i5 == 4) {
            return new zzhr(bArr);
        }
        if (i5 == 5) {
            return zzi;
        }
        throw null;
    }

    public final /* synthetic */ void zzm(int i4, zzhw zzhwVar) {
        zzhwVar.getClass();
        zzv();
        this.zzd.set(i4, zzhwVar);
    }

    public final /* synthetic */ void zzn(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzv();
        this.zzd.add(zzhwVar);
    }

    public final /* synthetic */ void zzo(Iterable iterable) {
        zzv();
        zzkr.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzp() {
        this.zzd = zzme.zzcv();
    }

    public final /* synthetic */ void zzq(int i4) {
        zzv();
        this.zzd.remove(i4);
    }

    public final /* synthetic */ void zzr(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzs(long j4) {
        this.zzb |= 2;
        this.zzf = j4;
    }

    public final /* synthetic */ void zzt(long j4) {
        this.zzb |= 4;
        this.zzg = j4;
    }
}
