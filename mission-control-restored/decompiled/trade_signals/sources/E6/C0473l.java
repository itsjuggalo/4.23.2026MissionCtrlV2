package E6;

import G6.C0576m;
import O5.o;
import R5.InterfaceC0848e;
import R5.h0;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n6.AbstractC2427a;
import n6.InterfaceC2429c;
import n6.h;

/* JADX INFO: renamed from: E6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0473l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f992c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f993d = p5.Q.c(q6.b.f22655d.c(o.a.f6168d.m()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0475n f994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f995b;

    /* JADX INFO: renamed from: E6.l$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q6.b f996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0470i f997b;

        public a(q6.b classId, C0470i c0470i) {
            AbstractC2304t.f(classId, "classId");
            this.f996a = classId;
            this.f997b = c0470i;
        }

        public final C0470i a() {
            return this.f997b;
        }

        public final q6.b b() {
            return this.f996a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC2304t.b(this.f996a, ((a) obj).f996a);
        }

        public int hashCode() {
            return this.f996a.hashCode();
        }
    }

    /* JADX INFO: renamed from: E6.l$b */
    public static final class b {
        public b() {
        }

        public final Set a() {
            return C0473l.f993d;
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C0473l(C0475n components) {
        AbstractC2304t.f(components, "components");
        this.f994a = components;
        this.f995b = components.u().d(new C0472k(this));
    }

    public static final InterfaceC0848e c(C0473l c0473l, a key) {
        AbstractC2304t.f(key, "key");
        return c0473l.d(key);
    }

    public static /* synthetic */ InterfaceC0848e f(C0473l c0473l, q6.b bVar, C0470i c0470i, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c0470i = null;
        }
        return c0473l.e(bVar, c0470i);
    }

    public final InterfaceC0848e d(a aVar) {
        Object next;
        C0477p c0477pA;
        q6.b bVarB = aVar.b();
        Iterator it = this.f994a.l().iterator();
        while (it.hasNext()) {
            InterfaceC0848e interfaceC0848eA = ((T5.b) it.next()).a(bVarB);
            if (interfaceC0848eA != null) {
                return interfaceC0848eA;
            }
        }
        if (f993d.contains(bVarB)) {
            return null;
        }
        C0470i c0470iA = aVar.a();
        if (c0470iA == null && (c0470iA = this.f994a.e().a(bVarB)) == null) {
            return null;
        }
        InterfaceC2429c interfaceC2429cA = c0470iA.a();
        l6.c cVarB = c0470iA.b();
        AbstractC2427a abstractC2427aC = c0470iA.c();
        h0 h0VarD = c0470iA.d();
        q6.b bVarE = bVarB.e();
        if (bVarE != null) {
            InterfaceC0848e interfaceC0848eF = f(this, bVarE, null, 2, null);
            C0576m c0576m = interfaceC0848eF instanceof C0576m ? (C0576m) interfaceC0848eF : null;
            if (c0576m == null || !c0576m.l1(bVarB.h())) {
                return null;
            }
            c0477pA = c0576m.e1();
        } else {
            Iterator it2 = R5.T.c(this.f994a.s(), bVarB.f()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                R5.N n8 = (R5.N) next;
                if (!(n8 instanceof r) || ((r) n8).L0(bVarB.h())) {
                    break;
                }
            }
            R5.N n9 = (R5.N) next;
            if (n9 == null) {
                return null;
            }
            C0475n c0475n = this.f994a;
            l6.t tVarI1 = cVarB.i1();
            AbstractC2304t.e(tVarI1, "getTypeTable(...)");
            n6.g gVar = new n6.g(tVarI1);
            h.a aVar2 = n6.h.f21675b;
            l6.w wVarK1 = cVarB.k1();
            AbstractC2304t.e(wVarK1, "getVersionRequirementTable(...)");
            c0477pA = c0475n.a(n9, interfaceC2429cA, gVar, aVar2.a(wVarK1), abstractC2427aC, null);
        }
        return new C0576m(c0477pA, cVarB, interfaceC2429cA, abstractC2427aC, h0VarD);
    }

    public final InterfaceC0848e e(q6.b classId, C0470i c0470i) {
        AbstractC2304t.f(classId, "classId");
        return (InterfaceC0848e) this.f995b.invoke(new a(classId, c0470i));
    }
}
