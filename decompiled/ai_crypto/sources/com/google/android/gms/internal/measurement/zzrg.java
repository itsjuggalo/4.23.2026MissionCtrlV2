package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzrg implements r {
    private static final zzrg zza = new zzrg();
    private final r zzb = s.b(new zzri());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // H2.r
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzrh get() {
        return (zzrh) this.zzb.get();
    }
}
