package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzanu<T, B> {
    private static volatile int zza = 100;

    public abstract int zza(T t6);

    public abstract B zza();

    public abstract T zza(T t6, T t7);

    public abstract void zza(B b3, int i, int i6);

    public abstract void zza(B b3, int i, long j4);

    public abstract void zza(B b3, int i, zzajv zzajvVar);

    public abstract void zza(B b3, int i, T t6);

    public abstract void zza(T t6, zzaol zzaolVar);

    public abstract boolean zza(zzanc zzancVar);

    public final boolean zza(B b3, zzanc zzancVar, int i) throws zzall {
        int iZzd = zzancVar.zzd();
        int i6 = iZzd >>> 3;
        int i7 = iZzd & 7;
        if (i7 == 0) {
            zzb(b3, i6, zzancVar.zzl());
            return true;
        }
        if (i7 == 1) {
            zza(b3, i6, zzancVar.zzk());
            return true;
        }
        if (i7 == 2) {
            zza((Object) b3, i6, zzancVar.zzp());
            return true;
        }
        if (i7 != 3) {
            if (i7 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzall.zzb();
            }
            if (i7 != 5) {
                throw zzall.zza();
            }
            zza((Object) b3, i6, zzancVar.zzf());
            return true;
        }
        B bZza = zza();
        int i8 = 4 | (i6 << 3);
        int i9 = i + 1;
        if (i9 >= zza) {
            throw zzall.zzh();
        }
        while (zzancVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzancVar, i9)) {
        }
        if (i8 != zzancVar.zzd()) {
            throw zzall.zzb();
        }
        zza(b3, i6, zze(bZza));
        return true;
    }

    public abstract int zzb(T t6);

    public abstract void zzb(B b3, int i, long j4);

    public abstract void zzb(T t6, zzaol zzaolVar);

    public abstract void zzb(Object obj, B b3);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t6);

    public abstract T zzd(Object obj);

    public abstract T zze(B b3);

    public abstract void zzf(Object obj);
}
