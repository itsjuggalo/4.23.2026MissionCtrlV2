package com.google.android.recaptcha.internal;

import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzdw extends d {
    long zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzec zzc;
    int zzd;
    zzec zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdw(zzec zzecVar, H5.d dVar) {
        super(dVar);
        this.zzc = zzecVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzm(0L, this);
    }
}
