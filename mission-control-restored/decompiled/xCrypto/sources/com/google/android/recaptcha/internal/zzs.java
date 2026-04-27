package com.google.android.recaptcha.internal;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import t3.AbstractC1812f;
import t3.AbstractC1822k;
import t3.InterfaceC1846w0;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzs extends l implements o {
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

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        zzs zzsVar = new zzs(this.zzb, this.zzc, eVar);
        zzsVar.zzd = obj;
        return zzsVar;
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            L l4 = (L) this.zzd;
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
                arrayList2.add(AbstractC1822k.d(l4, null, null, new zzr((zzy) it.next(), this.zzc, arrayList, null), 3, null));
            }
            InterfaceC1846w0[] interfaceC1846w0Arr = (InterfaceC1846w0[]) arrayList2.toArray(new InterfaceC1846w0[0]);
            InterfaceC1846w0[] interfaceC1846w0Arr2 = (InterfaceC1846w0[]) Arrays.copyOf(interfaceC1846w0Arr, interfaceC1846w0Arr.length);
            this.zza = 1;
            if (AbstractC1812f.c(interfaceC1846w0Arr2, this) == objE) {
                return objE;
            }
        }
        p.a aVar = p.f5487b;
        return p.a(p.b(this.zzb.zzq(this.zzc)));
    }
}
