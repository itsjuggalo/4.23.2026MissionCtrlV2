package kotlin.jvm.internal;

import X5.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends w implements X5.g {
    public u(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, i7);
    }

    @Override // X5.h
    public h.a b() {
        ((X5.g) getReflected()).b();
        return null;
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.b computeReflected() {
        return H.d(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
