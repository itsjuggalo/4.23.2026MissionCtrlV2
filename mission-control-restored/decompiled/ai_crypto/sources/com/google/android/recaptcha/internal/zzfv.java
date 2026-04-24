package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import F5.v;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;
import com.amazon.a.a.o.b.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class zzfv extends l implements o {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzfw zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfv(String[] strArr, zzfw zzfwVar, String str, d dVar) {
        super(2, dVar);
        this.zza = strArr;
        this.zzb = zzfwVar;
        this.zzc = str;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzfv(this.zza, this.zzb, this.zzc, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfv) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I5.c.e();
        q.b(obj);
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("\"" + str + "\"");
        }
        this.zzb.zza.evaluateJavascript(this.zzc + "(" + v.R(arrayList, f.f9989a, null, null, 0, null, null, 62, null) + ")", null);
        return E.f1657a;
    }
}
