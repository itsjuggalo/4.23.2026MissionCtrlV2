package com.google.android.recaptcha.internal;

import cd.h0;
import cd.r;
import cd.s;
import com.google.android.recaptcha.RecaptchaAction;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzda extends m implements o {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzda(zzdc zzdcVar, RecaptchaAction recaptchaAction, long j10, e eVar) {
        super(2, eVar);
        this.zzb = zzdcVar;
        this.zzc = recaptchaAction;
        this.zzd = j10;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzda(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzda) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzf;
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 != 0) {
            objZzf = ((r) obj).j();
        } else {
            zzdc zzdcVar = this.zzb;
            RecaptchaAction recaptchaAction = this.zzc;
            long j10 = this.zzd;
            this.zza = 1;
            objZzf = zzdcVar.zzf(recaptchaAction, j10, this);
            if (objZzf == objF) {
                return objF;
            }
        }
        s.b(objZzf);
        return objZzf;
    }
}
