package com.google.android.recaptcha.internal;

import J5.d;

/* JADX INFO: loaded from: classes.dex */
final class zzbz extends d {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzcb zzc;
    int zzd;
    zzcb zze;
    zzje[] zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbz(zzcb zzcbVar, H5.d dVar) {
        super(dVar);
        this.zzc = zzcbVar;
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzb(null, this);
    }
}
