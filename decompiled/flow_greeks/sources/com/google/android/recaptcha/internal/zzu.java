package com.google.android.recaptcha.internal;

import cd.h0;
import cd.r;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import java.util.Iterator;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzu extends m implements o {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zzsc zzd;
    final /* synthetic */ zzv zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzu(zzsc zzscVar, zzv zzvVar, e eVar) {
        super(2, eVar);
        this.zzd = zzscVar;
        this.zze = zzvVar;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zzu(this.zzd, this.zze, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzu) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzse zzseVarZzj;
        Iterator it;
        Object objF = c.f();
        if (this.zzc != 0) {
            it = (Iterator) this.zzb;
            zzseVarZzj = (zzse) this.zza;
            s.b(obj);
        } else {
            s.b(obj);
            if (!this.zzd.zzS()) {
                r.a aVar = r.f3870b;
                return r.a(r.b(s.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            zzseVarZzj = this.zzd.zzj();
            if (zzseVarZzj.zzi().zzd() == 0) {
                r.a aVar2 = r.f3870b;
                return r.a(r.b(s.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            this.zze.zzc = zzseVarZzj.zzi();
            it = this.zze.zzb.iterator();
        }
        while (it.hasNext()) {
            zzy zzyVar = (zzy) it.next();
            this.zza = zzseVarZzj;
            this.zzb = it;
            this.zzc = 1;
            if (zzyVar.zzd(zzseVarZzj, this) == objF) {
                return objF;
            }
        }
        r.a aVar3 = r.f3870b;
        return r.a(r.b(h0.f3852a));
    }
}
