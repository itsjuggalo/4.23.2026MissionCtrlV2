package kotlin.jvm.internal;

import I5.j;
import I5.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends B implements I5.j {
    public x(Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, i8);
    }

    @Override // kotlin.jvm.internal.AbstractC2291f
    public I5.c computeReflected() {
        return O.d(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // I5.m
    /* JADX INFO: renamed from: d */
    public n.a f0() {
        return ((I5.j) getReflected()).f0();
    }

    @Override // I5.i
    public j.a h() {
        return ((I5.j) getReflected()).h();
    }
}
