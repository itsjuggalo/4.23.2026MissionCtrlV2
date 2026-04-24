package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import android.app.Application;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzcp extends l implements o {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcp(Application application, String str, e eVar) {
        super(2, eVar);
        this.zzb = application;
        this.zzc = str;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzcp(this.zzb, this.zzc, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcp) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 != 0) {
            return obj;
        }
        Application application = this.zzb;
        String str = this.zzc;
        this.zza = 1;
        Object objZzd = zzcq.zzd(application, str, this);
        return objZzd == objE ? objE : objZzd;
    }
}
