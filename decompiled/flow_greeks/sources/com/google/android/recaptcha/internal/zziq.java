package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import cd.h0;
import cd.s;
import gd.e;
import hd.c;
import id.m;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zziq extends m implements o {
    int zza;
    final /* synthetic */ zzja zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziq(zzja zzjaVar, String str, e eVar) {
        super(2, eVar);
        this.zzb = zzjaVar;
        this.zzc = str;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new zziq(this.zzb, this.zzc, eVar);
    }

    @Override // pd.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zziq) create((n0) obj, (e) obj2)).invokeSuspend(h0.f3852a);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = c.f();
        int i10 = this.zza;
        s.b(obj);
        if (i10 == 0) {
            zzja zzjaVar = this.zzb;
            this.zza = 1;
            obj = zzjaVar.zzw(this);
            if (obj == objF) {
                return objF;
            }
        }
        ((WebView) obj).evaluateJavascript("recaptcha.m.Main.execute(\"" + this.zzc + "\")", null);
        return h0.f3852a;
    }
}
