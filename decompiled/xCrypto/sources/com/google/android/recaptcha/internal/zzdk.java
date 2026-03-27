package com.google.android.recaptcha.internal;

import Z2.e;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzdk extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdt zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdk(zzdt zzdtVar, e eVar) {
        super(eVar);
        this.zzb = zzdtVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzn(null, 0L, this);
    }
}
