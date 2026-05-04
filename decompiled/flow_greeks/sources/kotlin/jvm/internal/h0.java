package kotlin.jvm.internal;

import wd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 extends j0 implements wd.p {
    public h0(Class cls, String str, String str2, int i10) {
        super(f.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.f
    public wd.c computeReflected() {
        return n0.h(this);
    }

    @Override // pd.o
    public Object invoke(Object obj, Object obj2) {
        return m(obj, obj2);
    }

    @Override // wd.m
    public p.a d() {
        return ((wd.p) getReflected()).d();
    }
}
