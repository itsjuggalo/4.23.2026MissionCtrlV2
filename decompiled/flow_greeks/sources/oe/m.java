package oe;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f18040a = new m();

    public static final boolean c(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return f18040a.d(it);
    }

    public final String b(fe.b bVar) {
        ef.f fVar;
        kotlin.jvm.internal.t.f(bVar, "<this>");
        ce.i.h0(bVar);
        fe.b bVarI = nf.e.i(nf.e.w(bVar), false, l.f18038a, 1, null);
        if (bVarI == null || (fVar = (ef.f) j.f18004a.a().get(nf.e.o(bVarI))) == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean d(fe.b callableMemberDescriptor) {
        kotlin.jvm.internal.t.f(callableMemberDescriptor, "callableMemberDescriptor");
        if (j.f18004a.d().contains(callableMemberDescriptor.getName())) {
            return e(callableMemberDescriptor);
        }
        return false;
    }

    public final boolean e(fe.b bVar) {
        if (dd.a0.R(j.f18004a.c(), nf.e.k(bVar)) && bVar.i().isEmpty()) {
            return true;
        }
        if (!ce.i.h0(bVar)) {
            return false;
        }
        Collection<fe.b> collectionF = bVar.f();
        kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
        if (collectionF.isEmpty()) {
            return false;
        }
        for (fe.b bVar2 : collectionF) {
            m mVar = f18040a;
            kotlin.jvm.internal.t.c(bVar2);
            if (mVar.d(bVar2)) {
                return true;
            }
        }
        return false;
    }
}
