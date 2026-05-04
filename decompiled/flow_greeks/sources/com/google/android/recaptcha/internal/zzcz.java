package com.google.android.recaptcha.internal;

import cd.h0;
import cd.r;
import cd.s;
import com.google.android.recaptcha.RecaptchaAction;
import gd.e;
import hd.c;
import id.m;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzcz extends m implements o {
    int zza;
    final /* synthetic */ zzdc zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    final /* synthetic */ String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(zzdc zzdcVar, long j10, RecaptchaAction recaptchaAction, String str, e eVar) {
        super(2, eVar);
        this.zzb = zzdcVar;
        this.zzc = j10;
        this.zzd = recaptchaAction;
        this.zze = str;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzcz(this.zzb, this.zzc, this.zzd, this.zze, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzcz) create((zzek) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            zzdc.zze(this.zzb, this.zzc, this.zzd);
            zzdc zzdcVar = this.zzb;
            String str = this.zze;
            RecaptchaAction recaptchaAction = this.zzd;
            long j10 = this.zzc;
            zzcn zzcnVar = zzdcVar.zzb;
            this.zza = 1;
            obj = zzcnVar.zza(str, recaptchaAction, j10, this);
            if (obj == objF) {
                return objF;
            }
        }
        return r.a(r.b((String) obj));
    }
}
