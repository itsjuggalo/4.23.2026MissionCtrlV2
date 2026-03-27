package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
abstract class zzpl {
    private static volatile int zza = 100;

    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i, int i6);

    public abstract void zze(Object obj, int i, long j4);

    public abstract void zzf(Object obj, int i, Object obj2);

    public abstract void zzg(Object obj, int i, zzle zzleVar);

    public abstract void zzh(Object obj, int i, long j4);

    public abstract void zzi(Object obj);

    public abstract void zzj(Object obj, Object obj2);

    public final boolean zzk(Object obj, zzov zzovVar, int i) throws zznn {
        int iZzd = zzovVar.zzd();
        int i6 = iZzd >>> 3;
        int i7 = iZzd & 7;
        if (i7 == 0) {
            zzh(obj, i6, zzovVar.zzl());
            return true;
        }
        if (i7 == 1) {
            zze(obj, i6, zzovVar.zzk());
            return true;
        }
        if (i7 == 2) {
            zzg(obj, i6, zzovVar.zzp());
            return true;
        }
        if (i7 != 3) {
            if (i7 == 4) {
                return false;
            }
            if (i7 != 5) {
                throw new zznm("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i6, zzovVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i8 = i6 << 3;
        int i9 = i + 1;
        if (i9 >= zza) {
            throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzovVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzovVar, i9)) {
        }
        if ((i8 | 4) != zzovVar.zzd()) {
            throw new zznn("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i6, zzc(objZzb));
        return true;
    }
}
