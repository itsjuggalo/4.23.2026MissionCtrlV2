package xf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k1 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f25000d;

        public a(List list) {
            this.f25000d = list;
        }

        @Override // xf.v1
        public a2 k(u1 key) {
            kotlin.jvm.internal.t.f(key, "key");
            if (!this.f25000d.contains(key)) {
                return null;
            }
            fe.h hVarB = key.b();
            kotlin.jvm.internal.t.d(hVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return i2.s((fe.l1) hVarB);
        }
    }

    public static final r0 a(List list, List list2, ce.i iVar) {
        r0 r0VarP = f2.g(new a(list)).p((r0) dd.a0.Z(list2), m2.f25017g);
        if (r0VarP != null) {
            return r0VarP;
        }
        c1 c1VarZ = iVar.z();
        kotlin.jvm.internal.t.e(c1VarZ, "getDefaultBound(...)");
        return c1VarZ;
    }

    public static final r0 b(fe.l1 l1Var) {
        kotlin.jvm.internal.t.f(l1Var, "<this>");
        fe.m mVarB = l1Var.b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        if (mVarB instanceof fe.i) {
            List parameters = ((fe.i) mVarB).k().getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            ArrayList arrayList = new ArrayList(dd.s.u(parameters, 10));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                u1 u1VarK = ((fe.l1) it.next()).k();
                kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
                arrayList.add(u1VarK);
            }
            List upperBounds = l1Var.getUpperBounds();
            kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
            return a(arrayList, upperBounds, nf.e.m(l1Var));
        }
        if (!(mVarB instanceof fe.z)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List typeParameters = ((fe.z) mVarB).getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList2 = new ArrayList(dd.s.u(typeParameters, 10));
        Iterator it2 = typeParameters.iterator();
        while (it2.hasNext()) {
            u1 u1VarK2 = ((fe.l1) it2.next()).k();
            kotlin.jvm.internal.t.e(u1VarK2, "getTypeConstructor(...)");
            arrayList2.add(u1VarK2);
        }
        List upperBounds2 = l1Var.getUpperBounds();
        kotlin.jvm.internal.t.e(upperBounds2, "getUpperBounds(...)");
        return a(arrayList2, upperBounds2, nf.e.m(l1Var));
    }
}
