package kotlin.jvm.internal;

import X5.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends C implements X5.i {
    public A(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, i7);
    }

    @Override // X5.i
    public i.a b() {
        ((X5.i) getReflected()).b();
        return null;
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.b computeReflected() {
        return H.f(this);
    }

    @Override // Q5.k
    public Object invoke(Object obj) {
        return get(obj);
    }
}
