package kotlin.jvm.internal;

import p3.InterfaceC1715b;
import p3.h;
import p3.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class A extends C implements p3.j {
    public A(Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, i4);
    }

    @Override // kotlin.jvm.internal.AbstractC1580e
    public InterfaceC1715b computeReflected() {
        return G.f(this);
    }

    @Override // p3.j
    public Object getDelegate(Object obj) {
        return ((p3.j) getReflected()).getDelegate(obj);
    }

    public /* bridge */ /* synthetic */ h.a getGetter() {
        mo221getGetter();
        return null;
    }

    @Override // i3.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // p3.j
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public j.a mo221getGetter() {
        ((p3.j) getReflected()).mo221getGetter();
        return null;
    }
}
