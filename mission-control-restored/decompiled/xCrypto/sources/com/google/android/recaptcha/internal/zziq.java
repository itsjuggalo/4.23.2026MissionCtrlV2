package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import android.webkit.WebView;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zziq extends l implements o {
    int zza;
    final /* synthetic */ zzja zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziq(zzja zzjaVar, String str, e eVar) {
        super(2, eVar);
        this.zzb = zzjaVar;
        this.zzc = str;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zziq(this.zzb, this.zzc, eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zziq) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.zza;
        q.b(obj);
        if (i4 == 0) {
            zzja zzjaVar = this.zzb;
            this.zza = 1;
            obj = zzjaVar.zzw(this);
            if (obj == objE) {
                return objE;
            }
        }
        ((WebView) obj).evaluateJavascript("recaptcha.m.Main.execute(\"" + this.zzc + "\")", null);
        return E.f5463a;
    }
}
