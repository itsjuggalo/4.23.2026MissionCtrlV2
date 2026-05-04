package com.google.android.recaptcha.internal;

import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import java.util.List;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzr extends m implements o {
    int zza;
    final /* synthetic */ zzy zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ List zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(zzy zzyVar, String str, List list, e eVar) {
        super(2, eVar);
        this.zzb = zzyVar;
        this.zzc = str;
        this.zzd = list;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzr(this.zzb, this.zzc, this.zzd, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzr) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            zzy zzyVar = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            obj = zzyVar.zzc(str, this);
            if (obj == objF) {
                return objF;
            }
        }
        this.zzd.add((zzaa) obj);
        return h0.f3852a;
    }
}
