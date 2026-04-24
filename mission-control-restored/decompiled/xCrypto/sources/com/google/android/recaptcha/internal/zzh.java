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
import t3.L;
import t3.T;

/* JADX INFO: loaded from: classes.dex */
final class zzh extends l implements o {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzl zzlVar, String str, long j4, e eVar) {
        super(2, eVar);
        this.zzb = zzlVar;
        this.zzc = str;
        this.zzd = j4;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        zzh zzhVar = new zzh(this.zzb, this.zzc, this.zzd, eVar);
        zzhVar.zze = obj;
        return zzhVar;
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzh) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVarZzf;
        Object objA;
        zzen zzenVar;
        Object objE = AbstractC0787c.e();
        if (this.zza != 0) {
            zzenVar = (zzen) this.zze;
            q.b(obj);
            objA = obj;
        } else {
            q.b(obj);
            L l4 = (L) this.zze;
            zzek zzekVar = this.zzb.zzb;
            if (zzekVar != null) {
                zzekVar.zzc(this.zzc);
                zzenVarZzf = zzekVar.zzf(31);
            } else {
                zzenVarZzf = null;
            }
            ArrayList arrayList = new ArrayList();
            for (zze zzeVar : this.zzb.zzd()) {
                if (zzeVar.zzl()) {
                    arrayList.add(AbstractC1822k.b(l4, null, null, new zzg(zzeVar, this.zzc, this.zzd, null), 3, null));
                }
            }
            T[] tArr = (T[]) arrayList.toArray(new T[0]);
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
            this.zze = zzenVarZzf;
            this.zza = 1;
            objA = AbstractC1812f.a(tArr2, this);
            if (objA == objE) {
                return objE;
            }
            zzenVar = zzenVarZzf;
        }
        String str = this.zzc;
        zzsh zzshVarZzf = zzsi.zzf();
        zzshVarZzf.zze(str);
        Iterator it = ((List) objA).iterator();
        while (it.hasNext()) {
            Object objJ = ((p) it.next()).j();
            if (p.h(objJ)) {
                zzshVarZzf.zzh((zzsi) objJ);
            }
        }
        zzsi zzsiVar = (zzsi) zzshVarZzf.zzk();
        if (zzenVar != null) {
            zzenVar.zza();
        }
        return zzsiVar;
    }
}
