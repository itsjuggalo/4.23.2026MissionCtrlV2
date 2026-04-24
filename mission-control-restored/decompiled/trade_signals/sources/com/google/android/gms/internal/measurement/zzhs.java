package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhs extends zzmf implements zznn {
    private static final zzhs zzj;
    private int zzb;
    private zzmo zzd = zzmf.zzcv();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        zzhs zzhsVar = new zzhs();
        zzj = zzhsVar;
        zzmf.zzcp(zzhs.class, zzhsVar);
    }

    private zzhs() {
    }

    public static zzhr zzk() {
        return (zzhr) zzj.zzck();
    }

    private final void zzw() {
        zzmo zzmoVar = this.zzd;
        if (zzmoVar.zza()) {
            return;
        }
        this.zzd = zzmf.zzcw(zzmoVar);
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int i8) {
        return (zzhw) this.zzd.get(i8);
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

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final Object zzl(int i8, Object obj, Object obj2) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return zzmf.zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i9 == 3) {
            return new zzhs();
        }
        byte[] bArr = null;
        if (i9 == 4) {
            return new zzhr(bArr);
        }
        if (i9 == 5) {
            return zzj;
        }
        throw null;
    }

    public final /* synthetic */ void zzm(int i8, zzhw zzhwVar) {
        zzhwVar.getClass();
        zzw();
        this.zzd.set(i8, zzhwVar);
    }

    public final /* synthetic */ void zzn(zzhw zzhwVar) {
        zzhwVar.getClass();
        zzw();
        this.zzd.add(zzhwVar);
    }

    public final /* synthetic */ void zzo(Iterable iterable) {
        zzw();
        zzks.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzp() {
        this.zzd = zzmf.zzcv();
    }

    public final /* synthetic */ void zzq(int i8) {
        zzw();
        this.zzd.remove(i8);
    }

    public final /* synthetic */ void zzr(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzs(long j8) {
        this.zzb |= 2;
        this.zzf = j8;
    }

    public final /* synthetic */ void zzt(long j8) {
        this.zzb |= 4;
        this.zzg = j8;
    }

    public final /* synthetic */ void zzu(long j8) {
        this.zzb |= 16;
        this.zzi = j8;
    }
}
