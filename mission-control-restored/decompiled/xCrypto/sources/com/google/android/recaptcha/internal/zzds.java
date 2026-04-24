package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.AbstractC1818i;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzds extends l implements o {
    int zza;
    final /* synthetic */ zzdt zzb;
    final /* synthetic */ zzen zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzds(zzdt zzdtVar, zzen zzenVar, e eVar) {
        super(2, eVar);
        this.zzb = zzdtVar;
        this.zzc = zzenVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzds(this.zzb, this.zzc, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzds) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            zzdt zzdtVar = this.zzb;
            this.zza = 1;
            obj = AbstractC1818i.g(zzdtVar.zzi.zza().l(), new zzdh(zzdtVar, null), this);
            if (obj == objE) {
                return objE;
            }
        }
        zzsc zzscVar = (zzsc) obj;
        this.zzc.zza();
        return zzscVar;
    }
}
