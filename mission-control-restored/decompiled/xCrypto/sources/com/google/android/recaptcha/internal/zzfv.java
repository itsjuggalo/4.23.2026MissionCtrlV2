package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import X2.x;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import com.amazon.a.a.o.b.f;
import i3.o;
import java.util.ArrayList;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzfv extends l implements o {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzfw zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfv(String[] strArr, zzfw zzfwVar, String str, e eVar) {
        super(2, eVar);
        this.zza = strArr;
        this.zzb = zzfwVar;
        this.zzc = str;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzfv(this.zza, this.zzb, this.zzc, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfv) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        q.b(obj);
        String[] strArr = this.zza;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("\"" + str + "\"");
        }
        this.zzb.zza.evaluateJavascript(this.zzc + "(" + x.Q(arrayList, f.f8804a, null, null, 0, null, null, 62, null) + ")", null);
        return E.f5463a;
    }
}
