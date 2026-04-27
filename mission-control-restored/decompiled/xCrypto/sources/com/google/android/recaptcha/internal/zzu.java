package com.google.android.recaptcha.internal;

import W2.E;
import W2.p;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import java.util.Iterator;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzu extends l implements o {
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

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzu(this.zzd, this.zze, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzu) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzse zzseVarZzj;
        Iterator it;
        Object objE = AbstractC0787c.e();
        if (this.zzc != 0) {
            it = (Iterator) this.zzb;
            zzseVarZzj = (zzse) this.zza;
            q.b(obj);
        } else {
            q.b(obj);
            if (!this.zzd.zzS()) {
                p.a aVar = p.f5487b;
                return p.a(p.b(q.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            zzseVarZzj = this.zzd.zzj();
            if (zzseVarZzj.zzi().zzd() == 0) {
                p.a aVar2 = p.f5487b;
                return p.a(p.b(q.a(new zzbd(zzbb.zzb, zzba.zzab, null))));
            }
            this.zze.zzc = zzseVarZzj.zzi();
            it = this.zze.zzb.iterator();
        }
        while (it.hasNext()) {
            zzy zzyVar = (zzy) it.next();
            this.zza = zzseVarZzj;
            this.zzb = it;
            this.zzc = 1;
            if (zzyVar.zzd(zzseVarZzj, this) == objE) {
                return objE;
            }
        }
        p.a aVar3 = p.f5487b;
        return p.a(p.b(E.f5463a));
    }
}
