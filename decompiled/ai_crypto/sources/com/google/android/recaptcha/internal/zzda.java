package com.google.android.recaptcha.internal;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: loaded from: classes.dex */
final class zzda extends l implements o {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzda(zzdc zzdcVar, RecaptchaAction recaptchaAction, long j7, d dVar) {
        super(2, dVar);
        this.zzb = zzdcVar;
        this.zzc = recaptchaAction;
        this.zzd = j7;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzda(this.zzb, this.zzc, this.zzd, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzda) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzf;
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 != 0) {
            objZzf = ((p) obj).j();
        } else {
            zzdc zzdcVar = this.zzb;
            RecaptchaAction recaptchaAction = this.zzc;
            long j7 = this.zzd;
            this.zza = 1;
            objZzf = zzdcVar.zzf(recaptchaAction, j7, this);
            if (objZzf == objE) {
                return objE;
            }
        }
        q.b(objZzf);
        return objZzf;
    }
}
