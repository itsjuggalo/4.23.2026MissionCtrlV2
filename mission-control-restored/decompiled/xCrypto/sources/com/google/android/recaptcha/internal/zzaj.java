package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzaj extends l implements o {
    int zza;
    final /* synthetic */ zzan zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(zzan zzanVar, e eVar) {
        super(2, eVar);
        this.zzb = zzanVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzaj(this.zzb, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaj) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            this.zzb.zze = zzao.zza;
            zzan zzanVar = this.zzb;
            this.zza = 1;
            if (zzanVar.zze(this) == objE) {
                return objE;
            }
        }
        return E.f5463a;
    }
}
