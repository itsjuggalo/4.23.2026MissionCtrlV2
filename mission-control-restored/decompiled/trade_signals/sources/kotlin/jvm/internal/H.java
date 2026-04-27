package kotlin.jvm.internal;

import I5.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class H extends J implements I5.p {
    public H(Class cls, String str, String str2, int i8) {
        super(AbstractC2291f.NO_RECEIVER, cls, str, str2, i8);
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.h(this);
    }

    @Override // B5.o
    public Object invoke(Object obj, Object obj2) {
        return l(obj, obj2);
    }

    @Override // I5.m
    /* JADX INFO: renamed from: d */
    public p.a f0() {
        return ((I5.p) getReflected()).f0();
    }
}
