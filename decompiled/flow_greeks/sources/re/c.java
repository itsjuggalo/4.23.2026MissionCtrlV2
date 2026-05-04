package re;

import kotlin.jvm.internal.t;
import oe.e0;
import ve.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final k c(k kVar, fe.m mVar, z zVar, int i10, cd.k kVar2) {
        return new k(kVar.a(), zVar != null ? new m(kVar, mVar, zVar, i10) : kVar.f(), kVar2);
    }

    public static final k d(k kVar, p typeParameterResolver) {
        t.f(kVar, "<this>");
        t.f(typeParameterResolver, "typeParameterResolver");
        return new k(kVar.a(), typeParameterResolver, kVar.c());
    }

    public static final k e(k kVar, fe.g containingDeclaration, z zVar, int i10) {
        t.f(kVar, "<this>");
        t.f(containingDeclaration, "containingDeclaration");
        return c(kVar, containingDeclaration, zVar, i10, cd.l.a(cd.n.f3865c, new a(kVar, containingDeclaration)));
    }

    public static /* synthetic */ k f(k kVar, fe.g gVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            zVar = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e(kVar, gVar, zVar, i10);
    }

    public static final e0 g(k kVar, fe.g gVar) {
        return j(kVar, gVar.getAnnotations());
    }

    public static final k h(k kVar, fe.m containingDeclaration, z typeParameterOwner, int i10) {
        t.f(kVar, "<this>");
        t.f(containingDeclaration, "containingDeclaration");
        t.f(typeParameterOwner, "typeParameterOwner");
        return c(kVar, containingDeclaration, typeParameterOwner, i10, kVar.c());
    }

    public static /* synthetic */ k i(k kVar, fe.m mVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return h(kVar, mVar, zVar, i10);
    }

    public static final e0 j(k kVar, ge.h additionalAnnotations) {
        t.f(kVar, "<this>");
        t.f(additionalAnnotations, "additionalAnnotations");
        return kVar.a().a().d(kVar.b(), additionalAnnotations);
    }

    public static final k k(k kVar, ge.h additionalAnnotations) {
        t.f(kVar, "<this>");
        t.f(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? kVar : new k(kVar.a(), kVar.f(), cd.l.a(cd.n.f3865c, new b(kVar, additionalAnnotations)));
    }

    public static final e0 l(k kVar, ge.h hVar) {
        return j(kVar, hVar);
    }

    public static final k m(k kVar, d components) {
        t.f(kVar, "<this>");
        t.f(components, "components");
        return new k(components, kVar.f(), kVar.c());
    }
}
