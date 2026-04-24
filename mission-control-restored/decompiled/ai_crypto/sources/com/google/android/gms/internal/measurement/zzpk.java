package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzpk implements r {
    private static final zzpk zza = new zzpk();
    private final r zzb = s.b(new zzpm());

    public static boolean zza() {
        zza.get().zza();
        return true;
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // H2.r
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpl get() {
        return (zzpl) this.zzb.get();
    }
}
