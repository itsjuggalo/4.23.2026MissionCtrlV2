package com.google.android.recaptcha.internal;

import Z2.e;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzaf extends AbstractC0866d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzan zzb;
    int zzc;
    zzan zzd;
    String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaf(zzan zzanVar, e eVar) {
        super(eVar);
        this.zzb = zzanVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzc(null, this);
    }
}
