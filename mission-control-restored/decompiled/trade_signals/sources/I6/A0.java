package I6;

import I6.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2489q;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public final class A0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f4323f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.f f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2483k f4327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.g f4328e;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01cf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final I6.S a(I6.S r17, I6.G0 r18, java.util.Set r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 500
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: I6.A0.a.a(I6.S, I6.G0, java.util.Set, boolean):I6.S");
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R5.m0 f4329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final G f4330b;

        public b(R5.m0 typeParameter, G typeAttr) {
            AbstractC2304t.f(typeParameter, "typeParameter");
            AbstractC2304t.f(typeAttr, "typeAttr");
            this.f4329a = typeParameter;
            this.f4330b = typeAttr;
        }

        public final G a() {
            return this.f4330b;
        }

        public final R5.m0 b() {
            return this.f4329a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC2304t.b(bVar.f4329a, this.f4329a) && AbstractC2304t.b(bVar.f4330b, this.f4330b);
        }

        public int hashCode() {
            int iHashCode = this.f4329a.hashCode();
            return iHashCode + (iHashCode * 31) + this.f4330b.hashCode();
        }

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f4329a + ", typeAttr=" + this.f4330b + ')';
        }
    }

    public A0(F projectionComputer, x0 options) {
        AbstractC2304t.f(projectionComputer, "projectionComputer");
        AbstractC2304t.f(options, "options");
        this.f4324a = projectionComputer;
        this.f4325b = options;
        H6.f fVar = new H6.f("Type parameter upper bound erasure results");
        this.f4326c = fVar;
        this.f4327d = AbstractC2484l.a(new y0(this));
        H6.g gVarG = fVar.g(new z0(this));
        AbstractC2304t.e(gVarG, "createMemoizedFunction(...)");
        this.f4328e = gVarG;
    }

    public static final K6.i c(A0 a02) {
        return K6.l.d(K6.k.f4830C0, a02.toString());
    }

    public static final S f(A0 a02, b bVar) {
        return a02.g(bVar.b(), bVar.a());
    }

    public final S d(G g8) {
        S sD;
        AbstractC0613d0 abstractC0613d0A = g8.a();
        return (abstractC0613d0A == null || (sD = N6.d.D(abstractC0613d0A)) == null) ? h() : sD;
    }

    public final S e(R5.m0 typeParameter, G typeAttr) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        AbstractC2304t.f(typeAttr, "typeAttr");
        Object objInvoke = this.f4328e.invoke(new b(typeParameter, typeAttr));
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (S) objInvoke;
    }

    public final S g(R5.m0 m0Var, G g8) {
        B0 b0A;
        Set setC = g8.c();
        if (setC != null && setC.contains(m0Var.a())) {
            return d(g8);
        }
        AbstractC0613d0 abstractC0613d0T = m0Var.t();
        AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
        Set<R5.m0> setL = N6.d.l(abstractC0613d0T, setC);
        LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(p5.L.d(p5.r.s(setL, 10)), 16));
        for (R5.m0 m0Var2 : setL) {
            if (setC == null || !setC.contains(m0Var2)) {
                b0A = this.f4324a.a(m0Var2, g8, this, e(m0Var2, g8.d(m0Var)));
            } else {
                b0A = J0.t(m0Var2, g8);
                AbstractC2304t.e(b0A, "makeStarProjection(...)");
            }
            C2489q c2489qA = o5.w.a(m0Var2.l(), b0A);
            linkedHashMap.put(c2489qA.c(), c2489qA.d());
        }
        G0 g0G = G0.g(w0.a.e(w0.f4488c, linkedHashMap, false, 2, null));
        AbstractC2304t.e(g0G, "create(...)");
        List upperBounds = m0Var.getUpperBounds();
        AbstractC2304t.e(upperBounds, "getUpperBounds(...)");
        Set setI = i(g0G, upperBounds, g8);
        if (!(!setI.isEmpty())) {
            return d(g8);
        }
        if (!this.f4325b.a()) {
            if (setI.size() == 1) {
                return (S) p5.z.t0(setI);
            }
            throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds".toString());
        }
        List listG0 = p5.z.G0(setI);
        ArrayList arrayList = new ArrayList(p5.r.s(listG0, 10));
        Iterator it = listG0.iterator();
        while (it.hasNext()) {
            arrayList.add(((S) it.next()).R0());
        }
        return J6.d.a(arrayList);
    }

    public final K6.i h() {
        return (K6.i) this.f4327d.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[EDGE_INSN: B:22:0x0064->B:19:0x0064 BREAK  A[LOOP:0: B:3:0x0008->B:23:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[LOOP:0: B:3:0x0008->B:23:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Set i(I6.G0 r6, java.util.List r7, I6.G r8) {
        /*
            r5 = this;
            java.util.Set r0 = p5.Q.b()
            java.util.Iterator r7 = r7.iterator()
        L8:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L64
            java.lang.Object r1 = r7.next()
            I6.S r1 = (I6.S) r1
            I6.v0 r2 = r1.O0()
            R5.h r2 = r2.s()
            boolean r3 = r2 instanceof R5.InterfaceC0848e
            if (r3 == 0) goto L34
            I6.A0$a r2 = I6.A0.f4323f
            java.util.Set r3 = r8.c()
            I6.x0 r4 = r5.f4325b
            boolean r4 = r4.b()
            I6.S r1 = r2.a(r1, r6, r3, r4)
        L30:
            r0.add(r1)
            goto L5c
        L34:
            boolean r1 = r2 instanceof R5.m0
            if (r1 == 0) goto L5c
            java.util.Set r1 = r8.c()
            if (r1 == 0) goto L4a
            boolean r1 = r1.contains(r2)
            r3 = 1
            if (r1 != r3) goto L4a
            I6.S r1 = r5.d(r8)
            goto L30
        L4a:
            R5.m0 r2 = (R5.m0) r2
            java.util.List r1 = r2.getUpperBounds()
            java.lang.String r2 = "getUpperBounds(...)"
            kotlin.jvm.internal.AbstractC2304t.e(r1, r2)
            java.util.Set r1 = r5.i(r6, r1, r8)
            r0.addAll(r1)
        L5c:
            I6.x0 r1 = r5.f4325b
            boolean r1 = r1.a()
            if (r1 != 0) goto L8
        L64:
            java.util.Set r6 = p5.Q.a(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: I6.A0.i(I6.G0, java.util.List, I6.G):java.util.Set");
    }

    public /* synthetic */ A0(F f8, x0 x0Var, int i8, AbstractC2296k abstractC2296k) {
        this(f8, (i8 & 2) != 0 ? new x0(false, false) : x0Var);
    }
}
