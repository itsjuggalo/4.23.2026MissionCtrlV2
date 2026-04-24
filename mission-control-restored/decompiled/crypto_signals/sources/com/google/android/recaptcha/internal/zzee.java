package com.google.android.recaptcha.internal;

import I4.d;
import K4.c;

/* JADX INFO: loaded from: classes.dex */
final class zzee extends c {
    double zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzef zzc;
    int zzd;
    zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzee(zzef zzefVar, d dVar) {
        super(dVar);
        this.zzc = zzefVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzb(0L, this);
    }
}
