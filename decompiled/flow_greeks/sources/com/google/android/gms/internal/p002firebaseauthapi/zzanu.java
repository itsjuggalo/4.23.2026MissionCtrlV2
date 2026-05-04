package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
abstract class zzanu<T, B> {
    private static volatile int zza = 100;

    public abstract int zza(T t10);

    public abstract B zza();

    public abstract T zza(T t10, T t11);

    public abstract void zza(B b10, int i10, int i11);

    public abstract void zza(B b10, int i10, long j10);

    public abstract void zza(B b10, int i10, zzajv zzajvVar);

    public abstract void zza(B b10, int i10, T t10);

    public abstract void zza(T t10, zzaol zzaolVar);

    public abstract boolean zza(zzanc zzancVar);

    public final boolean zza(B b10, zzanc zzancVar, int i10) throws zzall {
        int iZzd = zzancVar.zzd();
        int i11 = iZzd >>> 3;
        int i12 = iZzd & 7;
        if (i12 == 0) {
            zzb(b10, i11, zzancVar.zzl());
            return true;
        }
        if (i12 == 1) {
            zza(b10, i11, zzancVar.zzk());
            return true;
        }
        if (i12 == 2) {
            zza((Object) b10, i11, zzancVar.zzp());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                if (i10 != 0) {
                    return false;
                }
                throw zzall.zzb();
            }
            if (i12 != 5) {
                throw zzall.zza();
            }
            zza((Object) b10, i11, zzancVar.zzf());
            return true;
        }
        B bZza = zza();
        int i13 = 4 | (i11 << 3);
        int i14 = i10 + 1;
        if (i14 >= zza) {
            throw zzall.zzh();
        }
        while (zzancVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzancVar, i14)) {
        }
        if (i13 != zzancVar.zzd()) {
            throw zzall.zzb();
        }
        zza(b10, i11, zze(bZza));
        return true;
    }

    public abstract int zzb(T t10);

    public abstract void zzb(B b10, int i10, long j10);

    public abstract void zzb(T t10, zzaol zzaolVar);

    public abstract void zzb(Object obj, B b10);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t10);

    public abstract T zzd(Object obj);

    public abstract T zze(B b10);

    public abstract void zzf(Object obj);
}
