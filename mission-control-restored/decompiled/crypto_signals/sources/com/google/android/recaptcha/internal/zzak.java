package com.google.android.recaptcha.internal;

import I4.d;
import K4.c;

/* JADX INFO: loaded from: classes.dex */
final class zzak extends c {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzan zzc;
    int zzd;
    zzan zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzak(zzan zzanVar, d dVar) {
        super(dVar);
        this.zzc = zzanVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zze(this);
    }
}
