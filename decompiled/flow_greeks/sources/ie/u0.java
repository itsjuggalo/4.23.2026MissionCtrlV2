package ie;

import fe.g1;
import fe.s1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class u0 extends w0 implements s1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f12487l = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f12489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f12490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f12491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final xf.r0 f12492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s1 f12493k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final u0 a(fe.a containingDeclaration, s1 s1Var, int i10, ge.h annotations, ef.f name, xf.r0 outType, boolean z10, boolean z11, boolean z12, xf.r0 r0Var, g1 source, Function0 function0) {
            kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.t.f(annotations, "annotations");
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(outType, "outType");
            kotlin.jvm.internal.t.f(source, "source");
            return function0 == null ? new u0(containingDeclaration, s1Var, i10, annotations, name, outType, z10, z11, z12, r0Var, source) : new b(containingDeclaration, s1Var, i10, annotations, name, outType, z10, z11, z12, r0Var, source, function0);
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends u0 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final cd.k f12494m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fe.a containingDeclaration, s1 s1Var, int i10, ge.h annotations, ef.f name, xf.r0 outType, boolean z10, boolean z11, boolean z12, xf.r0 r0Var, g1 source, Function0 destructuringVariables) {
            super(containingDeclaration, s1Var, i10, annotations, name, outType, z10, z11, z12, r0Var, source);
            kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.t.f(annotations, "annotations");
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(outType, "outType");
            kotlin.jvm.internal.t.f(source, "source");
            kotlin.jvm.internal.t.f(destructuringVariables, "destructuringVariables");
            this.f12494m = cd.l.b(destructuringVariables);
        }

        public static final List O0(b bVar) {
            return bVar.P0();
        }

        @Override // ie.u0, fe.s1
        public s1 O(fe.a newOwner, ef.f newName, int i10) {
            kotlin.jvm.internal.t.f(newOwner, "newOwner");
            kotlin.jvm.internal.t.f(newName, "newName");
            ge.h annotations = getAnnotations();
            kotlin.jvm.internal.t.e(annotations, "<get-annotations>(...)");
            xf.r0 type = getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            boolean zS0 = s0();
            boolean zB0 = b0();
            boolean Z = Z();
            xf.r0 r0VarJ0 = j0();
            g1 NO_SOURCE = g1.f9483a;
            kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i10, annotations, newName, type, zS0, zB0, Z, r0VarJ0, NO_SOURCE, new v0(this));
        }

        public final List P0() {
            return (List) this.f12494m.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(fe.a containingDeclaration, s1 s1Var, int i10, ge.h annotations, ef.f name, xf.r0 outType, boolean z10, boolean z11, boolean z12, xf.r0 r0Var, g1 source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(outType, "outType");
        kotlin.jvm.internal.t.f(source, "source");
        this.f12488f = i10;
        this.f12489g = z10;
        this.f12490h = z11;
        this.f12491i = z12;
        this.f12492j = r0Var;
        this.f12493k = s1Var == null ? this : s1Var;
    }

    public static final u0 K0(fe.a aVar, s1 s1Var, int i10, ge.h hVar, ef.f fVar, xf.r0 r0Var, boolean z10, boolean z11, boolean z12, xf.r0 r0Var2, g1 g1Var, Function0 function0) {
        return f12487l.a(aVar, s1Var, i10, hVar, fVar, r0Var, z10, z11, z12, r0Var2, g1Var, function0);
    }

    public Void L0() {
        return null;
    }

    @Override // fe.i1
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public s1 c(f2 substitutor) {
        kotlin.jvm.internal.t.f(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // fe.s1
    public s1 O(fe.a newOwner, ef.f newName, int i10) {
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(newName, "newName");
        ge.h annotations = getAnnotations();
        kotlin.jvm.internal.t.e(annotations, "<get-annotations>(...)");
        xf.r0 type = getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        boolean zS0 = s0();
        boolean zB0 = b0();
        boolean Z = Z();
        xf.r0 r0VarJ0 = j0();
        g1 NO_SOURCE = g1.f9483a;
        kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
        return new u0(newOwner, null, i10, annotations, newName, type, zS0, zB0, Z, r0VarJ0, NO_SOURCE);
    }

    @Override // fe.t1
    public /* bridge */ /* synthetic */ lf.g Y() {
        return (lf.g) L0();
    }

    @Override // fe.s1
    public boolean Z() {
        return this.f12491i;
    }

    @Override // fe.s1
    public boolean b0() {
        return this.f12490h;
    }

    @Override // fe.a
    public Collection f() {
        Collection collectionF = b().f();
        kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(collectionF, 10));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add((s1) ((fe.a) it.next()).i().get(getIndex()));
        }
        return arrayList;
    }

    @Override // fe.s1
    public int getIndex() {
        return this.f12488f;
    }

    @Override // fe.q
    public fe.u getVisibility() {
        fe.u LOCAL = fe.t.f9512f;
        kotlin.jvm.internal.t.e(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // fe.t1
    public boolean i0() {
        return false;
    }

    @Override // fe.s1
    public xf.r0 j0() {
        return this.f12492j;
    }

    @Override // fe.s1
    public boolean s0() {
        if (!this.f12489g) {
            return false;
        }
        fe.a aVarB = b();
        kotlin.jvm.internal.t.d(aVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        return ((fe.b) aVarB).h().a();
    }

    @Override // fe.m
    public Object t0(fe.o visitor, Object obj) {
        kotlin.jvm.internal.t.f(visitor, "visitor");
        return visitor.a(this, obj);
    }

    @Override // ie.n, fe.m
    public fe.a b() {
        fe.m mVarB = super.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (fe.a) mVarB;
    }

    @Override // ie.n
    public s1 a() {
        s1 s1Var = this.f12493k;
        return s1Var == this ? this : s1Var.a();
    }
}
