package ie;

import fe.g1;
import fe.k1;
import ie.s0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import qf.k;
import xf.c1;
import xf.i2;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends n implements k1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f12317j = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(g.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.n f12318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fe.u f12319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.i f12320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f12321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f12322i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements u1 {
        public a() {
        }

        @Override // xf.u1
        public u1 a(yf.g kotlinTypeRefiner) {
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // xf.u1
        public Collection c() {
            Collection collectionC = b().f0().N0().c();
            kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
            return collectionC;
        }

        @Override // xf.u1
        public boolean d() {
            return true;
        }

        @Override // xf.u1
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public k1 b() {
            return g.this;
        }

        @Override // xf.u1
        public List getParameters() {
            return g.this.R0();
        }

        @Override // xf.u1
        public ce.i p() {
            return nf.e.m(b());
        }

        public String toString() {
            return "[typealias " + b().getName().b() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(wf.n storageManager, fe.m containingDeclaration, ge.h annotations, ef.f name, g1 sourceElement, fe.u visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(sourceElement, "sourceElement");
        kotlin.jvm.internal.t.f(visibilityImpl, "visibilityImpl");
        this.f12318e = storageManager;
        this.f12319f = visibilityImpl;
        this.f12320g = storageManager.e(new d(this));
        this.f12322i = new a();
    }

    public static final c1 N0(g gVar, yf.g gVar2) {
        fe.h hVarF = gVar2.f(gVar);
        if (hVarF != null) {
            return hVarF.s();
        }
        return null;
    }

    public static final Collection O0(g gVar) {
        return gVar.Q0();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Boolean T0(ie.g r1, xf.l2 r2) {
        /*
            kotlin.jvm.internal.t.c(r2)
            boolean r0 = xf.v0.a(r2)
            if (r0 != 0) goto L23
            xf.u1 r2 = r2.N0()
            fe.h r2 = r2.b()
            boolean r0 = r2 instanceof fe.l1
            if (r0 == 0) goto L23
            fe.l1 r2 = (fe.l1) r2
            fe.m r2 = r2.b()
            boolean r1 = kotlin.jvm.internal.t.b(r2, r1)
            if (r1 != 0) goto L23
            r1 = 1
            goto L24
        L23:
            r1 = 0
        L24:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.g.T0(ie.g, xf.l2):java.lang.Boolean");
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    public final c1 M0() {
        qf.k kVarD0;
        fe.e eVarR = r();
        if (eVarR == null || (kVarD0 = eVarR.D0()) == null) {
            kVarD0 = k.b.f19087b;
        }
        c1 c1VarU = i2.u(this, kVarD0, new f(this));
        kotlin.jvm.internal.t.e(c1VarU, "makeUnsubstitutedType(...)");
        return c1VarU;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    @Override // fe.i
    public boolean P() {
        return i2.c(f0(), new e(this));
    }

    @Override // ie.n
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public k1 a() {
        fe.p pVarA = super.a();
        kotlin.jvm.internal.t.d(pVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (k1) pVarA;
    }

    public final Collection Q0() {
        fe.e eVarR = r();
        if (eVarR == null) {
            return dd.r.k();
        }
        Collection<fe.d> collectionM = eVarR.m();
        kotlin.jvm.internal.t.e(collectionM, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (fe.d dVar : collectionM) {
            s0.a aVar = s0.I;
            wf.n nVar = this.f12318e;
            kotlin.jvm.internal.t.c(dVar);
            q0 q0VarB = aVar.b(nVar, this, dVar);
            if (q0VarB != null) {
                arrayList.add(q0VarB);
            }
        }
        return arrayList;
    }

    public abstract List R0();

    public final void S0(List declaredTypeParameters) {
        kotlin.jvm.internal.t.f(declaredTypeParameters, "declaredTypeParameters");
        this.f12321h = declaredTypeParameters;
    }

    public final wf.n g0() {
        return this.f12318e;
    }

    @Override // fe.d0, fe.q
    public fe.u getVisibility() {
        return this.f12319f;
    }

    @Override // fe.d0
    public boolean isExternal() {
        return false;
    }

    @Override // fe.h
    public u1 k() {
        return this.f12322i;
    }

    @Override // fe.m
    public Object t0(fe.o visitor, Object obj) {
        kotlin.jvm.internal.t.f(visitor, "visitor");
        return visitor.g(this, obj);
    }

    @Override // ie.m
    public String toString() {
        return "typealias " + getName().b();
    }

    @Override // fe.i
    public List v() {
        List list = this.f12321h;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.t.s("declaredTypeParametersImpl");
        return null;
    }
}
