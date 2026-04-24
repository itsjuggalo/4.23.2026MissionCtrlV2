package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzpl {
    private static volatile int zza = 100;

    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i7, int i8);

    public abstract void zze(Object obj, int i7, long j7);

    public abstract void zzf(Object obj, int i7, Object obj2);

    public abstract void zzg(Object obj, int i7, zzle zzleVar);

    public abstract void zzh(Object obj, int i7, long j7);

    public abstract void zzi(Object obj);

    public abstract void zzj(Object obj, Object obj2);

    public final boolean zzk(Object obj, zzov zzovVar, int i7) throws zznn {
        int iZzd = zzovVar.zzd();
        int i8 = iZzd >>> 3;
        int i9 = iZzd & 7;
        if (i9 == 0) {
            zzh(obj, i8, zzovVar.zzl());
            return true;
        }
        if (i9 == 1) {
            zze(obj, i8, zzovVar.zzk());
            return true;
        }
        if (i9 == 2) {
            zzg(obj, i8, zzovVar.zzp());
            return true;
        }
        if (i9 != 3) {
            if (i9 == 4) {
                return false;
            }
            if (i9 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i8, zzovVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i10 = i8 << 3;
        int i11 = i7 + 1;
        if (i11 >= zza) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzovVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzovVar, i11)) {
        }
        if ((i10 | 4) != zzovVar.zzd()) {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i8, zzc(objZzb));
        return true;
    }
}
