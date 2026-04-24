package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import android.app.Application;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzcp extends l implements o {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcp(Application application, String str, d dVar) {
        super(2, dVar);
        this.zzb = application;
        this.zzc = str;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzcp(this.zzb, this.zzc, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcp) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 == 0) {
            Application application = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            obj = zzcq.zzd(application, str, this);
            if (obj == objE) {
                return objE;
            }
        }
        return obj;
    }
}
