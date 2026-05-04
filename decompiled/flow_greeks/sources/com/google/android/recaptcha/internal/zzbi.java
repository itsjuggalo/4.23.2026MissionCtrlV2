package com.google.android.recaptcha.internal;

import java.util.concurrent.Executors;
import ng.c1;
import ng.k;
import ng.n0;
import ng.o0;
import ng.r1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbi {
    private final n0 zza = o0.b();
    private final n0 zzb;
    private final n0 zzc;
    private final n0 zzd;

    public zzbi() {
        n0 n0VarA = o0.a(r1.c(Executors.newSingleThreadExecutor()));
        k.d(n0VarA, null, null, new zzbh(null), 3, null);
        this.zzb = n0VarA;
        this.zzc = o0.a(c1.b());
        n0 n0VarA2 = o0.a(r1.c(Executors.newSingleThreadExecutor()));
        k.d(n0VarA2, null, null, new zzbg(null), 3, null);
        this.zzd = n0VarA2;
    }

    public final n0 zza() {
        return this.zzc;
    }

    public final n0 zzb() {
        return this.zza;
    }

    public final n0 zzc() {
        return this.zzd;
    }

    public final n0 zzd() {
        return this.zzb;
    }
}
