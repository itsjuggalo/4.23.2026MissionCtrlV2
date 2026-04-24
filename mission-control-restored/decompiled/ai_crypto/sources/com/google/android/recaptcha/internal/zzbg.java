package com.google.android.recaptcha.internal;

import E5.E;
import E5.q;
import H5.d;
import J5.l;
import Q5.o;
import b6.L;

/* JADX INFO: loaded from: classes.dex */
final class zzbg extends l implements o {
    public zzbg(d dVar) {
        super(2, dVar);
    }

    @Override // J5.a
    public final d create(Object obj, d dVar) {
        return new zzbg(dVar);
    }

    @Override // Q5.o
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbg) create((L) obj, (d) obj2)).invokeSuspend(E.f1657a);
    }

    @Override // J5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I5.c.e();
        q.b(obj);
        Thread.currentThread().setPriority(8);
        return E.f1657a;
    }
}
