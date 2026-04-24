package d6;

import R5.InterfaceC0850g;
import R5.InterfaceC0856m;
import a6.E;
import h6.z;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final k c(k kVar, InterfaceC0856m interfaceC0856m, z zVar, int i8, InterfaceC2483k interfaceC2483k) {
        return new k(kVar.a(), zVar != null ? new m(kVar, interfaceC0856m, zVar, i8) : kVar.f(), interfaceC2483k);
    }

    public static final k d(k kVar, p typeParameterResolver) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(typeParameterResolver, "typeParameterResolver");
        return new k(kVar.a(), typeParameterResolver, kVar.c());
    }

    public static final k e(k kVar, InterfaceC0850g containingDeclaration, z zVar, int i8) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        return c(kVar, containingDeclaration, zVar, i8, AbstractC2484l.b(EnumC2486n.f21976c, new C1639a(kVar, containingDeclaration)));
    }

    public static /* synthetic */ k f(k kVar, InterfaceC0850g interfaceC0850g, z zVar, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            zVar = null;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return e(kVar, interfaceC0850g, zVar, i8);
    }

    public static final E g(k kVar, InterfaceC0850g interfaceC0850g) {
        return j(kVar, interfaceC0850g.getAnnotations());
    }

    public static final k h(k kVar, InterfaceC0856m containingDeclaration, z typeParameterOwner, int i8) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        AbstractC2304t.f(typeParameterOwner, "typeParameterOwner");
        return c(kVar, containingDeclaration, typeParameterOwner, i8, kVar.c());
    }

    public static /* synthetic */ k i(k kVar, InterfaceC0856m interfaceC0856m, z zVar, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return h(kVar, interfaceC0856m, zVar, i8);
    }

    public static final E j(k kVar, S5.h additionalAnnotations) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(additionalAnnotations, "additionalAnnotations");
        return kVar.a().a().d(kVar.b(), additionalAnnotations);
    }

    public static final k k(k kVar, S5.h additionalAnnotations) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? kVar : new k(kVar.a(), kVar.f(), AbstractC2484l.b(EnumC2486n.f21976c, new b(kVar, additionalAnnotations)));
    }

    public static final E l(k kVar, S5.h hVar) {
        return j(kVar, hVar);
    }

    public static final k m(k kVar, d components) {
        AbstractC2304t.f(kVar, "<this>");
        AbstractC2304t.f(components, "components");
        return new k(components, kVar.f(), kVar.c());
    }
}
