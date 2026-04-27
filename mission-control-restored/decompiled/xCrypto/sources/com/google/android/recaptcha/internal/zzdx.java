package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.InterfaceC1847x;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzdx extends l implements o {
    int zza;
    final /* synthetic */ zzec zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdx(zzec zzecVar, e eVar) {
        super(2, eVar);
        this.zzb = zzecVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzdx(this.zzb, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdx) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            InterfaceC1847x interfaceC1847x = this.zzb.zzc;
            this.zza = 1;
            if (interfaceC1847x.await(this) == objE) {
                return objE;
            }
        }
        return E.f5463a;
    }
}
