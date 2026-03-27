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
final class zzk extends l implements o {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ zzek zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzsc zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzk(zzl zzlVar, zzek zzekVar, long j4, zzsc zzscVar, e eVar) {
        super(2, eVar);
        this.zzb = zzlVar;
        this.zzc = zzekVar;
        this.zzd = j4;
        this.zze = zzscVar;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        zzk zzkVar = new zzk(this.zzb, this.zzc, this.zzd, this.zze, eVar);
        zzkVar.zzf = obj;
        return zzkVar;
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzk) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        zzen zzenVar;
        Object objB;
        Object objE = AbstractC0787c.e();
        if (this.zza != 0) {
            zzenVar = (zzen) this.zzf;
            q.b(obj);
            objA = obj;
        } else {
            q.b(obj);
            L l4 = (L) this.zzf;
            this.zzb.zzb = this.zzc;
            zzek zzekVar = this.zzc;
            zzekVar.zzc(zzekVar.zzd());
            zzen zzenVarZzf = zzekVar.zzf(30);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzb.zzd().iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC1822k.b(l4, null, null, new zzj((zze) it.next(), this.zzd, this.zze, null), 3, null));
            }
            T[] tArr = (T[]) arrayList.toArray(new T[0]);
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
            this.zzf = zzenVarZzf;
            this.zza = 1;
            objA = AbstractC1812f.a(tArr2, this);
            if (objA == objE) {
                return objE;
            }
            zzenVar = zzenVarZzf;
        }
        List list = (List) objA;
        if (list == null || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (!p.g(((p) it2.next()).j())) {
                    zzenVar.zza();
                    objB = p.b(E.f5463a);
                    break;
                }
            }
            zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar);
            p.a aVar = p.f5487b;
            objB = p.b(q.a(zzbdVar));
        } else {
            zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar2);
            p.a aVar2 = p.f5487b;
            objB = p.b(q.a(zzbdVar2));
        }
        return p.a(objB);
    }
}
