package com.google.android.recaptcha.internal;

import I4.d;
import K4.c;

/* JADX INFO: loaded from: classes.dex */
final class zzah extends c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzan zzb;
    int zzc;
    String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzah(zzan zzanVar, d dVar) {
        super(dVar);
        this.zzb = zzanVar;
    }

    @Override // K4.a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzj(null, this);
    }
}
