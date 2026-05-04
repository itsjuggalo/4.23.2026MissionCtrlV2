package com.google.android.recaptcha.internal;

import cd.h0;
import cd.r;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import ng.f;
import ng.k;
import ng.n0;
import ng.y1;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzs extends m implements o {
    int zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ String zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzv zzvVar, String str, e eVar) {
        super(2, eVar);
        this.zzb = zzvVar;
        this.zzc = str;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        zzs zzsVar = new zzs(this.zzb, this.zzc, eVar);
        zzsVar.zzd = obj;
        return zzsVar;
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            n0 n0Var = (n0) this.zzd;
            ArrayList arrayList = new ArrayList();
            zzv zzvVar = this.zzb;
            zzvVar.zzo().put(this.zzc, arrayList);
            ArrayList arrayList2 = new ArrayList();
            List list = this.zzb.zzb;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                if (((zzy) obj2).zzf()) {
                    arrayList3.add(obj2);
                }
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList2.add(k.d(n0Var, null, null, new zzr((zzy) it.next(), this.zzc, arrayList, null), 3, null));
            }
            y1[] y1VarArr = (y1[]) arrayList2.toArray(new y1[0]);
            y1[] y1VarArr2 = (y1[]) Arrays.copyOf(y1VarArr, y1VarArr.length);
            this.zza = 1;
            if (f.c(y1VarArr2, this) == objF) {
                return objF;
            }
        }
        r.a aVar = r.f3870b;
        return r.a(r.b(this.zzb.zzq(this.zzc)));
    }
}
