package com.google.android.recaptcha.internal;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
final class zzbg extends l implements o {
    public zzbg(e eVar) {
        super(2, eVar);
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new zzbg(eVar);
    }

    @Override // i3.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbg) create((L) obj, (e) obj2)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        q.b(obj);
        Thread.currentThread().setPriority(8);
        return E.f5463a;
    }
}
