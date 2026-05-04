package zd;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t2 implements kotlin.jvm.internal.u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f25837e = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(t2.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(t2.class, "arguments", "getArguments()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xf.r0 f25838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2.a f25839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z2.a f25840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z2.a f25841d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25842a;

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
            f25842a = iArr;
        }
    }

    public t2(xf.r0 type, Function0 function0) {
        kotlin.jvm.internal.t.f(type, "type");
        this.f25838a = type;
        z2.a aVarC = null;
        z2.a aVar = function0 instanceof z2.a ? (z2.a) function0 : null;
        if (aVar != null) {
            aVarC = aVar;
        } else if (function0 != null) {
            aVarC = z2.c(function0);
        }
        this.f25839b = aVarC;
        this.f25840c = z2.c(new p2(this));
        this.f25841d = z2.c(new q2(this, function0));
    }

    public static final List r(t2 t2Var, Function0 function0) {
        wd.s sVarD;
        List listL0 = t2Var.f25838a.L0();
        if (listL0.isEmpty()) {
            return dd.r.k();
        }
        cd.k kVarA = cd.l.a(cd.n.f3864b, new r2(t2Var));
        ArrayList arrayList = new ArrayList(dd.s.u(listL0, 10));
        int i10 = 0;
        for (Object obj : listL0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            xf.a2 a2Var = (xf.a2) obj;
            if (a2Var.c()) {
                sVarD = wd.s.f23907c.c();
            } else {
                xf.r0 type = a2Var.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                t2 t2Var2 = new t2(type, function0 == null ? null : new s2(t2Var, i10, kVarA));
                int i12 = a.f25842a[a2Var.b().ordinal()];
                if (i12 == 1) {
                    sVarD = wd.s.f23907c.d(t2Var2);
                } else if (i12 == 2) {
                    sVarD = wd.s.f23907c.a(t2Var2);
                } else {
                    if (i12 != 3) {
                        throw new cd.o();
                    }
                    sVarD = wd.s.f23907c.b(t2Var2);
                }
            }
            arrayList.add(sVarD);
            i10 = i11;
        }
        return arrayList;
    }

    public static final List s(t2 t2Var) {
        Type typeK = t2Var.k();
        kotlin.jvm.internal.t.c(typeK);
        return le.f.h(typeK);
    }

    public static final List t(cd.k kVar) {
        return (List) kVar.getValue();
    }

    public static final Type u(t2 t2Var, int i10, cd.k kVar) {
        Type typeK = t2Var.k();
        if (typeK instanceof Class) {
            Class cls = (Class) typeK;
            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            kotlin.jvm.internal.t.c(componentType);
            return componentType;
        }
        if (typeK instanceof GenericArrayType) {
            if (i10 == 0) {
                Type genericComponentType = ((GenericArrayType) typeK).getGenericComponentType();
                kotlin.jvm.internal.t.c(genericComponentType);
                return genericComponentType;
            }
            throw new x2("Array type has been queried for a non-0th argument: " + t2Var);
        }
        if (!(typeK instanceof ParameterizedType)) {
            throw new x2("Non-generic type has been queried for arguments: " + t2Var);
        }
        Type type = (Type) t(kVar).get(i10);
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        kotlin.jvm.internal.t.e(lowerBounds, "getLowerBounds(...)");
        Type type2 = (Type) dd.n.D(lowerBounds);
        if (type2 == null) {
            Type[] upperBounds = wildcardType.getUpperBounds();
            kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
            type2 = (Type) dd.n.C(upperBounds);
        }
        kotlin.jvm.internal.t.c(type2);
        return type2;
    }

    public static final wd.f v(t2 t2Var) {
        return t2Var.w(t2Var.f25838a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t2)) {
            return false;
        }
        t2 t2Var = (t2) obj;
        return kotlin.jvm.internal.t.b(this.f25838a, t2Var.f25838a) && kotlin.jvm.internal.t.b(j(), t2Var.j()) && kotlin.jvm.internal.t.b(f(), t2Var.f());
    }

    @Override // wd.q
    public List f() {
        Object objB = this.f25841d.b(this, f25837e[1]);
        kotlin.jvm.internal.t.e(objB, "getValue(...)");
        return (List) objB;
    }

    public int hashCode() {
        int iHashCode = this.f25838a.hashCode() * 31;
        wd.f fVarJ = j();
        return ((iHashCode + (fVarJ != null ? fVarJ.hashCode() : 0)) * 31) + f().hashCode();
    }

    @Override // wd.q
    public wd.f j() {
        return (wd.f) this.f25840c.b(this, f25837e[0]);
    }

    @Override // kotlin.jvm.internal.u
    public Type k() {
        z2.a aVar = this.f25839b;
        if (aVar != null) {
            return (Type) aVar.invoke();
        }
        return null;
    }

    public String toString() {
        return d3.f25708a.l(this.f25838a);
    }

    public final wd.f w(xf.r0 r0Var) {
        xf.r0 type;
        fe.h hVarB = r0Var.N0().b();
        if (!(hVarB instanceof fe.e)) {
            if (hVarB instanceof fe.l1) {
                return new v2(null, (fe.l1) hVarB);
            }
            if (!(hVarB instanceof fe.k1)) {
                return null;
            }
            throw new cd.p("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        Class clsQ = i3.q((fe.e) hVarB);
        if (clsQ == null) {
            return null;
        }
        if (!clsQ.isArray()) {
            if (xf.i2.l(r0Var)) {
                return new w0(clsQ);
            }
            Class clsI = le.f.i(clsQ);
            if (clsI != null) {
                clsQ = clsI;
            }
            return new w0(clsQ);
        }
        xf.a2 a2Var = (xf.a2) dd.a0.x0(r0Var.L0());
        if (a2Var == null || (type = a2Var.getType()) == null) {
            return new w0(clsQ);
        }
        wd.f fVarW = w(type);
        if (fVarW != null) {
            return new w0(i3.f(od.a.b(yd.b.a(fVarW))));
        }
        throw new x2("Cannot determine classifier for array element type: " + this);
    }

    public final xf.r0 x() {
        return this.f25838a;
    }

    public /* synthetic */ t2(xf.r0 r0Var, Function0 function0, int i10, kotlin.jvm.internal.k kVar) {
        this(r0Var, (i10 & 2) != 0 ? null : function0);
    }
}
