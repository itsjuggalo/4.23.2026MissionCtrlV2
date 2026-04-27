package kotlin.jvm.internal;

import I5.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F extends J implements I5.o {
    public F(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, i8);
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.g(this);
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // I5.m
    /* JADX INFO: renamed from: d */
    public o.a f0() {
        return ((I5.o) getReflected()).f0();
    }
}
