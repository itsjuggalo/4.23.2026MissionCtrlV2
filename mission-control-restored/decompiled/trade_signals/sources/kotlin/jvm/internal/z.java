package kotlin.jvm.internal;

import I5.k;
import I5.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends B implements I5.k {
    public z(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, i8);
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.e(this);
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // I5.m
    /* JADX INFO: renamed from: d */
    public o.a f0() {
        return ((I5.k) getReflected()).f0();
    }

    @Override // I5.i
    public k.a h() {
        return ((I5.k) getReflected()).h();
    }
}
