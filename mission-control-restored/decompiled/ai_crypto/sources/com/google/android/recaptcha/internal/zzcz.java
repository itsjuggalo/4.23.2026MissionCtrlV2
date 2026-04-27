package com.google.android.recaptcha.internal;

import E5.E;
import E5.p;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: loaded from: classes.dex */
final class zzcz extends l implements o {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    final /* synthetic */ String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(zzdc zzdcVar, long j7, RecaptchaAction recaptchaAction, String str, d dVar) {
        super(2, dVar);
        this.zzb = zzdcVar;
        this.zzc = j7;
        this.zzd = recaptchaAction;
        this.zze = str;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzcz(this.zzb, this.zzc, this.zzd, this.zze, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcz) create((zzek) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = I5.c.e();
        int i7 = this.zza;
        q.b(obj);
        if (i7 == 0) {
            zzdc.zze(this.zzb, this.zzc, this.zzd);
            zzdc zzdcVar = this.zzb;
            String str = this.zze;
            RecaptchaAction recaptchaAction = this.zzd;
            long j7 = this.zzc;
            zzcn zzcnVar = zzdcVar.zzb;
            this.zza = 1;
            obj = zzcnVar.zza(str, recaptchaAction, j7, this);
            if (obj == objE) {
                return objE;
            }
        }
        return p.a(p.b((String) obj));
    }
}
