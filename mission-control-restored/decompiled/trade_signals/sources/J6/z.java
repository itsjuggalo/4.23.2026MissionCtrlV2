package J6;

import I6.AbstractC0613d0;
import I6.AbstractC0621h0;
import I6.C0644y;
import I6.L;
import I6.M0;
import I6.Q;
import I6.S;
import I6.r0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f4675a = new z();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4676a = new c("START", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4677b = new C0064a("ACCEPT_NULL", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4678c = new d("UNKNOWN", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4679d = new b("NOT_NULL", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f4680e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f4681f;

        /* JADX INFO: renamed from: J6.z$a$a, reason: collision with other inner class name */
        public static final class C0064a extends a {
            public C0064a(String str, int i8) {
                super(str, i8, null);
            }

            @Override // J6.z.a
            public a b(M0 nextType) {
                AbstractC2304t.f(nextType, "nextType");
                return g(nextType);
            }
        }

        public static final class b extends a {
            public b(String str, int i8) {
                super(str, i8, null);
            }

            @Override // J6.z.a
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public b b(M0 nextType) {
                AbstractC2304t.f(nextType, "nextType");
                return this;
            }
        }

        public static final class c extends a {
            public c(String str, int i8) {
                super(str, i8, null);
            }

            @Override // J6.z.a
            public a b(M0 nextType) {
                AbstractC2304t.f(nextType, "nextType");
                return g(nextType);
            }
        }

        public static final class d extends a {
            public d(String str, int i8) {
                super(str, i8, null);
            }

            @Override // J6.z.a
            public a b(M0 nextType) {
                AbstractC2304t.f(nextType, "nextType");
                a aVarG = g(nextType);
                return aVarG == a.f4677b ? this : aVarG;
            }
        }

        static {
            a[] aVarArrA = a();
            f4680e = aVarArrA;
            f4681f = AbstractC2875b.a(aVarArrA);
        }

        public a(String str, int i8) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f4676a, f4677b, f4678c, f4679d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f4680e.clone();
        }

        public abstract a b(M0 m02);

        public final a g(M0 m02) {
            AbstractC2304t.f(m02, "<this>");
            if (m02.P0()) {
                return f4677b;
            }
            if (m02 instanceof C0644y) {
                ((C0644y) m02).a1();
            }
            return r.f4669a.a(m02) ? f4679d : f4678c;
        }

        public /* synthetic */ a(String str, int i8, AbstractC2296k abstractC2296k) {
            this(str, i8);
        }
    }

    public /* synthetic */ class b extends AbstractC2302q implements B5.o {
        public b(Object obj) {
            super(2, obj, z.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(S p02, S p12) {
            AbstractC2304t.f(p02, "p0");
            AbstractC2304t.f(p12, "p1");
            return Boolean.valueOf(((z) this.receiver).g(p02, p12));
        }
    }

    public /* synthetic */ class c extends AbstractC2302q implements B5.o {
        public c(Object obj) {
            super(2, obj, q.class, "equalTypes", "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(S p02, S p12) {
            AbstractC2304t.f(p02, "p0");
            AbstractC2304t.f(p12, "p1");
            return Boolean.valueOf(((q) this.receiver).c(p02, p12));
        }
    }

    public static final String f(Set set) {
        return "This collections cannot be empty! input types: " + p5.z.h0(set, null, null, null, 0, null, null, 63, null);
    }

    public final Collection c(Collection collection, B5.o oVar) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        AbstractC2304t.e(it, "iterator(...)");
        while (it.hasNext()) {
            AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    AbstractC0613d0 abstractC0613d02 = (AbstractC0613d0) it2.next();
                    if (abstractC0613d02 != abstractC0613d0) {
                        AbstractC2304t.c(abstractC0613d02);
                        AbstractC2304t.c(abstractC0613d0);
                        if (((Boolean) oVar.invoke(abstractC0613d02, abstractC0613d0)).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final AbstractC0613d0 d(List types) {
        AbstractC2304t.f(types, "types");
        types.size();
        ArrayList<AbstractC0613d0> arrayList = new ArrayList();
        Iterator it = types.iterator();
        while (it.hasNext()) {
            AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) it.next();
            if (abstractC0613d0.O0() instanceof Q) {
                Collection<S> collectionR = abstractC0613d0.O0().r();
                AbstractC2304t.e(collectionR, "getSupertypes(...)");
                ArrayList arrayList2 = new ArrayList(p5.r.s(collectionR, 10));
                for (S s8 : collectionR) {
                    AbstractC2304t.c(s8);
                    AbstractC0613d0 abstractC0613d0D = L.d(s8);
                    if (abstractC0613d0.P0()) {
                        abstractC0613d0D = abstractC0613d0D.S0(true);
                    }
                    arrayList2.add(abstractC0613d0D);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(abstractC0613d0);
            }
        }
        a aVarB = a.f4676a;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVarB = aVarB.b((M0) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AbstractC0613d0 abstractC0613d0I : arrayList) {
            if (aVarB == a.f4679d) {
                if (abstractC0613d0I instanceof i) {
                    abstractC0613d0I = AbstractC0621h0.k((i) abstractC0613d0I);
                }
                abstractC0613d0I = AbstractC0621h0.i(abstractC0613d0I, false, 1, null);
            }
            linkedHashSet.add(abstractC0613d0I);
        }
        ArrayList arrayList3 = new ArrayList(p5.r.s(types, 10));
        Iterator it3 = types.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((AbstractC0613d0) it3.next()).N0());
        }
        Iterator it4 = arrayList3.iterator();
        if (!it4.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it4.next();
        while (it4.hasNext()) {
            next = ((r0) next).H((r0) it4.next());
        }
        return e(linkedHashSet).U0((r0) next);
    }

    public final AbstractC0613d0 e(Set set) {
        if (set.size() == 1) {
            return (AbstractC0613d0) p5.z.t0(set);
        }
        new y(set);
        Collection collectionC = c(set, new b(this));
        collectionC.isEmpty();
        AbstractC0613d0 abstractC0613d0B = w6.q.f24086f.b(collectionC);
        if (abstractC0613d0B != null) {
            return abstractC0613d0B;
        }
        Collection collectionC2 = c(collectionC, new c(p.f4663b.a()));
        collectionC2.isEmpty();
        return collectionC2.size() < 2 ? (AbstractC0613d0) p5.z.t0(collectionC2) : new Q(set).g();
    }

    public final boolean g(S s8, S s9) {
        q qVarA = p.f4663b.a();
        return qVarA.b(s8, s9) && !qVarA.b(s9, s8);
    }
}
