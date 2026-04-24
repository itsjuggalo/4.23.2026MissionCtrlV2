package com.google.android.recaptcha.internal;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import com.google.android.recaptcha.RecaptchaAction;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzda extends l implements o {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzda(zzdc zzdcVar, RecaptchaAction recaptchaAction, long j4, e eVar) {
        super(2, eVar);
        this.zzb = zzdcVar;
        this.zzc = recaptchaAction;
        this.zzd = j4;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzda(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzda) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzf;
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 != 0) {
            objZzf = ((p) obj).j();
        } else {
            zzdc zzdcVar = this.zzb;
            RecaptchaAction recaptchaAction = this.zzc;
            long j4 = this.zzd;
            this.zza = 1;
            objZzf = zzdcVar.zzf(recaptchaAction, j4, this);
            if (objZzf == objE) {
                return objE;
            }
        }
        q.b(objZzf);
        return objZzf;
    }
}
