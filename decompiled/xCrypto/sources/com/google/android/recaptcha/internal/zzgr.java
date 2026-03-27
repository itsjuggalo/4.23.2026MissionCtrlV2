package com.google.android.recaptcha.internal;

import W2.E;
import i3.o;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
final class zzgr extends s implements o {
    final /* synthetic */ zzgd zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgr(zzgd zzgdVar, String str, int i4) {
        super(2);
        this.zza = zzgdVar;
        this.zzb = str;
        this.zzc = i4;
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzi().zzb(this.zzb, (String) obj2);
        int i4 = this.zzc;
        if (i4 != -1) {
            this.zza.zzc().zze(i4, objArr);
        }
        return E.f5463a;
    }
}
