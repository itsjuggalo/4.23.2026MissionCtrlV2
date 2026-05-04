package ce;

import ce.o;
import fe.a1;
import fe.h0;
import fe.n0;
import fe.y;
import fe.y0;
import fe.z0;
import he.a;
import he.c;
import ie.f0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.i2;
import xf.m2;
import xf.r0;
import xf.r1;
import xf.u0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ef.f f3900g = ef.f.o("<built-ins module>");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f3901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wf.i f3902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f3903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f3904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.g f3905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wf.n f3906f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Function0 {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection invoke() {
            return Arrays.asList(i.this.s().I0(o.A), i.this.s().I0(o.C), i.this.s().I0(o.D), i.this.s().I0(o.B));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Function0 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(l.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (l lVar : l.values()) {
                c1 c1VarR = i.this.r(lVar.m().b());
                c1 c1VarR2 = i.this.r(lVar.k().b());
                enumMap.put(lVar, c1VarR2);
                map.put(c1VarR, c1VarR2);
                map2.put(c1VarR2, c1VarR);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements pd.k {
        public c() {
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public fe.e invoke(ef.f fVar) {
            fe.h hVarE = i.this.t().e(fVar, ne.d.f17037d);
            if (hVarE == null) {
                throw new AssertionError("Built-in class " + o.A.b(fVar) + " is not found");
            }
            if (hVarE instanceof fe.e) {
                return (fe.e) hVarE;
            }
            throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + hVarE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f3910a;

        public d(f0 f0Var) {
            this.f3910a = f0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (i.this.f3901a == null) {
                i.this.f3901a = this.f3910a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + i.this.f3901a + " (attempting to reset to " + this.f3910a + ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f3912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f3913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f3914c;

        public /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        public static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i10 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public e(Map map, Map map2, Map map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f3912a = map;
            this.f3913b = map2;
            this.f3914c = map3;
        }
    }

    public i(wf.n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f3906f = nVar;
        this.f3904d = nVar.e(new a());
        this.f3903c = nVar.e(new b());
        this.f3905e = nVar.i(new c());
    }

    public static boolean A0(r0 r0Var) {
        if (r0Var == null) {
            a(131);
        }
        return j0(r0Var, o.a.K0.i());
    }

    public static r0 B(r0 r0Var, h0 h0Var) {
        ef.b bVarN;
        ef.b bVarA;
        fe.e eVarB;
        if (r0Var == null) {
            a(71);
        }
        if (h0Var == null) {
            a(72);
        }
        fe.h hVarB = r0Var.N0().b();
        if (hVarB == null) {
            return null;
        }
        s sVar = s.f4043a;
        if (!sVar.b(hVarB.getName()) || (bVarN = nf.e.n(hVarB)) == null || (bVarA = sVar.a(bVarN)) == null || (eVarB = y.b(h0Var, bVarA)) == null) {
            return null;
        }
        return eVarB.s();
    }

    public static boolean B0(r0 r0Var) {
        if (r0Var == null) {
            a(129);
        }
        return j0(r0Var, o.a.I0.i());
    }

    public static boolean C0(fe.m mVar) {
        if (mVar == null) {
            a(10);
        }
        while (mVar != null) {
            if (mVar instanceof n0) {
                return ((n0) mVar).e().h(o.f3972z);
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean D0(r0 r0Var) {
        if (r0Var == null) {
            a(142);
        }
        return n0(r0Var, o.a.f3983f);
    }

    public static boolean E0(r0 r0Var) {
        if (r0Var == null) {
            a(132);
        }
        return y0(r0Var) || B0(r0Var) || z0(r0Var) || A0(r0Var);
    }

    public static l O(r0 r0Var) {
        if (r0Var == null) {
            a(92);
        }
        fe.h hVarB = r0Var.N0().b();
        if (hVarB == null) {
            return null;
        }
        return Q(hVarB);
    }

    public static l Q(fe.m mVar) {
        if (mVar == null) {
            a(77);
        }
        if (o.a.M0.contains(mVar.getName())) {
            return (l) o.a.O0.get(jf.i.m(mVar));
        }
        return null;
    }

    public static l T(fe.m mVar) {
        if (mVar == null) {
            a(76);
        }
        if (o.a.L0.contains(mVar.getName())) {
            return (l) o.a.N0.get(jf.i.m(mVar));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r23) {
        /*
            Method dump skipped, instruction units count: 2232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ce.i.a(int):void");
    }

    public static boolean b0(fe.e eVar) {
        if (eVar == null) {
            a(108);
        }
        return e(eVar, o.a.f3975b);
    }

    public static boolean c0(r0 r0Var) {
        if (r0Var == null) {
            a(139);
        }
        return i0(r0Var, o.a.f3975b);
    }

    public static boolean d0(r0 r0Var) {
        if (r0Var == null) {
            a(88);
        }
        return i0(r0Var, o.a.f3989i);
    }

    public static boolean e(fe.h hVar, ef.d dVar) {
        if (hVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return hVar.getName().equals(dVar.j()) && dVar.equals(jf.i.m(hVar));
    }

    public static boolean e0(fe.e eVar) {
        if (eVar == null) {
            a(89);
        }
        return e(eVar, o.a.f3989i) || Q(eVar) != null;
    }

    public static boolean f0(r0 r0Var) {
        if (r0Var == null) {
            a(90);
        }
        return d0(r0Var) || r0(r0Var);
    }

    public static boolean g0(r0 r0Var) {
        if (r0Var == null) {
            a(110);
        }
        return j0(r0Var, o.a.f3991j);
    }

    public static boolean h0(fe.m mVar) {
        if (mVar == null) {
            a(9);
        }
        return jf.i.r(mVar, ce.c.class, false) != null;
    }

    public static boolean i0(r0 r0Var, ef.d dVar) {
        if (r0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return x0(r0Var.N0(), dVar);
    }

    public static boolean j0(r0 r0Var, ef.d dVar) {
        if (r0Var == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return i0(r0Var, dVar) && !r0Var.O0();
    }

    public static boolean k0(r0 r0Var) {
        if (r0Var == null) {
            a(141);
        }
        return q0(r0Var);
    }

    public static boolean l0(fe.m mVar) {
        if (mVar == null) {
            a(161);
        }
        if (mVar.a().getAnnotations().E(o.a.f4021y)) {
            return true;
        }
        if (mVar instanceof y0) {
            y0 y0Var = (y0) mVar;
            boolean zI0 = y0Var.i0();
            z0 z0VarD = y0Var.d();
            a1 a1VarG = y0Var.g();
            if (z0VarD != null && l0(z0VarD) && (!zI0 || (a1VarG != null && l0(a1VarG)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m0(fe.e eVar) {
        if (eVar == null) {
            a(158);
        }
        return e(eVar, o.a.f3996l0);
    }

    public static boolean n0(r0 r0Var, ef.d dVar) {
        if (r0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !r0Var.O0() && i0(r0Var, dVar);
    }

    public static boolean o0(r0 r0Var) {
        if (r0Var == null) {
            a(136);
        }
        return p0(r0Var) && !i2.l(r0Var);
    }

    public static boolean p0(r0 r0Var) {
        if (r0Var == null) {
            a(138);
        }
        return i0(r0Var, o.a.f3977c);
    }

    public static boolean q0(r0 r0Var) {
        if (r0Var == null) {
            a(140);
        }
        return c0(r0Var) && r0Var.O0();
    }

    public static boolean r0(r0 r0Var) {
        if (r0Var == null) {
            a(91);
        }
        fe.h hVarB = r0Var.N0().b();
        return (hVarB == null || Q(hVarB) == null) ? false : true;
    }

    public static boolean s0(fe.e eVar) {
        if (eVar == null) {
            a(96);
        }
        return T(eVar) != null;
    }

    public static boolean t0(r0 r0Var) {
        if (r0Var == null) {
            a(94);
        }
        return !r0Var.O0() && u0(r0Var);
    }

    public static boolean u0(r0 r0Var) {
        if (r0Var == null) {
            a(95);
        }
        fe.h hVarB = r0Var.N0().b();
        return (hVarB instanceof fe.e) && s0((fe.e) hVarB);
    }

    public static boolean v0(fe.e eVar) {
        if (eVar == null) {
            a(107);
        }
        return e(eVar, o.a.f3975b) || e(eVar, o.a.f3977c);
    }

    public static boolean w0(r0 r0Var) {
        return r0Var != null && n0(r0Var, o.a.f3987h);
    }

    public static boolean x0(u1 u1Var, ef.d dVar) {
        if (u1Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        fe.h hVarB = u1Var.b();
        return (hVarB instanceof fe.e) && e(hVarB, dVar);
    }

    public static boolean y0(r0 r0Var) {
        if (r0Var == null) {
            a(128);
        }
        return j0(r0Var, o.a.H0.i());
    }

    public static boolean z0(r0 r0Var) {
        if (r0Var == null) {
            a(130);
        }
        return j0(r0Var, o.a.J0.i());
    }

    public c1 A() {
        c1 c1VarS = S(l.f3926n);
        if (c1VarS == null) {
            a(62);
        }
        return c1VarS;
    }

    public c1 C() {
        c1 c1VarS = S(l.f3924l);
        if (c1VarS == null) {
            a(61);
        }
        return c1VarS;
    }

    public fe.e D(int i10) {
        return q(o.b(i10));
    }

    public c1 E() {
        c1 c1VarS = S(l.f3923k);
        if (c1VarS == null) {
            a(59);
        }
        return c1VarS;
    }

    public fe.e F() {
        fe.e eVarP = p(o.a.f3996l0.m());
        if (eVarP == null) {
            a(21);
        }
        return eVarP;
    }

    public void F0(f0 f0Var) {
        if (f0Var == null) {
            a(1);
        }
        this.f3906f.f(new d(f0Var));
    }

    public c1 G() {
        c1 c1VarS = S(l.f3925m);
        if (c1VarS == null) {
            a(60);
        }
        return c1VarS;
    }

    public fe.e H() {
        return q("Nothing");
    }

    public c1 I() {
        c1 c1VarS = H().s();
        if (c1VarS == null) {
            a(49);
        }
        return c1VarS;
    }

    public c1 J() {
        c1 c1VarU0 = i().R0(true);
        if (c1VarU0 == null) {
            a(52);
        }
        return c1VarU0;
    }

    public c1 K() {
        c1 c1VarU0 = I().R0(true);
        if (c1VarU0 == null) {
            a(50);
        }
        return c1VarU0;
    }

    public fe.e L() {
        return q("Number");
    }

    public c1 M() {
        c1 c1VarS = L().s();
        if (c1VarS == null) {
            a(56);
        }
        return c1VarS;
    }

    public he.c N() {
        c.b bVar = c.b.f11302a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    public c1 P(l lVar) {
        if (lVar == null) {
            a(73);
        }
        c1 c1Var = (c1) ((e) this.f3903c.invoke()).f3912a.get(lVar);
        if (c1Var == null) {
            a(74);
        }
        return c1Var;
    }

    public final fe.e R(l lVar) {
        if (lVar == null) {
            a(16);
        }
        return q(lVar.m().b());
    }

    public c1 S(l lVar) {
        if (lVar == null) {
            a(54);
        }
        c1 c1VarS = R(lVar).s();
        if (c1VarS == null) {
            a(55);
        }
        return c1VarS;
    }

    public c1 U() {
        c1 c1VarS = S(l.f3922j);
        if (c1VarS == null) {
            a(58);
        }
        return c1VarS;
    }

    public wf.n V() {
        wf.n nVar = this.f3906f;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    public fe.e W() {
        return q("String");
    }

    public c1 X() {
        c1 c1VarS = W().s();
        if (c1VarS == null) {
            a(66);
        }
        return c1VarS;
    }

    public fe.e Y(int i10) {
        fe.e eVarP = p(o.f3965s.b(ef.f.k(o.d(i10))));
        if (eVarP == null) {
            a(18);
        }
        return eVarP;
    }

    public fe.e Z() {
        return q("Unit");
    }

    public c1 a0() {
        c1 c1VarS = Z().s();
        if (c1VarS == null) {
            a(65);
        }
        return c1VarS;
    }

    public void f(boolean z10) {
        f0 f0Var = new f0(f3900g, this.f3906f, this, null);
        this.f3901a = f0Var;
        f0Var.O0(ce.b.f3892a.c().a(this.f3906f, this.f3901a, w(), N(), g(), z10));
        f0 f0Var2 = this.f3901a;
        f0Var2.W0(f0Var2);
    }

    public he.a g() {
        a.C0208a c0208a = a.C0208a.f11300a;
        if (c0208a == null) {
            a(3);
        }
        return c0208a;
    }

    public fe.e h() {
        return q("Any");
    }

    public c1 i() {
        c1 c1VarS = h().s();
        if (c1VarS == null) {
            a(51);
        }
        return c1VarS;
    }

    public fe.e j() {
        return q("Array");
    }

    public r0 k(r0 r0Var) {
        if (r0Var == null) {
            a(68);
        }
        r0 r0VarL = l(r0Var);
        if (r0VarL != null) {
            return r0VarL;
        }
        throw new IllegalStateException("not array: " + r0Var);
    }

    public r0 l(r0 r0Var) {
        r0 r0VarB;
        if (r0Var == null) {
            a(70);
        }
        if (d0(r0Var)) {
            if (r0Var.L0().size() != 1) {
                return null;
            }
            return ((a2) r0Var.L0().get(0)).getType();
        }
        r0 r0VarN = i2.n(r0Var);
        r0 r0Var2 = (r0) ((e) this.f3903c.invoke()).f3914c.get(r0VarN);
        if (r0Var2 != null) {
            return r0Var2;
        }
        h0 h0VarI = jf.i.i(r0VarN);
        if (h0VarI == null || (r0VarB = B(r0VarN, h0VarI)) == null) {
            return null;
        }
        return r0VarB;
    }

    public c1 m(m2 m2Var, r0 r0Var) {
        if (m2Var == null) {
            a(82);
        }
        if (r0Var == null) {
            a(83);
        }
        c1 c1VarN = n(m2Var, r0Var, ge.h.L.b());
        if (c1VarN == null) {
            a(84);
        }
        return c1VarN;
    }

    public c1 n(m2 m2Var, r0 r0Var, ge.h hVar) {
        if (m2Var == null) {
            a(78);
        }
        if (r0Var == null) {
            a(79);
        }
        if (hVar == null) {
            a(80);
        }
        c1 c1VarH = u0.h(r1.b(hVar), j(), Collections.singletonList(new c2(m2Var, r0Var)));
        if (c1VarH == null) {
            a(81);
        }
        return c1VarH;
    }

    public c1 o() {
        c1 c1VarS = S(l.f3919g);
        if (c1VarS == null) {
            a(64);
        }
        return c1VarS;
    }

    public fe.e p(ef.c cVar) {
        if (cVar == null) {
            a(12);
        }
        fe.e eVarD = fe.s.d(s(), cVar, ne.d.f17037d);
        if (eVarD == null) {
            a(13);
        }
        return eVarD;
    }

    public final fe.e q(String str) {
        if (str == null) {
            a(14);
        }
        fe.e eVar = (fe.e) this.f3905e.invoke(ef.f.k(str));
        if (eVar == null) {
            a(15);
        }
        return eVar;
    }

    public final c1 r(String str) {
        if (str == null) {
            a(47);
        }
        c1 c1VarS = q(str).s();
        if (c1VarS == null) {
            a(48);
        }
        return c1VarS;
    }

    public f0 s() {
        if (this.f3901a == null) {
            this.f3901a = (f0) this.f3902b.invoke();
        }
        f0 f0Var = this.f3901a;
        if (f0Var == null) {
            a(7);
        }
        return f0Var;
    }

    public qf.k t() {
        qf.k kVarQ = s().I0(o.A).q();
        if (kVarQ == null) {
            a(11);
        }
        return kVarQ;
    }

    public c1 u() {
        c1 c1VarS = S(l.f3921i);
        if (c1VarS == null) {
            a(57);
        }
        return c1VarS;
    }

    public c1 v() {
        c1 c1VarS = S(l.f3920h);
        if (c1VarS == null) {
            a(63);
        }
        return c1VarS;
    }

    public Iterable w() {
        List listSingletonList = Collections.singletonList(new de.a(this.f3906f, s()));
        if (listSingletonList == null) {
            a(5);
        }
        return listSingletonList;
    }

    public fe.e x() {
        fe.e eVarP = p(o.a.X);
        if (eVarP == null) {
            a(35);
        }
        return eVarP;
    }

    public fe.e y() {
        return q("Comparable");
    }

    public c1 z() {
        c1 c1VarJ = J();
        if (c1VarJ == null) {
            a(53);
        }
        return c1VarJ;
    }
}
