package kotlin.jvm.internal;

import I5.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D extends J implements I5.n {
    public D(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, i8);
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.f(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // I5.m
    public n.a d() {
        return ((I5.n) getReflected()).d();
    }
}
