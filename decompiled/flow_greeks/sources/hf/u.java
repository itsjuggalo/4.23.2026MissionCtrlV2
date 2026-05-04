package hf;

import cd.h0;
import ce.o;
import dd.v0;
import fe.a1;
import fe.b;
import fe.b1;
import fe.k1;
import fe.l1;
import fe.m0;
import fe.n0;
import fe.p1;
import fe.s1;
import fe.t1;
import fe.u0;
import fe.w0;
import fe.x0;
import fe.y0;
import fe.z0;
import hf.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lf.s;
import xf.a2;
import xf.c1;
import xf.g1;
import xf.i0;
import xf.i2;
import xf.l2;
import xf.m2;
import xf.n2;
import xf.q0;
import xf.r0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends n implements w {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z f11367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final cd.k f11368n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements fe.o {

        /* JADX INFO: renamed from: hf.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class C0211a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11370a;

            static {
                int[] iArr = new int[e0.values().length];
                try {
                    iArr[e0.f11330a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[e0.f11331b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[e0.f11332c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f11370a = iArr;
            }
        }

        public a() {
        }

        public void A(s1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.B2(descriptor, true, builder, true);
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object a(s1 s1Var, Object obj) {
            A(s1Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object b(b1 b1Var, Object obj) {
            x(b1Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object c(a1 a1Var, Object obj) throws IOException {
            w(a1Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object d(fe.z zVar, Object obj) throws IOException {
            p(zVar, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object e(n0 n0Var, Object obj) {
            r(n0Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object f(y0 y0Var, Object obj) throws IOException {
            u(y0Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object g(k1 k1Var, Object obj) {
            y(k1Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object h(fe.e eVar, Object obj) throws IOException {
            n(eVar, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object i(l1 l1Var, Object obj) {
            z(l1Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object j(u0 u0Var, Object obj) {
            s(u0Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object k(z0 z0Var, Object obj) throws IOException {
            v(z0Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object l(fe.l lVar, Object obj) throws IOException {
            o(lVar, (StringBuilder) obj);
            return h0.f3852a;
        }

        @Override // fe.o
        public /* bridge */ /* synthetic */ Object m(fe.h0 h0Var, Object obj) {
            q(h0Var, (StringBuilder) obj);
            return h0.f3852a;
        }

        public void n(fe.e descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.C1(descriptor, builder);
        }

        public void o(fe.l constructorDescriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(constructorDescriptor, "constructorDescriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.H1(constructorDescriptor, builder);
        }

        public void p(fe.z descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.P1(descriptor, builder);
        }

        public void q(fe.h0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.Z1(descriptor, builder, true);
        }

        public void r(n0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.d2(descriptor, builder);
        }

        public void s(u0 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.f2(descriptor, builder);
        }

        public final void t(x0 x0Var, StringBuilder sb2, String str) throws IOException {
            int i10 = C0211a.f11370a[u.this.P0().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    p(x0Var, sb2);
                    return;
                } else {
                    if (i10 != 3) {
                        throw new cd.o();
                    }
                    return;
                }
            }
            u.this.w1(x0Var, sb2);
            sb2.append(str + " for ");
            u uVar = u.this;
            y0 y0VarB0 = x0Var.B0();
            kotlin.jvm.internal.t.e(y0VarB0, "getCorrespondingProperty(...)");
            uVar.h2(y0VarB0, sb2);
        }

        public void u(y0 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.h2(descriptor, builder);
        }

        public void v(z0 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            t(descriptor, builder, "getter");
        }

        public void w(a1 descriptor, StringBuilder builder) throws IOException {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            t(descriptor, builder, "setter");
        }

        public void x(b1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            builder.append(descriptor.getName());
        }

        public void y(k1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.q2(descriptor, builder);
        }

        public void z(l1 descriptor, StringBuilder builder) {
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(builder, "builder");
            u.this.w2(descriptor, builder, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11372b;

        static {
            int[] iArr = new int[f0.values().length];
            try {
                iArr[f0.f11336a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[f0.f11337b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f11371a = iArr;
            int[] iArr2 = new int[d0.values().length];
            try {
                iArr2[d0.f11324a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[d0.f11325b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[d0.f11326c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f11372b = iArr2;
        }
    }

    public u(z options) {
        kotlin.jvm.internal.t.f(options, "options");
        this.f11367m = options;
        options.p0();
        this.f11368n = cd.l.b(new o(this));
    }

    public static /* synthetic */ void A1(u uVar, StringBuilder sb2, ge.a aVar, ge.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            eVar = null;
        }
        uVar.z1(sb2, aVar, eVar);
    }

    public static /* synthetic */ void A2(u uVar, t1 t1Var, StringBuilder sb2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        uVar.z2(t1Var, sb2, z10);
    }

    public static final CharSequence I1(s1 s1Var) {
        return "";
    }

    public static final CharSequence o0(u uVar, a2 it) {
        kotlin.jvm.internal.t.f(it, "it");
        if (it.c()) {
            return "*";
        }
        r0 type = it.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        String strS = uVar.S(type);
        if (it.b() == m2.f25015e) {
            return strS;
        }
        return it.b() + ' ' + strS;
    }

    public static final CharSequence o2(u uVar, r0 r0Var) {
        kotlin.jvm.internal.t.c(r0Var);
        return uVar.S(r0Var);
    }

    public static final u r0(u uVar) {
        n nVarU = uVar.U(t.f11366a);
        kotlin.jvm.internal.t.d(nVarU, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (u) nVarU;
    }

    public static final h0 s0(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.a(v0.l(withOptions.m(), dd.r.n(o.a.C, o.a.D)));
        return h0.f3852a;
    }

    public static final Object t2(r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it;
    }

    public static /* synthetic */ void v2(u uVar, StringBuilder sb2, r0 r0Var, u1 u1Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            u1Var = r0Var.N0();
        }
        uVar.u2(sb2, r0Var, u1Var);
    }

    public boolean A0() {
        return this.f11367m.B();
    }

    public Set B0() {
        return this.f11367m.C();
    }

    public final void B1(fe.i iVar, StringBuilder sb2) {
        List listV = iVar.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        List parameters = iVar.k().getParameters();
        kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
        if (j1() && iVar.P() && parameters.size() > listV.size()) {
            sb2.append(" /*captured type parameters: ");
            x2(sb2, parameters.subList(listV.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B2(fe.s1 r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
            r8 = this;
            if (r12 == 0) goto L10
            java.lang.String r2 = "value-parameter"
            java.lang.String r2 = r8.S1(r2)
            r11.append(r2)
            java.lang.String r2 = " "
            r11.append(r2)
        L10:
            boolean r2 = r8.j1()
            if (r2 == 0) goto L27
            java.lang.String r2 = "/*"
            r11.append(r2)
            int r2 = r9.getIndex()
            r11.append(r2)
        */
        //  java.lang.String r2 = "*/ "
        /*
            r11.append(r2)
        L27:
            r4 = 2
            r5 = 0
            r3 = 0
            r0 = r8
            r2 = r9
            r1 = r11
            A1(r0, r1, r2, r3, r4, r5)
            boolean r2 = r9.b0()
            java.lang.String r3 = "crossinline"
            r8.Y1(r11, r2, r3)
            boolean r2 = r9.Z()
            java.lang.String r3 = "noinline"
            r8.Y1(r11, r2, r3)
            boolean r2 = r8.Y0()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L60
            fe.a r2 = r9.b()
            boolean r3 = r2 instanceof fe.d
            if (r3 == 0) goto L55
            fe.d r2 = (fe.d) r2
            goto L56
        L55:
            r2 = 0
        L56:
            if (r2 == 0) goto L60
            boolean r2 = r2.C()
            if (r2 != r7) goto L60
            r5 = r7
            goto L61
        L60:
            r5 = r6
        L61:
            if (r5 == 0) goto L6c
            boolean r2 = r8.t0()
            java.lang.String r3 = "actual"
            r8.Y1(r11, r2, r3)
        L6c:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.D2(r1, r2, r3, r4, r5)
            pd.k r0 = r8.z0()
            if (r0 == 0) goto L8c
            boolean r0 = r8.n()
            if (r0 == 0) goto L85
            boolean r0 = r9.s0()
            goto L89
        L85:
            boolean r0 = nf.e.f(r9)
        L89:
            if (r0 == 0) goto L8c
            r6 = r7
        L8c:
            if (r6 == 0) goto Laf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = " = "
            r0.append(r2)
            pd.k r2 = r8.z0()
            kotlin.jvm.internal.t.c(r2)
            java.lang.Object r2 = r2.invoke(r9)
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r11.append(r0)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.u.B2(fe.s1, boolean, java.lang.StringBuilder, boolean):void");
    }

    public final u C0() {
        return (u) this.f11368n.getValue();
    }

    public final void C1(fe.e eVar, StringBuilder sb2) throws IOException {
        fe.d dVarS;
        boolean z10 = eVar.h() == fe.f.f9476e;
        if (!d1()) {
            List listG0 = eVar.G0();
            kotlin.jvm.internal.t.e(listG0, "getContextReceivers(...)");
            J1(listG0, sb2);
            A1(this, sb2, eVar, null, 2, null);
            if (!z10) {
                fe.u visibility = eVar.getVisibility();
                kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
                E2(visibility, sb2);
            }
            if ((eVar.h() != fe.f.f9474c || eVar.l() != fe.e0.f9464e) && (!eVar.h().b() || eVar.l() != fe.e0.f9461b)) {
                fe.e0 e0VarL = eVar.l();
                kotlin.jvm.internal.t.e(e0VarL, "getModality(...)");
                W1(e0VarL, sb2, r1(eVar));
            }
            U1(eVar, sb2);
            Y1(sb2, I0().contains(v.f11380i) && eVar.P(), "inner");
            Y1(sb2, I0().contains(v.f11382k) && eVar.H0(), "data");
            Y1(sb2, I0().contains(v.f11383l) && eVar.isInline(), "inline");
            Y1(sb2, I0().contains(v.f11389r) && eVar.n(), "value");
            Y1(sb2, I0().contains(v.f11388q) && eVar.E(), "fun");
            D1(eVar, sb2);
        }
        if (jf.i.x(eVar)) {
            F1(eVar, sb2);
        } else {
            if (!d1()) {
                m2(sb2);
            }
            Z1(eVar, sb2, true);
        }
        if (z10) {
            return;
        }
        List listV = eVar.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        y2(listV, sb2, false);
        B1(eVar, sb2);
        if (!eVar.h().b() && x0() && (dVarS = eVar.S()) != null) {
            sb2.append(" ");
            A1(this, sb2, dVarS, null, 2, null);
            fe.u visibility2 = dVarS.getVisibility();
            kotlin.jvm.internal.t.e(visibility2, "getVisibility(...)");
            E2(visibility2, sb2);
            sb2.append(S1("constructor"));
            List listI = dVarS.i();
            kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
            C2(listI, dVarS.H(), sb2);
        }
        n2(eVar, sb2);
        F2(listV, sb2);
    }

    public final void C2(Collection collection, boolean z10, StringBuilder sb2) {
        boolean zH2 = H2(z10);
        int size = collection.size();
        i1().b(size, sb2);
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            i1().a(s1Var, i10, size, sb2);
            B2(s1Var, zH2, sb2, false);
            i1().c(s1Var, i10, size, sb2);
            i10++;
        }
        i1().d(size, sb2);
    }

    public boolean D0() {
        return this.f11367m.D();
    }

    public final void D1(fe.e eVar, StringBuilder sb2) {
        sb2.append(S1(n.f11347a.a(eVar)));
    }

    public final void D2(t1 t1Var, boolean z10, StringBuilder sb2, boolean z11, boolean z12) {
        r0 type = t1Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        s1 s1Var = t1Var instanceof s1 ? (s1) t1Var : null;
        r0 r0VarJ0 = s1Var != null ? s1Var.j0() : null;
        r0 r0Var = r0VarJ0 == null ? type : r0VarJ0;
        Y1(sb2, r0VarJ0 != null, "vararg");
        if (z12 || (z11 && !d1())) {
            z2(t1Var, sb2, z12);
        }
        if (z10) {
            Z1(t1Var, sb2, z11);
            sb2.append(": ");
        }
        sb2.append(S(r0Var));
        R1(t1Var, sb2);
        if (!j1() || r0VarJ0 == null) {
            return;
        }
        sb2.append(" /*");
        sb2.append(S(type));
        sb2.append("*/");
    }

    public boolean E0() {
        return this.f11367m.E();
    }

    public String E1(fe.h klass) {
        kotlin.jvm.internal.t.f(klass, "klass");
        return zf.l.m(klass) ? klass.k().toString() : y0().a(klass, this);
    }

    public final boolean E2(fe.u uVar, StringBuilder sb2) {
        if (!I0().contains(v.f11376e)) {
            return false;
        }
        if (J0()) {
            uVar = uVar.f();
        }
        if (!X0() && kotlin.jvm.internal.t.b(uVar, fe.t.f9518l)) {
            return false;
        }
        sb2.append(S1(uVar.c()));
        sb2.append(" ");
        return true;
    }

    public boolean F0() {
        return this.f11367m.F();
    }

    public final void F1(fe.m mVar, StringBuilder sb2) {
        if (S0()) {
            if (d1()) {
                sb2.append("companion object");
            }
            m2(sb2);
            fe.m mVarB = mVar.b();
            if (mVarB != null) {
                sb2.append("of ");
                ef.f name = mVarB.getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                sb2.append(R(name, false));
            }
        }
        if (j1() || !kotlin.jvm.internal.t.b(mVar.getName(), ef.h.f8803d)) {
            if (!d1()) {
                m2(sb2);
            }
            ef.f name2 = mVar.getName();
            kotlin.jvm.internal.t.e(name2, "getName(...)");
            sb2.append(R(name2, true));
        }
    }

    public final void F2(List list, StringBuilder sb2) throws IOException {
        if (o1()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l1 l1Var = (l1) it.next();
            List upperBounds = l1Var.getUpperBounds();
            kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
            for (r0 r0Var : dd.a0.T(upperBounds, 1)) {
                StringBuilder sb3 = new StringBuilder();
                ef.f name = l1Var.getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                sb3.append(R(name, false));
                sb3.append(" : ");
                kotlin.jvm.internal.t.c(r0Var);
                sb3.append(S(r0Var));
                arrayList.add(sb3.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb2.append(" ");
        sb2.append(S1("where"));
        sb2.append(" ");
        dd.a0.f0(arrayList, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
    }

    public boolean G0() {
        return this.f11367m.G();
    }

    public final String G1(lf.g gVar) {
        pd.k kVarP = this.f11367m.P();
        if (kVarP != null) {
            return (String) kVarP.invoke(gVar);
        }
        if (gVar instanceof lf.b) {
            Iterable iterable = (Iterable) ((lf.b) gVar).b();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                String strG1 = G1((lf.g) it.next());
                if (strG1 != null) {
                    arrayList.add(strG1);
                }
            }
            return dd.a0.i0(arrayList, ", ", "{", "}", 0, null, null, 56, null);
        }
        if (gVar instanceof lf.a) {
            return kg.c0.y0(n.O(this, (ge.c) ((lf.a) gVar).b(), null, 2, null), "@");
        }
        if (!(gVar instanceof lf.s)) {
            return gVar.toString();
        }
        s.b bVar = (s.b) ((lf.s) gVar).b();
        if (bVar instanceof s.b.a) {
            return ((s.b.a) bVar).a() + "::class";
        }
        if (!(bVar instanceof s.b.C0281b)) {
            throw new cd.o();
        }
        s.b.C0281b c0281b = (s.b.C0281b) bVar;
        String strA = c0281b.b().a().a();
        for (int i10 = 0; i10 < c0281b.a(); i10++) {
            strA = "kotlin.Array<" + strA + '>';
        }
        return strA + "::class";
    }

    public final boolean G2(r0 r0Var) {
        if (!ce.h.p(r0Var)) {
            return false;
        }
        List listL0 = r0Var.L0();
        if (listL0 != null && listL0.isEmpty()) {
            return true;
        }
        Iterator it = listL0.iterator();
        while (it.hasNext()) {
            if (((a2) it.next()).c()) {
                return false;
            }
        }
        return true;
    }

    public boolean H0() {
        return this.f11367m.H();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H1(fe.l r18, java.lang.StringBuilder r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.u.H1(fe.l, java.lang.StringBuilder):void");
    }

    public final boolean H2(boolean z10) {
        int i10 = b.f11372b[M0().ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return !z10;
        }
        if (i10 == 3) {
            return false;
        }
        throw new cd.o();
    }

    public Set I0() {
        return this.f11367m.I();
    }

    public boolean J0() {
        return this.f11367m.J();
    }

    public final void J1(List list, StringBuilder sb2) {
        if (list.isEmpty()) {
            return;
        }
        sb2.append("context(");
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int i11 = i10 + 1;
            b1 b1Var = (b1) it.next();
            z1(sb2, b1Var, ge.e.f10544g);
            r0 type = b1Var.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            sb2.append(N1(type));
            if (i10 == dd.r.m(list)) {
                sb2.append(") ");
            } else {
                sb2.append(", ");
            }
            i10 = i11;
        }
    }

    public final z K0() {
        return this.f11367m;
    }

    public final void K1(StringBuilder sb2, r0 r0Var) {
        A1(this, sb2, r0Var, null, 2, null);
        xf.y yVar = r0Var instanceof xf.y ? (xf.y) r0Var : null;
        if (yVar != null) {
            yVar.Z0();
        }
        if (!xf.v0.a(r0Var)) {
            v2(this, sb2, r0Var, null, 2, null);
            h0 h0Var = h0.f3852a;
        } else if (cg.d.z(r0Var) && O0()) {
            sb2.append(L1(zf.l.f26552a.p(r0Var)));
        } else {
            if (!(r0Var instanceof zf.i) || H0()) {
                sb2.append(r0Var.N0().toString());
            } else {
                sb2.append(((zf.i) r0Var).W0());
            }
            sb2.append(r2(r0Var.L0()));
        }
        if (r0Var.O0()) {
            sb2.append("?");
        }
        if (g1.c(r0Var)) {
            sb2.append(" & Any");
        }
    }

    public c0 L0() {
        return this.f11367m.K();
    }

    public final String L1(String str) {
        int i10 = b.f11371a[e1().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            throw new cd.o();
        }
        return "<font color=red><b>" + str + "</b></font>";
    }

    @Override // hf.n
    public String M(fe.m declarationDescriptor) {
        kotlin.jvm.internal.t.f(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        declarationDescriptor.t0(new a(), sb2);
        if (k1()) {
            m0(sb2, declarationDescriptor);
        }
        return sb2.toString();
    }

    public d0 M0() {
        return this.f11367m.L();
    }

    public final void M1(StringBuilder sb2, xf.a aVar) {
        f0 f0VarE1 = e1();
        f0 f0Var = f0.f11337b;
        if (f0VarE1 == f0Var) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* ");
        sb2.append("= ");
        b2(sb2, aVar.X());
        sb2.append(" */");
        if (e1() == f0Var) {
            sb2.append("</i></font>");
        }
    }

    @Override // hf.n
    public String N(ge.c annotation, ge.e eVar) throws IOException {
        kotlin.jvm.internal.t.f(annotation, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (eVar != null) {
            sb2.append(eVar.b() + ':');
        }
        r0 type = annotation.getType();
        sb2.append(S(type));
        if (E0()) {
            List listY1 = y1(annotation);
            if (F0() || !listY1.isEmpty()) {
                dd.a0.f0(listY1, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
            }
        }
        if (j1() && (xf.v0.a(type) || (type.N0().b() instanceof m0.b))) {
            sb2.append(" /* annotation class not found */");
        }
        return sb2.toString();
    }

    public boolean N0() {
        return this.f11367m.M();
    }

    public final String N1(r0 r0Var) {
        String strS = S(r0Var);
        if ((!G2(r0Var) || i2.l(r0Var)) && !(r0Var instanceof xf.y)) {
            return strS;
        }
        return '(' + strS + ')';
    }

    public boolean O0() {
        return this.f11367m.N();
    }

    public final String O1(List list) {
        return q0(g0.c(list));
    }

    @Override // hf.n
    public String P(String lowerRendered, String upperRendered, ce.i builtIns) {
        kotlin.jvm.internal.t.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.t.f(upperRendered, "upperRendered");
        kotlin.jvm.internal.t.f(builtIns, "builtIns");
        if (g0.f(lowerRendered, upperRendered)) {
            if (!kg.z.J(upperRendered, "(", false, 2, null)) {
                return lowerRendered + '!';
            }
            return '(' + lowerRendered + ")!";
        }
        hf.b bVarY0 = y0();
        fe.e eVarX = builtIns.x();
        kotlin.jvm.internal.t.e(eVarX, "getCollection(...)");
        String strX0 = kg.c0.X0(bVarY0.a(eVarX, this), "Collection", null, 2, null);
        String strD = g0.d(lowerRendered, strX0 + "Mutable", upperRendered, strX0, strX0 + "(Mutable)");
        if (strD != null) {
            return strD;
        }
        String strD2 = g0.d(lowerRendered, strX0 + "MutableMap.MutableEntry", upperRendered, strX0 + "Map.Entry", strX0 + "(Mutable)Map.(Mutable)Entry");
        if (strD2 != null) {
            return strD2;
        }
        hf.b bVarY02 = y0();
        fe.e eVarJ = builtIns.j();
        kotlin.jvm.internal.t.e(eVarJ, "getArray(...)");
        String strX02 = kg.c0.X0(bVarY02.a(eVarJ, this), "Array", null, 2, null);
        String strD3 = g0.d(lowerRendered, strX02 + q0("Array<"), upperRendered, strX02 + q0("Array<out "), strX02 + q0("Array<(out) "));
        if (strD3 != null) {
            return strD3;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    public e0 P0() {
        return this.f11367m.O();
    }

    public final void P1(fe.z zVar, StringBuilder sb2) throws IOException {
        fe.z zVar2;
        StringBuilder sb3;
        if (d1()) {
            zVar2 = zVar;
            sb3 = sb2;
        } else {
            if (c1()) {
                zVar2 = zVar;
                sb3 = sb2;
            } else {
                List listP0 = zVar.p0();
                kotlin.jvm.internal.t.e(listP0, "getContextReceiverParameters(...)");
                J1(listP0, sb2);
                zVar2 = zVar;
                sb3 = sb2;
                A1(this, sb3, zVar2, null, 2, null);
                fe.u visibility = zVar2.getVisibility();
                kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
                E2(visibility, sb3);
                X1(zVar2, sb3);
                if (D0()) {
                    U1(zVar2, sb3);
                }
                c2(zVar2, sb3);
                if (D0()) {
                    x1(zVar2, sb3);
                } else {
                    p2(zVar2, sb3);
                }
                T1(zVar2, sb3);
                if (j1()) {
                    if (zVar2.v0()) {
                        sb3.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (zVar2.C0()) {
                        sb3.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb3.append(S1("fun"));
            sb3.append(" ");
            List typeParameters = zVar2.getTypeParameters();
            kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
            y2(typeParameters, sb3, true);
            j2(zVar2, sb3);
        }
        Z1(zVar2, sb3, true);
        List listI = zVar2.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        C2(listI, zVar2.H(), sb3);
        k2(zVar2, sb3);
        r0 returnType = zVar2.getReturnType();
        if (!m1() && (h1() || returnType == null || !ce.i.D0(returnType))) {
            sb3.append(": ");
            sb3.append(returnType == null ? "[NULL]" : S(returnType));
        }
        List typeParameters2 = zVar2.getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters2, "getTypeParameters(...)");
        F2(typeParameters2, sb3);
    }

    @Override // hf.n
    public String Q(ef.d fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return O1(fqName.h());
    }

    public boolean Q0() {
        return this.f11367m.Q();
    }

    public final void Q1(StringBuilder sb2, r0 r0Var) {
        ef.f fVarD;
        int length = sb2.length();
        A1(C0(), sb2, r0Var, null, 2, null);
        boolean z10 = sb2.length() != length;
        r0 r0VarK = ce.h.k(r0Var);
        List listE = ce.h.e(r0Var);
        boolean zR = ce.h.r(r0Var);
        boolean zO0 = r0Var.O0();
        boolean z11 = zO0 || (z10 && r0VarK != null);
        if (z11) {
            if (zR) {
                sb2.insert(length, '(');
            } else {
                if (z10) {
                    kg.a.c(kg.e0.e1(sb2));
                    if (sb2.charAt(kg.c0.W(sb2) - 1) != ')') {
                        sb2.insert(kg.c0.W(sb2), "()");
                    }
                }
                sb2.append("(");
            }
        }
        if (!listE.isEmpty()) {
            sb2.append("context(");
            Iterator it = listE.subList(0, dd.r.m(listE)).iterator();
            while (it.hasNext()) {
                a2(sb2, (r0) it.next());
                sb2.append(", ");
            }
            a2(sb2, (r0) dd.a0.k0(listE));
            sb2.append(") ");
        }
        Y1(sb2, zR, "suspend");
        if (r0VarK != null) {
            boolean z12 = (G2(r0VarK) && !r0VarK.O0()) || q1(r0VarK) || (r0VarK instanceof xf.y);
            if (z12) {
                sb2.append("(");
            }
            a2(sb2, r0VarK);
            if (z12) {
                sb2.append(")");
            }
            sb2.append(".");
        }
        sb2.append("(");
        if (!ce.h.n(r0Var) || r0Var.L0().size() > 1) {
            int i10 = 0;
            for (a2 a2Var : ce.h.m(r0Var)) {
                int i11 = i10 + 1;
                if (i10 > 0) {
                    sb2.append(", ");
                }
                if (N0()) {
                    r0 type = a2Var.getType();
                    kotlin.jvm.internal.t.e(type, "getType(...)");
                    fVarD = ce.h.d(type);
                } else {
                    fVarD = null;
                }
                if (fVarD != null) {
                    sb2.append(R(fVarD, false));
                    sb2.append(": ");
                }
                sb2.append(T(a2Var));
                i10 = i11;
            }
        } else {
            sb2.append("???");
        }
        sb2.append(") ");
        sb2.append(p0());
        sb2.append(" ");
        a2(sb2, ce.h.l(r0Var));
        if (z11) {
            sb2.append(")");
        }
        if (zO0) {
            sb2.append("?");
        }
    }

    @Override // hf.n
    public String R(ef.f name, boolean z10) {
        kotlin.jvm.internal.t.f(name, "name");
        String strQ0 = q0(g0.b(name));
        if (!w0() || e1() != f0.f11337b || !z10) {
            return strQ0;
        }
        return "<b>" + strQ0 + "</b>";
    }

    public boolean R0() {
        return this.f11367m.R();
    }

    public final void R1(t1 t1Var, StringBuilder sb2) {
        lf.g gVarY;
        String strG1;
        if (!G0() || (gVarY = t1Var.Y()) == null || (strG1 = G1(gVarY)) == null) {
            return;
        }
        sb2.append(" = ");
        sb2.append(q0(strG1));
    }

    @Override // hf.n
    public String S(r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
        StringBuilder sb2 = new StringBuilder();
        a2(sb2, (r0) f1().invoke(type));
        return sb2.toString();
    }

    public boolean S0() {
        return this.f11367m.S();
    }

    public final String S1(String str) {
        int i10 = b.f11371a[e1().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                throw new cd.o();
            }
            if (!w0()) {
                return "<b>" + str + "</b>";
            }
        }
        return str;
    }

    @Override // hf.n
    public String T(a2 typeProjection) throws IOException {
        kotlin.jvm.internal.t.f(typeProjection, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        n0(sb2, dd.q.e(typeProjection));
        return sb2.toString();
    }

    public boolean T0() {
        return this.f11367m.T();
    }

    public final void T1(fe.b bVar, StringBuilder sb2) {
        if (I0().contains(v.f11381j) && j1() && bVar.h() != b.a.DECLARATION) {
            sb2.append("/*");
            sb2.append(fg.a.f(bVar.h().name()));
            sb2.append("*/ ");
        }
    }

    public boolean U0() {
        return this.f11367m.U();
    }

    public final void U1(fe.d0 d0Var, StringBuilder sb2) {
        Y1(sb2, d0Var.isExternal(), "external");
        boolean z10 = false;
        Y1(sb2, I0().contains(v.f11384m) && d0Var.N(), "expect");
        if (I0().contains(v.f11385n) && d0Var.E0()) {
            z10 = true;
        }
        Y1(sb2, z10, "actual");
    }

    public boolean V0() {
        return this.f11367m.V();
    }

    public String V1(String message) {
        kotlin.jvm.internal.t.f(message, "message");
        int i10 = b.f11371a[e1().ordinal()];
        if (i10 == 1) {
            return message;
        }
        if (i10 != 2) {
            throw new cd.o();
        }
        return "<i>" + message + "</i>";
    }

    public boolean W0() {
        return this.f11367m.W();
    }

    public final void W1(fe.e0 e0Var, StringBuilder sb2, fe.e0 e0Var2) {
        if (W0() || e0Var != e0Var2) {
            Y1(sb2, I0().contains(v.f11377f), fg.a.f(e0Var.name()));
        }
    }

    public boolean X0() {
        return this.f11367m.X();
    }

    public final void X1(fe.b bVar, StringBuilder sb2) {
        if (jf.i.J(bVar) && bVar.l() == fe.e0.f9461b) {
            return;
        }
        if (L0() == c0.f11318a && bVar.l() == fe.e0.f9463d && u1(bVar)) {
            return;
        }
        fe.e0 e0VarL = bVar.l();
        kotlin.jvm.internal.t.e(e0VarL, "getModality(...)");
        W1(e0VarL, sb2, r1(bVar));
    }

    public boolean Y0() {
        return this.f11367m.Y();
    }

    public final void Y1(StringBuilder sb2, boolean z10, String str) {
        if (z10) {
            sb2.append(S1(str));
            sb2.append(" ");
        }
    }

    public boolean Z0() {
        return this.f11367m.Z();
    }

    public final void Z1(fe.m mVar, StringBuilder sb2, boolean z10) {
        ef.f name = mVar.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        sb2.append(R(name, z10));
    }

    @Override // hf.w
    public void a(Set set) {
        kotlin.jvm.internal.t.f(set, "<set-?>");
        this.f11367m.a(set);
    }

    public boolean a1() {
        return this.f11367m.a0();
    }

    public final void a2(StringBuilder sb2, r0 r0Var) {
        l2 l2VarQ0 = r0Var.Q0();
        xf.a aVar = l2VarQ0 instanceof xf.a ? (xf.a) l2VarQ0 : null;
        if (aVar == null) {
            b2(sb2, r0Var);
            return;
        }
        if (Z0()) {
            b2(sb2, aVar.X());
            if (R0()) {
                v1(sb2, aVar);
                return;
            }
            return;
        }
        b2(sb2, aVar.Z0());
        if (a1()) {
            M1(sb2, aVar);
        }
    }

    @Override // hf.w
    public void b(boolean z10) {
        this.f11367m.b(z10);
    }

    public boolean b1() {
        return this.f11367m.b0();
    }

    public final void b2(StringBuilder sb2, r0 r0Var) {
        if ((r0Var instanceof n2) && n() && !((n2) r0Var).S0()) {
            sb2.append("<Not computed yet>");
            return;
        }
        l2 l2VarQ0 = r0Var.Q0();
        if (l2VarQ0 instanceof i0) {
            sb2.append(((i0) l2VarQ0).X0(this, this));
        } else {
            if (!(l2VarQ0 instanceof c1)) {
                throw new cd.o();
            }
            l2(sb2, (c1) l2VarQ0);
        }
    }

    @Override // hf.w
    public void c(Set set) {
        kotlin.jvm.internal.t.f(set, "<set-?>");
        this.f11367m.c(set);
    }

    public boolean c1() {
        return this.f11367m.c0();
    }

    public final void c2(fe.b bVar, StringBuilder sb2) {
        if (I0().contains(v.f11378g) && u1(bVar) && L0() != c0.f11319b) {
            Y1(sb2, true, "override");
            if (j1()) {
                sb2.append("/*");
                sb2.append(bVar.f().size());
                sb2.append("*/ ");
            }
        }
    }

    @Override // hf.w
    public void d(boolean z10) {
        this.f11367m.d(z10);
    }

    public boolean d1() {
        return this.f11367m.d0();
    }

    public final void d2(n0 n0Var, StringBuilder sb2) {
        e2(n0Var.e(), "package-fragment", sb2);
        if (n()) {
            sb2.append(" in ");
            Z1(n0Var.b(), sb2, false);
        }
    }

    @Override // hf.w
    public void e(hf.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<set-?>");
        this.f11367m.e(bVar);
    }

    public f0 e1() {
        return this.f11367m.e0();
    }

    public final void e2(ef.c cVar, String str, StringBuilder sb2) {
        sb2.append(S1(str));
        String strQ = Q(cVar.i());
        if (strQ.length() > 0) {
            sb2.append(" ");
            sb2.append(strQ);
        }
    }

    @Override // hf.w
    public boolean f() {
        return this.f11367m.f();
    }

    public pd.k f1() {
        return this.f11367m.f0();
    }

    public final void f2(u0 u0Var, StringBuilder sb2) {
        e2(u0Var.e(), "package", sb2);
        if (n()) {
            sb2.append(" in context of ");
            Z1(u0Var.u0(), sb2, false);
        }
    }

    @Override // hf.w
    public void g(d0 d0Var) {
        kotlin.jvm.internal.t.f(d0Var, "<set-?>");
        this.f11367m.g(d0Var);
    }

    public boolean g1() {
        return this.f11367m.g0();
    }

    public final void g2(StringBuilder sb2, w0 w0Var) {
        w0 w0VarC = w0Var.c();
        if (w0VarC != null) {
            g2(sb2, w0VarC);
            sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
            ef.f name = w0Var.b().getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            sb2.append(R(name, false));
        } else {
            u1 u1VarK = w0Var.b().k();
            kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
            sb2.append(s2(u1VarK));
        }
        sb2.append(r2(w0Var.a()));
    }

    @Override // hf.w
    public void h(boolean z10) {
        this.f11367m.h(z10);
    }

    public boolean h1() {
        return this.f11367m.h0();
    }

    public final void h2(y0 y0Var, StringBuilder sb2) throws IOException {
        y0 y0Var2;
        StringBuilder sb3;
        if (d1()) {
            y0Var2 = y0Var;
            sb3 = sb2;
        } else {
            if (!c1()) {
                List listP0 = y0Var.p0();
                kotlin.jvm.internal.t.e(listP0, "getContextReceiverParameters(...)");
                J1(listP0, sb2);
                i2(y0Var, sb2);
                fe.u visibility = y0Var.getVisibility();
                kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
                E2(visibility, sb2);
                boolean z10 = false;
                Y1(sb2, I0().contains(v.f11386o) && y0Var.A(), "const");
                U1(y0Var, sb2);
                X1(y0Var, sb2);
                c2(y0Var, sb2);
                if (I0().contains(v.f11387p) && y0Var.q0()) {
                    z10 = true;
                }
                Y1(sb2, z10, "lateinit");
                T1(y0Var, sb2);
            }
            y0Var2 = y0Var;
            sb3 = sb2;
            A2(this, y0Var2, sb3, false, 4, null);
            List typeParameters = y0Var2.getTypeParameters();
            kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
            y2(typeParameters, sb3, true);
            j2(y0Var2, sb3);
        }
        Z1(y0Var2, sb3, true);
        sb3.append(": ");
        r0 type = y0Var2.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        sb3.append(S(type));
        k2(y0Var2, sb3);
        R1(y0Var2, sb3);
        List typeParameters2 = y0Var2.getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters2, "getTypeParameters(...)");
        F2(typeParameters2, sb3);
    }

    @Override // hf.w
    public void i(boolean z10) {
        this.f11367m.i(z10);
    }

    public n.b i1() {
        return this.f11367m.i0();
    }

    public final void i2(y0 y0Var, StringBuilder sb2) {
        if (I0().contains(v.f11379h)) {
            A1(this, sb2, y0Var, null, 2, null);
            fe.w wVarO0 = y0Var.o0();
            if (wVarO0 != null) {
                z1(sb2, wVarO0, ge.e.f10539b);
            }
            fe.w wVarL0 = y0Var.l0();
            if (wVarL0 != null) {
                z1(sb2, wVarL0, ge.e.f10547j);
            }
            if (P0() == e0.f11332c) {
                z0 z0VarD = y0Var.d();
                if (z0VarD != null) {
                    z1(sb2, z0VarD, ge.e.f10542e);
                }
                a1 a1VarG = y0Var.g();
                if (a1VarG != null) {
                    z1(sb2, a1VarG, ge.e.f10543f);
                    List listI = a1VarG.i();
                    kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                    s1 s1Var = (s1) dd.a0.v0(listI);
                    kotlin.jvm.internal.t.c(s1Var);
                    z1(sb2, s1Var, ge.e.f10546i);
                }
            }
        }
    }

    @Override // hf.w
    public void j(f0 f0Var) {
        kotlin.jvm.internal.t.f(f0Var, "<set-?>");
        this.f11367m.j(f0Var);
    }

    public boolean j1() {
        return this.f11367m.j0();
    }

    public final void j2(fe.a aVar, StringBuilder sb2) {
        b1 b1VarK0 = aVar.k0();
        if (b1VarK0 != null) {
            z1(sb2, b1VarK0, ge.e.f10544g);
            r0 type = b1VarK0.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            sb2.append(N1(type));
            sb2.append(".");
        }
    }

    @Override // hf.w
    public void k(boolean z10) {
        this.f11367m.k(z10);
    }

    public boolean k1() {
        return this.f11367m.k0();
    }

    public final void k2(fe.a aVar, StringBuilder sb2) {
        b1 b1VarK0;
        if (Q0() && (b1VarK0 = aVar.k0()) != null) {
            sb2.append(" on ");
            r0 type = b1VarK0.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            sb2.append(S(type));
        }
    }

    @Override // hf.w
    public void l(boolean z10) {
        this.f11367m.l(z10);
    }

    public boolean l1() {
        return this.f11367m.l0();
    }

    public final void l2(StringBuilder sb2, c1 c1Var) {
        if (kotlin.jvm.internal.t.b(c1Var, i2.f24987b) || i2.k(c1Var)) {
            sb2.append("???");
            return;
        }
        if (zf.l.o(c1Var)) {
            if (!g1()) {
                sb2.append("???");
                return;
            }
            u1 u1VarN0 = c1Var.N0();
            kotlin.jvm.internal.t.d(u1VarN0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb2.append(L1(((zf.j) u1VarN0).g(0)));
            return;
        }
        if (xf.v0.a(c1Var)) {
            K1(sb2, c1Var);
        } else if (G2(c1Var)) {
            Q1(sb2, c1Var);
        } else {
            K1(sb2, c1Var);
        }
    }

    @Override // hf.w
    public Set m() {
        return this.f11367m.m();
    }

    public final void m0(StringBuilder sb2, fe.m mVar) {
        fe.m mVarB;
        String name;
        if ((mVar instanceof n0) || (mVar instanceof u0) || (mVarB = mVar.b()) == null || (mVarB instanceof fe.h0)) {
            return;
        }
        sb2.append(" ");
        sb2.append(V1("defined in"));
        sb2.append(" ");
        ef.d dVarM = jf.i.m(mVarB);
        kotlin.jvm.internal.t.e(dVarM, "getFqName(...)");
        sb2.append(dVarM.e() ? "root package" : Q(dVarM));
        if (l1() && (mVarB instanceof n0) && (mVar instanceof fe.p) && (name = ((fe.p) mVar).j().a().getName()) != null) {
            sb2.append(" ");
            sb2.append(V1("in file"));
            sb2.append(" ");
            sb2.append(name);
        }
    }

    public boolean m1() {
        return this.f11367m.m0();
    }

    public final void m2(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    @Override // hf.w
    public boolean n() {
        return this.f11367m.n();
    }

    public final void n0(StringBuilder sb2, List list) throws IOException {
        dd.a0.f0(list, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new q(this));
    }

    public boolean n1() {
        return this.f11367m.n0();
    }

    public final void n2(fe.e eVar, StringBuilder sb2) throws IOException {
        if (n1() || ce.i.o0(eVar.s())) {
            return;
        }
        Collection collectionC = eVar.k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        if (collectionC.isEmpty()) {
            return;
        }
        if (collectionC.size() == 1 && ce.i.c0((r0) collectionC.iterator().next())) {
            return;
        }
        m2(sb2);
        sb2.append(": ");
        dd.a0.f0(collectionC, sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new s(this));
    }

    @Override // hf.w
    public hf.a o() {
        return this.f11367m.o();
    }

    public boolean o1() {
        return this.f11367m.o0();
    }

    @Override // hf.w
    public void p(boolean z10) {
        this.f11367m.p(z10);
    }

    public final String p0() {
        int i10 = b.f11371a[e1().ordinal()];
        if (i10 == 1) {
            return q0("->");
        }
        if (i10 == 2) {
            return "&rarr;";
        }
        throw new cd.o();
    }

    public final String p1() {
        return q0(">");
    }

    public final void p2(fe.z zVar, StringBuilder sb2) {
        Y1(sb2, zVar.isSuspend(), "suspend");
    }

    public final String q0(String str) {
        return e1().b(str);
    }

    public final boolean q1(r0 r0Var) {
        return ce.h.r(r0Var) || !r0Var.getAnnotations().isEmpty();
    }

    public final void q2(k1 k1Var, StringBuilder sb2) {
        A1(this, sb2, k1Var, null, 2, null);
        fe.u visibility = k1Var.getVisibility();
        kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
        E2(visibility, sb2);
        U1(k1Var, sb2);
        sb2.append(S1("typealias"));
        sb2.append(" ");
        Z1(k1Var, sb2, true);
        List listV = k1Var.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        y2(listV, sb2, false);
        B1(k1Var, sb2);
        sb2.append(" = ");
        sb2.append(S(k1Var.f0()));
    }

    public final fe.e0 r1(fe.d0 d0Var) {
        if (d0Var instanceof fe.e) {
            return ((fe.e) d0Var).h() == fe.f.f9474c ? fe.e0.f9464e : fe.e0.f9461b;
        }
        fe.m mVarB = d0Var.b();
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar == null) {
            return fe.e0.f9461b;
        }
        if (!(d0Var instanceof fe.b)) {
            return fe.e0.f9461b;
        }
        fe.b bVar = (fe.b) d0Var;
        Collection collectionF = bVar.f();
        kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
        if (!collectionF.isEmpty() && eVar.l() != fe.e0.f9461b) {
            return fe.e0.f9463d;
        }
        if (eVar.h() != fe.f.f9474c || kotlin.jvm.internal.t.b(bVar.getVisibility(), fe.t.f9507a)) {
            return fe.e0.f9461b;
        }
        fe.e0 e0VarL = bVar.l();
        fe.e0 e0Var = fe.e0.f9464e;
        return e0VarL == e0Var ? e0Var : fe.e0.f9463d;
    }

    public String r2(List typeArguments) throws IOException {
        kotlin.jvm.internal.t.f(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t1());
        n0(sb2, typeArguments);
        sb2.append(p1());
        return sb2.toString();
    }

    public final boolean s1(ge.c cVar) {
        return kotlin.jvm.internal.t.b(cVar.e(), o.a.E);
    }

    public String s2(u1 typeConstructor) {
        kotlin.jvm.internal.t.f(typeConstructor, "typeConstructor");
        fe.h hVarB = typeConstructor.b();
        if ((hVarB instanceof l1) || (hVarB instanceof fe.e) || (hVarB instanceof k1)) {
            return E1(hVarB);
        }
        if (hVarB == null) {
            return typeConstructor instanceof q0 ? ((q0) typeConstructor).m(p.f11362a) : typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + hVarB.getClass()).toString());
    }

    public boolean t0() {
        return this.f11367m.u();
    }

    public final String t1() {
        return q0("<");
    }

    public boolean u0() {
        return this.f11367m.v();
    }

    public final boolean u1(fe.b bVar) {
        return !bVar.f().isEmpty();
    }

    public final void u2(StringBuilder sb2, r0 r0Var, u1 u1Var) {
        w0 w0VarD = p1.d(r0Var);
        if (w0VarD != null) {
            g2(sb2, w0VarD);
        } else {
            sb2.append(s2(u1Var));
            sb2.append(r2(r0Var.L0()));
        }
    }

    public pd.k v0() {
        return this.f11367m.w();
    }

    public final void v1(StringBuilder sb2, xf.a aVar) {
        f0 f0VarE1 = e1();
        f0 f0Var = f0.f11337b;
        if (f0VarE1 == f0Var) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* ");
        sb2.append("from: ");
        b2(sb2, aVar.Z0());
        sb2.append(" */");
        if (e1() == f0Var) {
            sb2.append("</i></font>");
        }
    }

    public boolean w0() {
        return this.f11367m.x();
    }

    public final void w1(x0 x0Var, StringBuilder sb2) {
        U1(x0Var, sb2);
    }

    public final void w2(l1 l1Var, StringBuilder sb2, boolean z10) {
        if (z10) {
            sb2.append(t1());
        }
        if (j1()) {
            sb2.append("/*");
            sb2.append(l1Var.getIndex());
            sb2.append("*/ ");
        }
        Y1(sb2, l1Var.G(), "reified");
        String strC = l1Var.o().c();
        boolean z11 = true;
        Y1(sb2, strC.length() > 0, strC);
        A1(this, sb2, l1Var, null, 2, null);
        Z1(l1Var, sb2, z10);
        int size = l1Var.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            r0 r0Var = (r0) l1Var.getUpperBounds().iterator().next();
            if (!ce.i.k0(r0Var)) {
                sb2.append(" : ");
                kotlin.jvm.internal.t.c(r0Var);
                sb2.append(S(r0Var));
            }
        } else if (z10) {
            for (r0 r0Var2 : l1Var.getUpperBounds()) {
                if (!ce.i.k0(r0Var2)) {
                    if (z11) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    kotlin.jvm.internal.t.c(r0Var2);
                    sb2.append(S(r0Var2));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb2.append(p1());
        }
    }

    public boolean x0() {
        return this.f11367m.y();
    }

    public final void x1(fe.z zVar, StringBuilder sb2) {
        boolean z10;
        boolean z11 = false;
        if (zVar.isOperator()) {
            Collection collectionF = zVar.f();
            kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
            if (!collectionF.isEmpty()) {
                Iterator it = collectionF.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((fe.z) it.next()).isOperator()) {
                        if (u0()) {
                            break;
                        }
                    }
                }
                z10 = false;
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (zVar.isInfix()) {
            Collection collectionF2 = zVar.f();
            kotlin.jvm.internal.t.e(collectionF2, "getOverriddenDescriptors(...)");
            if (collectionF2.isEmpty()) {
                z11 = true;
            } else {
                Iterator it2 = collectionF2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (((fe.z) it2.next()).isInfix()) {
                        if (u0()) {
                            break;
                        }
                    }
                }
            }
        }
        Y1(sb2, zVar.R(), "tailrec");
        p2(zVar, sb2);
        Y1(sb2, zVar.isInline(), "inline");
        Y1(sb2, z11, "infix");
        Y1(sb2, z10, "operator");
    }

    public final void x2(StringBuilder sb2, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w2((l1) it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    public hf.b y0() {
        return this.f11367m.z();
    }

    public final List y1(ge.c cVar) {
        fe.d dVarS;
        List listI;
        Map mapA = cVar.a();
        List listK = null;
        fe.e eVarL = V0() ? nf.e.l(cVar) : null;
        if (eVarL != null && (dVarS = eVarL.S()) != null && (listI = dVarS.i()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                if (((s1) obj).s0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((s1) it.next()).getName());
            }
            listK = arrayList2;
        }
        if (listK == null) {
            listK = dd.r.k();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listK) {
            if (!mapA.containsKey((ef.f) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(dd.s.u(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((ef.f) it2.next()).b() + " = ...");
        }
        Set<Map.Entry> setEntrySet = mapA.entrySet();
        ArrayList arrayList5 = new ArrayList(dd.s.u(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            ef.f fVar = (ef.f) entry.getKey();
            lf.g gVar = (lf.g) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fVar.b());
            sb2.append(" = ");
            sb2.append(!listK.contains(fVar) ? G1(gVar) : "...");
            arrayList5.add(sb2.toString());
        }
        return dd.a0.z0(dd.a0.s0(arrayList4, arrayList5));
    }

    public final void y2(List list, StringBuilder sb2, boolean z10) {
        if (o1() || list.isEmpty()) {
            return;
        }
        sb2.append(t1());
        x2(sb2, list);
        sb2.append(p1());
        if (z10) {
            sb2.append(" ");
        }
    }

    public pd.k z0() {
        return this.f11367m.A();
    }

    public final void z1(StringBuilder sb2, ge.a aVar, ge.e eVar) {
        if (I0().contains(v.f11379h)) {
            Set setM = aVar instanceof r0 ? m() : B0();
            pd.k kVarV0 = v0();
            for (ge.c cVar : aVar.getAnnotations()) {
                if (!dd.a0.R(setM, cVar.e()) && !s1(cVar) && (kVarV0 == null || ((Boolean) kVarV0.invoke(cVar)).booleanValue())) {
                    sb2.append(N(cVar, eVar));
                    if (A0()) {
                        sb2.append('\n');
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }

    public final void z2(t1 t1Var, StringBuilder sb2, boolean z10) {
        if (z10 || !(t1Var instanceof s1)) {
            sb2.append(S1(t1Var.i0() ? "var" : "val"));
            sb2.append(" ");
        }
    }
}
