package oe;

import oe.t0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends t0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final i f17980o = new i();

    public static final fe.z l(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        i iVar = f17980o;
        ef.f name = functionDescriptor.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        if (iVar.n(name)) {
            return (fe.z) nf.e.i(functionDescriptor, false, g.f17968a, 1, null);
        }
        return null;
    }

    public static final boolean m(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return f17980o.k(it);
    }

    public static final t0.b o(fe.b bVar) {
        fe.b bVarI;
        String strD;
        kotlin.jvm.internal.t.f(bVar, "<this>");
        t0.a aVar = t0.f18060a;
        if (!aVar.d().contains(bVar.getName()) || (bVarI = nf.e.i(bVar, false, h.f17974a, 1, null)) == null || (strD = xe.c0.d(bVarI)) == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public static final boolean p(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return (it instanceof fe.z) && f17980o.k(it);
    }

    public final boolean k(fe.b bVar) {
        return dd.a0.R(t0.f18060a.e(), xe.c0.d(bVar));
    }

    public final boolean n(ef.f fVar) {
        kotlin.jvm.internal.t.f(fVar, "<this>");
        return t0.f18060a.d().contains(fVar);
    }
}
