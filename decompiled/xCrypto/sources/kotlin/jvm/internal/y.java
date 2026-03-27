package kotlin.jvm.internal;

import p3.InterfaceC1715b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends C implements p3.i {
    public y(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public InterfaceC1715b computeReflected() {
        return G.e(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
