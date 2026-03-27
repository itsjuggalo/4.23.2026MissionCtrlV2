package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzano<T, B> {
    private static volatile int zza = 100;

    public abstract int zza(T t4);

    public abstract B zza();

    public abstract T zza(T t4, T t5);

    public abstract void zza(B b4, int i4, int i5);

    public abstract void zza(B b4, int i4, long j4);

    public abstract void zza(B b4, int i4, zzajp zzajpVar);

    public abstract void zza(B b4, int i4, T t4);

    public abstract void zza(T t4, zzaof zzaofVar);

    public abstract boolean zza(zzams zzamsVar);

    public final boolean zza(B b4, zzams zzamsVar, int i4) throws zzalf {
        int iZzd = zzamsVar.zzd();
        int i5 = iZzd >>> 3;
        int i6 = iZzd & 7;
        if (i6 == 0) {
            zzb(b4, i5, zzamsVar.zzl());
            return true;
        }
        if (i6 == 1) {
            zza(b4, i5, zzamsVar.zzk());
            return true;
        }
        if (i6 == 2) {
            zza((Object) b4, i5, zzamsVar.zzp());
            return true;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                if (i4 != 0) {
                    return false;
                }
                throw zzalf.zzb();
            }
            if (i6 != 5) {
                throw zzalf.zza();
            }
            zza((Object) b4, i5, zzamsVar.zzf());
            return true;
        }
        B bZza = zza();
        int i7 = 4 | (i5 << 3);
        int i8 = i4 + 1;
        if (i8 >= zza) {
            throw zzalf.zzh();
        }
        while (zzamsVar.zzc() != Integer.MAX_VALUE && zza(bZza, zzamsVar, i8)) {
        }
        if (i7 != zzamsVar.zzd()) {
            throw zzalf.zzb();
        }
        zza(b4, i5, zze(bZza));
        return true;
    }

    public abstract int zzb(T t4);

    public abstract void zzb(B b4, int i4, long j4);

    public abstract void zzb(T t4, zzaof zzaofVar);

    public abstract void zzb(Object obj, B b4);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t4);

    public abstract T zzd(Object obj);

    public abstract T zze(B b4);

    public abstract void zzf(Object obj);
}
