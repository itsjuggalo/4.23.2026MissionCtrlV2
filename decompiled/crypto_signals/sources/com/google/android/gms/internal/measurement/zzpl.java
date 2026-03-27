package com.google.android.gms.internal.measurement;

import U1.l;
import U1.o;

/* JADX INFO: loaded from: classes.dex */
public final class zzpl implements l {
    private static final zzpl zza = new zzpl();
    private final l zzb = new o(new zzpn());

    public static boolean zza() {
        return zza.get().zza();
    }

    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // U1.l
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpm get() {
        return (zzpm) this.zzb.get();
    }
}
