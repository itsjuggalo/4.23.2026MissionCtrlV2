package com.google.android.gms.internal.measurement;

import H2.r;
import H2.s;

/* JADX INFO: loaded from: classes.dex */
public final class zzrd implements r {
    private static final zzrd zza = new zzrd();
    private final r zzb = s.b(new zzrf());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // H2.r
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzre get() {
        return (zzre) this.zzb.get();
    }
}
