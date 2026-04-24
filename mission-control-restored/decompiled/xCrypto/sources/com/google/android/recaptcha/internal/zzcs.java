package com.google.android.recaptcha.internal;

import Z2.e;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zzcs extends AbstractC0866d {
    Object zza;
    Object zzb;
    Object zzc;
    long zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzcv zzf;
    int zzg;
    String zzh;
    zzch zzi;
    zzbi zzj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzcv zzcvVar, e eVar) {
        super(eVar);
        this.zzf = zzcvVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zzg(null, 0L, null, null, null, this);
    }
}
