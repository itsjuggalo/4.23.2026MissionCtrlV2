package com.google.android.recaptcha.internal;

import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzdv extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzec zzb;
    int zzc;
    zzbn zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdv(zzec zzecVar, H5.d dVar) {
        super(dVar);
        this.zzb = zzecVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzl(null, this);
    }
}
