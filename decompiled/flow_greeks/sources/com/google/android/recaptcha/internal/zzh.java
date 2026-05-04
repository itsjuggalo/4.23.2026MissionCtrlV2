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
final class zzh extends m implements o {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzl zzlVar, String str, long j10, e eVar) {
        super(2, eVar);
        this.zzb = zzlVar;
        this.zzc = str;
        this.zzd = j10;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        zzh zzhVar = new zzh(this.zzb, this.zzc, this.zzd, eVar);
        zzhVar.zze = obj;
        return zzhVar;
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzh) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVarZzf;
        Object objA;
        zzen zzenVar;
        Object objF = c.f();
        if (this.zza != 0) {
            zzenVar = (zzen) this.zze;
            s.b(obj);
            objA = obj;
        } else {
            s.b(obj);
            n0 n0Var = (n0) this.zze;
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
                    arrayList.add(k.b(n0Var, null, null, new zzg(zzeVar, this.zzc, this.zzd, null), 3, null));
                }
            }
            u0[] u0VarArr = (u0[]) arrayList.toArray(new u0[0]);
            u0[] u0VarArr2 = (u0[]) Arrays.copyOf(u0VarArr, u0VarArr.length);
            this.zze = zzenVarZzf;
            this.zza = 1;
            objA = f.a(u0VarArr2, this);
            if (objA == objF) {
                return objF;
            }
            zzenVar = zzenVarZzf;
        }
        String str = this.zzc;
        zzsh zzshVarZzf = zzsi.zzf();
        zzshVarZzf.zze(str);
        Iterator it = ((List) objA).iterator();
        while (it.hasNext()) {
            Object objJ = ((r) it.next()).j();
            if (r.h(objJ)) {
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
