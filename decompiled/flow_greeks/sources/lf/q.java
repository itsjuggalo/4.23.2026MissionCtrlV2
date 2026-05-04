package lf;

import fe.h0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import xf.c1;
import xf.c2;
import xf.e2;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements u1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f15663f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f15665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f15666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c1 f15667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f15668e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: renamed from: lf.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class EnumC0280a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0280a f15669a = new EnumC0280a("COMMON_SUPER_TYPE", 0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0280a f15670b = new EnumC0280a("INTERSECTION_TYPE", 1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final /* synthetic */ EnumC0280a[] f15671c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final /* synthetic */ jd.a f15672d;

            static {
                EnumC0280a[] enumC0280aArrA = a();
                f15671c = enumC0280aArrA;
                f15672d = jd.b.a(enumC0280aArrA);
            }

            public EnumC0280a(String str, int i10) {
            }

            public static final /* synthetic */ EnumC0280a[] a() {
                return new EnumC0280a[]{f15669a, f15670b};
            }

            public static EnumC0280a valueOf(String str) {
                return (EnumC0280a) Enum.valueOf(EnumC0280a.class, str);
            }

            public static EnumC0280a[] values() {
                return (EnumC0280a[]) f15671c.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15673a;

            static {
                int[] iArr = new int[EnumC0280a.values().length];
                try {
                    iArr[EnumC0280a.f15669a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC0280a.f15670b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f15673a = iArr;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c1 a(Collection collection, EnumC0280a enumC0280a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                c1 c1Var = (c1) it.next();
                next = q.f15663f.e((c1) next, c1Var, enumC0280a);
            }
            return (c1) next;
        }

        public final c1 b(Collection types) {
            kotlin.jvm.internal.t.f(types, "types");
            return a(types, EnumC0280a.f15670b);
        }

        public final c1 c(q qVar, q qVar2, EnumC0280a enumC0280a) {
            Set setE0;
            int i10 = b.f15673a[enumC0280a.ordinal()];
            if (i10 == 1) {
                setE0 = dd.a0.e0(qVar.j(), qVar2.j());
            } else {
                if (i10 != 2) {
                    throw new cd.o();
                }
                setE0 = dd.a0.O0(qVar.j(), qVar2.j());
            }
            return u0.f(q1.f25042b.k(), new q(qVar.f15664a, qVar.f15665b, setE0, null), false);
        }

        public final c1 d(q qVar, c1 c1Var) {
            if (qVar.j().contains(c1Var)) {
                return c1Var;
            }
            return null;
        }

        public final c1 e(c1 c1Var, c1 c1Var2, EnumC0280a enumC0280a) {
            if (c1Var != null && c1Var2 != null) {
                u1 u1VarN0 = c1Var.N0();
                u1 u1VarN02 = c1Var2.N0();
                boolean z10 = u1VarN0 instanceof q;
                if (z10 && (u1VarN02 instanceof q)) {
                    return c((q) u1VarN0, (q) u1VarN02, enumC0280a);
                }
                if (z10) {
                    return d((q) u1VarN0, c1Var2);
                }
                if (u1VarN02 instanceof q) {
                    return d((q) u1VarN02, c1Var);
                }
            }
            return null;
        }

        public a() {
        }
    }

    public /* synthetic */ q(long j10, h0 h0Var, Set set, kotlin.jvm.internal.k kVar) {
        this(j10, h0Var, set);
    }

    private final List k() {
        return (List) this.f15668e.getValue();
    }

    public static final List m(q qVar) {
        c1 c1VarS = qVar.p().y().s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        List listQ = dd.r.q(e2.f(c1VarS, dd.q.e(new c2(m2.f25016f, qVar.f15667d)), null, 2, null));
        if (!qVar.l()) {
            listQ.add(qVar.p().M());
        }
        return listQ;
    }

    public static final CharSequence o(r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.toString();
    }

    @Override // xf.u1
    public u1 a(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // xf.u1
    public fe.h b() {
        return null;
    }

    @Override // xf.u1
    public Collection c() {
        return k();
    }

    @Override // xf.u1
    public boolean d() {
        return false;
    }

    @Override // xf.u1
    public List getParameters() {
        return dd.r.k();
    }

    public final Set j() {
        return this.f15666c;
    }

    public final boolean l() {
        Collection collectionA = v.a(this.f15665b);
        if (collectionA != null && collectionA.isEmpty()) {
            return true;
        }
        Iterator it = collectionA.iterator();
        while (it.hasNext()) {
            if (this.f15666c.contains((r0) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String n() {
        return '[' + dd.a0.i0(this.f15666c, com.amazon.a.a.o.b.f.f4598a, null, null, 0, null, p.f15662a, 30, null) + ']';
    }

    @Override // xf.u1
    public ce.i p() {
        return this.f15665b.p();
    }

    public String toString() {
        return "IntegerLiteralType" + n();
    }

    public q(long j10, h0 h0Var, Set set) {
        this.f15667d = u0.f(q1.f25042b.k(), this, false);
        this.f15668e = cd.l.b(new o(this));
        this.f15664a = j10;
        this.f15665b = h0Var;
        this.f15666c = set;
    }
}
