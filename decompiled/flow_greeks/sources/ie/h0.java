package ie;

import fe.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 extends n implements fe.n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ef.c f12346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12347f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(fe.h0 module, ef.c fqName) {
        super(module, ge.h.L.b(), fqName.g(), g1.f9483a);
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        this.f12346e = fqName;
        this.f12347f = "package " + fqName + " of " + module;
    }

    @Override // fe.n0
    public final ef.c e() {
        return this.f12346e;
    }

    @Override // ie.n, fe.p
    public g1 j() {
        g1 NO_SOURCE = g1.f9483a;
        kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // fe.m
    public Object t0(fe.o visitor, Object obj) {
        kotlin.jvm.internal.t.f(visitor, "visitor");
        return visitor.e(this, obj);
    }

    @Override // ie.m
    public String toString() {
        return this.f12347f;
    }

    @Override // ie.n, fe.m
    public fe.h0 b() {
        fe.m mVarB = super.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (fe.h0) mVarB;
    }
}
