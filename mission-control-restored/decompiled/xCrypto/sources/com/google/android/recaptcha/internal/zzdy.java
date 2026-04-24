package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.k;
import t3.X0;

/* JADX INFO: loaded from: classes.dex */
final class zzdy extends l implements k {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzec zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(long j4, zzec zzecVar, e eVar) {
        super(1, eVar);
        this.zzb = j4;
        this.zzc = zzecVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(e eVar) {
        return new zzdy(this.zzb, this.zzc, eVar);
    }

    @Override // i3.k
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzdy) create((e) obj)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            long j4 = this.zzb;
            zzdx zzdxVar = new zzdx(this.zzc, null);
            this.zza = 1;
            if (X0.c(j4, zzdxVar, this) == objE) {
                return objE;
            }
        }
        return E.f5463a;
    }
}
