package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import android.content.Context;
import android.webkit.WebView;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzjc extends l implements o {
    final /* synthetic */ zzjd zza;
    final /* synthetic */ Context zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjc(zzjd zzjdVar, Context context, d dVar) {
        super(2, dVar);
        this.zza = zzjdVar;
        this.zzb = context;
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzjc(this.zza, this.zzb, dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzjc) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I5.c.e();
        q.b(obj);
        WebView webView = this.zza.zza;
        if (webView == null) {
            webView = new WebView(this.zzb);
        }
        this.zza.zza = webView;
        return webView;
    }
}
