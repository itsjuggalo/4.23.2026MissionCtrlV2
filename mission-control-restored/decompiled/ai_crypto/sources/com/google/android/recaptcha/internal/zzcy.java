package com.google.android.recaptcha.internal;

import E5.p;
import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzcy extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzdc zzdcVar, H5.d dVar) {
        super(dVar);
        this.zzb = zzdcVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzf = this.zzb.zzf(null, 0L, this);
        return objZzf == I5.c.e() ? objZzf : p.a(objZzf);
    }
}
