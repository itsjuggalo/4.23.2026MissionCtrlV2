package yf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import xf.c1;
import xf.g1;
import xf.l0;
import xf.l2;
import xf.q0;
import xf.q1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f25434a = new z();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25435a = new c("START", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f25436b = new C0475a("ACCEPT_NULL", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f25437c = new d("UNKNOWN", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f25438d = new b("NOT_NULL", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f25439e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ jd.a f25440f;

        /* JADX INFO: renamed from: yf.z$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0475a extends a {
            public C0475a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // yf.z.a
            public a b(l2 nextType) {
                kotlin.jvm.internal.t.f(nextType, "nextType");
                return c(nextType);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends a {
            public b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // yf.z.a
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public b b(l2 nextType) {
                kotlin.jvm.internal.t.f(nextType, "nextType");
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends a {
            public c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // yf.z.a
            public a b(l2 nextType) {
                kotlin.jvm.internal.t.f(nextType, "nextType");
                return c(nextType);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class d extends a {
            public d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // yf.z.a
            public a b(l2 nextType) {
                kotlin.jvm.internal.t.f(nextType, "nextType");
                a aVarC = c(nextType);
                return aVarC == a.f25436b ? this : aVarC;
            }
        }

        static {
            a[] aVarArrA = a();
            f25439e = aVarArrA;
            f25440f = jd.b.a(aVarArrA);
        }

        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.k kVar) {
            this(str, i10);
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f25435a, f25436b, f25437c, f25438d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f25439e.clone();
        }

        public abstract a b(l2 l2Var);

        public final a c(l2 l2Var) {
            kotlin.jvm.internal.t.f(l2Var, "<this>");
            if (l2Var.O0()) {
                return f25436b;
            }
            if (l2Var instanceof xf.y) {
                ((xf.y) l2Var).Z0();
            }
            return r.f25428a.a(l2Var) ? f25438d : f25437c;
        }

        public a(String str, int i10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.o {
        public b(Object obj) {
            super(2, obj, z.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(r0 p02, r0 p12) {
            kotlin.jvm.internal.t.f(p02, "p0");
            kotlin.jvm.internal.t.f(p12, "p1");
            return Boolean.valueOf(((z) this.receiver).g(p02, p12));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class c extends kotlin.jvm.internal.q implements pd.o {
        public c(Object obj) {
            super(2, obj, q.class, "equalTypes", "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(r0 p02, r0 p12) {
            kotlin.jvm.internal.t.f(p02, "p0");
            kotlin.jvm.internal.t.f(p12, "p1");
            return Boolean.valueOf(((q) this.receiver).b(p02, p12));
        }
    }

    public static final String f(Set set) {
        return "This collections cannot be empty! input types: " + dd.a0.i0(set, null, null, null, 0, null, null, 63, null);
    }

    public final Collection c(Collection collection, pd.o oVar) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.t.e(it, "iterator(...)");
        while (it.hasNext()) {
            c1 c1Var = (c1) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c1 c1Var2 = (c1) it2.next();
                    if (c1Var2 != c1Var) {
                        kotlin.jvm.internal.t.c(c1Var2);
                        kotlin.jvm.internal.t.c(c1Var);
                        if (((Boolean) oVar.invoke(c1Var2, c1Var)).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final c1 d(List types) {
        kotlin.jvm.internal.t.f(types, "types");
        types.size();
        ArrayList<c1> arrayList = new ArrayList();
        Iterator it = types.iterator();
        while (it.hasNext()) {
            c1 c1Var = (c1) it.next();
            if (c1Var.N0() instanceof q0) {
                Collection<r0> collectionC = c1Var.N0().c();
                kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
                ArrayList arrayList2 = new ArrayList(dd.s.u(collectionC, 10));
                for (r0 r0Var : collectionC) {
                    kotlin.jvm.internal.t.c(r0Var);
                    c1 c1VarD = l0.d(r0Var);
                    if (c1Var.O0()) {
                        c1VarD = c1VarD.R0(true);
                    }
                    arrayList2.add(c1VarD);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(c1Var);
            }
        }
        a aVarB = a.f25435a;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVarB = aVarB.b((l2) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (c1 c1VarI : arrayList) {
            if (aVarB == a.f25438d) {
                if (c1VarI instanceof i) {
                    c1VarI = g1.k((i) c1VarI);
                }
                c1VarI = g1.i(c1VarI, false, 1, null);
            }
            linkedHashSet.add(c1VarI);
        }
        ArrayList arrayList3 = new ArrayList(dd.s.u(types, 10));
        Iterator it3 = types.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((c1) it3.next()).M0());
        }
        Iterator it4 = arrayList3.iterator();
        if (!it4.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it4.next();
        while (it4.hasNext()) {
            next = ((q1) next).s((q1) it4.next());
        }
        return e(linkedHashSet).T0((q1) next);
    }

    public final c1 e(Set set) {
        if (set.size() == 1) {
            return (c1) dd.a0.u0(set);
        }
        new y(set);
        Collection collectionC = c(set, new b(this));
        collectionC.isEmpty();
        c1 c1VarB = lf.q.f15663f.b(collectionC);
        if (c1VarB != null) {
            return c1VarB;
        }
        Collection collectionC2 = c(collectionC, new c(p.f25422b.a()));
        collectionC2.isEmpty();
        return collectionC2.size() < 2 ? (c1) dd.a0.u0(collectionC2) : new q0(set).j();
    }

    public final boolean g(r0 r0Var, r0 r0Var2) {
        q qVarA = p.f25422b.a();
        return qVarA.c(r0Var, r0Var2) && !qVarA.c(r0Var2, r0Var);
    }
}
