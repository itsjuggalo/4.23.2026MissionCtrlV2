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
import ng.u0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzk extends m implements o {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ zzek zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzsc zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzk(zzl zzlVar, zzek zzekVar, long j10, zzsc zzscVar, e eVar) {
        super(2, eVar);
        this.zzb = zzlVar;
        this.zzc = zzekVar;
        this.zzd = j10;
        this.zze = zzscVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        zzk zzkVar = new zzk(this.zzb, this.zzc, this.zzd, this.zze, eVar);
        zzkVar.zzf = obj;
        return zzkVar;
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzk) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        zzen zzenVar;
        Object objB;
        Object objF = c.f();
        if (this.zza != 0) {
            zzenVar = (zzen) this.zzf;
            s.b(obj);
            objA = obj;
        } else {
            s.b(obj);
            n0 n0Var = (n0) this.zzf;
            this.zzb.zzb = this.zzc;
            zzek zzekVar = this.zzc;
            zzekVar.zzc(zzekVar.zzd());
            zzen zzenVarZzf = zzekVar.zzf(30);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzb.zzd().iterator();
            while (it.hasNext()) {
                arrayList.add(k.b(n0Var, null, null, new zzj((zze) it.next(), this.zzd, this.zze, null), 3, null));
            }
            u0[] u0VarArr = (u0[]) arrayList.toArray(new u0[0]);
            u0[] u0VarArr2 = (u0[]) Arrays.copyOf(u0VarArr, u0VarArr.length);
            this.zzf = zzenVarZzf;
            this.zza = 1;
            objA = f.a(u0VarArr2, this);
            if (objA == objF) {
                return objF;
            }
            zzenVar = zzenVarZzf;
        }
        List list = (List) objA;
        if (list == null || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (!r.g(((r) it2.next()).j())) {
                    zzenVar.zza();
                    objB = r.b(h0.f3852a);
                    break;
                }
            }
            zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar);
            r.a aVar = r.f3870b;
            objB = r.b(s.a(zzbdVar));
        } else {
            zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zzY, null);
            zzenVar.zzb(zzbdVar2);
            r.a aVar2 = r.f3870b;
            objB = r.b(s.a(zzbdVar2));
        }
        return r.a(objB);
    }
}
