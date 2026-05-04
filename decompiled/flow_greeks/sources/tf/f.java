package tf;

import ze.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f21951b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(fe.h0 module, fe.m0 notFoundClasses, sf.a protocol) {
        super(protocol);
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(protocol, "protocol");
        this.f21951b = new g(module, notFoundClasses);
    }

    @Override // tf.h
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ge.c f(ze.b proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        return this.f21951b.a(proto, nameResolver);
    }

    @Override // tf.e
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public lf.g h(n0 container, ze.n proto, xf.r0 expectedType) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(expectedType, "expectedType");
        return null;
    }

    @Override // tf.e
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public lf.g j(n0 container, ze.n proto, xf.r0 expectedType) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(expectedType, "expectedType");
        b.C0490b.c cVar = (b.C0490b.c) bf.e.a(proto, m().b());
        if (cVar == null) {
            return null;
        }
        return this.f21951b.f(expectedType, cVar, container.b());
    }
}
