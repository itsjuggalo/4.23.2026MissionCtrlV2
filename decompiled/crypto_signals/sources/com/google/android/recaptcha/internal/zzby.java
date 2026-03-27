package com.google.android.recaptcha.internal;

import I4.d;
import K4.c;

/* JADX INFO: loaded from: classes.dex */
final class zzby extends c {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzcb zzc;
    int zzd;
    zzcb zze;
    zzje zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzby(zzcb zzcbVar, d dVar) {
        super(dVar);
        this.zzc = zzcbVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zza(null, this);
    }
}
