package kotlin.jvm.internal;

import wd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 extends j0 implements wd.o {
    public f0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }

    @Override // kotlin.jvm.internal.f
    public wd.c computeReflected() {
        return n0.g(this);
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // wd.m
    /* JADX INFO: renamed from: d */
    public o.a e0() {
        return ((wd.o) getReflected()).e0();
    }
}
