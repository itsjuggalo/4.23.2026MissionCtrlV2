package zd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v2 implements wd.r, x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f25860d = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(v2.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.l1 f25861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2.a f25862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2 f25863c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25864a;

        static {
            int[] iArr = new int[xf.m2.values().length];
            try {
                iArr[xf.m2.f25015e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[xf.m2.f25016f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[xf.m2.f25017g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f25864a = iArr;
        }
    }

    public v2(w2 w2Var, fe.l1 descriptor) {
        w0 w0VarF;
        Object objT0;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f25861a = descriptor;
        this.f25862b = z2.c(new u2(this));
        if (w2Var == null) {
            fe.m mVarB = getDescriptor().b();
            kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
            if (mVarB instanceof fe.e) {
                objT0 = f((fe.e) mVarB);
            } else {
                if (!(mVarB instanceof fe.b)) {
                    throw new x2("Unknown type parameter container: " + mVarB);
                }
                fe.m mVarB2 = ((fe.b) mVarB).b();
                kotlin.jvm.internal.t.e(mVarB2, "getContainingDeclaration(...)");
                if (mVarB2 instanceof fe.e) {
                    w0VarF = f((fe.e) mVarB2);
                } else {
                    vf.t tVar = mVarB instanceof vf.t ? (vf.t) mVarB : null;
                    if (tVar == null) {
                        throw new x2("Non-class callable descriptor must be deserialized: " + mVarB);
                    }
                    wd.d dVarE = od.a.e(d(tVar));
                    kotlin.jvm.internal.t.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                    w0VarF = (w0) dVarE;
                }
                objT0 = mVarB.t0(new j(w0VarF), cd.h0.f3852a);
            }
            w2Var = (w2) objT0;
        }
        this.f25863c = w2Var;
    }

    public static final List g(v2 v2Var) {
        List upperBounds = v2Var.getDescriptor().getUpperBounds();
        kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(new t2((xf.r0) it.next(), null, 2, null));
        }
        return arrayList;
    }

    public final Class d(vf.t tVar) {
        Class clsE;
        vf.s sVarC0 = tVar.c0();
        xe.r rVar = sVarC0 instanceof xe.r ? (xe.r) sVarC0 : null;
        xe.x xVarG = rVar != null ? rVar.g() : null;
        ke.f fVar = xVarG instanceof ke.f ? (ke.f) xVarG : null;
        if (fVar != null && (clsE = fVar.e()) != null) {
            return clsE;
        }
        throw new x2("Container of deserialized member is not resolved: " + tVar);
    }

    @Override // zd.x0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public fe.l1 getDescriptor() {
        return this.f25861a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return kotlin.jvm.internal.t.b(this.f25863c, v2Var.f25863c) && kotlin.jvm.internal.t.b(getName(), v2Var.getName());
    }

    public final w0 f(fe.e eVar) {
        Class clsQ = i3.q(eVar);
        w0 w0Var = (w0) (clsQ != null ? od.a.e(clsQ) : null);
        if (w0Var != null) {
            return w0Var;
        }
        throw new x2("Type parameter container is not resolved: " + eVar.b());
    }

    @Override // wd.r
    public String getName() {
        String strB = getDescriptor().getName().b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        return strB;
    }

    @Override // wd.r
    public List getUpperBounds() {
        Object objB = this.f25862b.b(this, f25860d[0]);
        kotlin.jvm.internal.t.e(objB, "getValue(...)");
        return (List) objB;
    }

    public int hashCode() {
        return (this.f25863c.hashCode() * 31) + getName().hashCode();
    }

    @Override // wd.r
    public wd.t o() {
        int i10 = a.f25864a[getDescriptor().o().ordinal()];
        if (i10 == 1) {
            return wd.t.f23912a;
        }
        if (i10 == 2) {
            return wd.t.f23913b;
        }
        if (i10 == 3) {
            return wd.t.f23914c;
        }
        throw new cd.o();
    }

    public String toString() {
        return kotlin.jvm.internal.u0.f14954a.a(this);
    }
}
