package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzano<T, B> {
    private static volatile int zza = 100;

    public abstract int zza(T t7);

    public abstract B zza();

    public abstract T zza(T t7, T t8);

    public abstract void zza(B b7, int i7, int i8);

    public abstract void zza(B b7, int i7, long j7);

    public abstract void zza(B b7, int i7, zzajp zzajpVar);

    public abstract void zza(B b7, int i7, T t7);

    public abstract void zza(T t7, zzaof zzaofVar);

    public abstract boolean zza(zzams zzamsVar);

    public final boolean zza(B b7, zzams zzamsVar, int i7) throws zzalf {
        int iZzd = zzamsVar.zzd();
        int i8 = iZzd >>> 3;
        int i9 = iZzd & 7;
        if (i9 == 0) {
            zzb(b7, i8, zzamsVar.zzl());
            return true;
        }
        if (i9 == 1) {
            zza(b7, i8, zzamsVar.zzk());
            return true;
        }
        if (i9 == 2) {
            zza((Object) b7, i8, zzamsVar.zzp());
            return true;
        }
        if (i9 != 3) {
            if (i9 == 4) {
                if (i7 != 0) {
                    return false;
                }
                throw zzalf.zzb();
            }
            if (i9 != 5) {
                throw zzalf.zza();
            }
            zza((Object) b7, i8, zzamsVar.zzf());
            return true;
        }
        B bZza = zza();
        int i10 = 4 | (i8 << 3);
        int i11 = i7 + 1;
        if (i11 >= zza) {
            throw zzalf.zzh();
        }
        while (zzamsVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzamsVar, i11)) {
        }
        if (i10 != zzamsVar.zzd()) {
            throw zzalf.zzb();
        }
        zza(b7, i8, zze(bZza));
        return true;
    }

    public abstract int zzb(T t7);

    public abstract void zzb(B b7, int i7, long j7);

    public abstract void zzb(T t7, zzaof zzaofVar);

    public abstract void zzb(Object obj, B b7);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t7);

    public abstract T zzd(Object obj);

    public abstract T zze(B b7);

    public abstract void zzf(Object obj);
}
