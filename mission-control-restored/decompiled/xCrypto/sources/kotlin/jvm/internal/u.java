package kotlin.jvm.internal;

import p3.InterfaceC1715b;
import p3.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u extends w implements p3.g {
    public u(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public InterfaceC1715b computeReflected() {
        return G.d(this);
    }

    @Override // p3.i
    public i.a getGetter() {
        ((p3.g) getReflected()).getGetter();
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
