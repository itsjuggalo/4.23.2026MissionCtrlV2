package com.google.android.recaptcha.internal;

import W2.p;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
final class zza extends AbstractC0866d {
    Object zza;
    long zzb;
    /* synthetic */ Object zzc;
    final /* synthetic */ zze zzd;
    int zze;
    String zzf;
    zzen zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zza(zze zzeVar, e eVar) {
        super(eVar);
        this.zzd = zzeVar;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.zzc = obj;
        this.zze |= Integer.MIN_VALUE;
        Object objZzc = this.zzd.zzc(null, 0L, this);
        return objZzc == AbstractC0787c.e() ? objZzc : p.a(objZzc);
    }
}
